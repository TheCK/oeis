package org.ck.oeis;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTest {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_PURPLE = "\u001B[35m";

  private static final Map<String, List<BigInteger>> expected = new HashMap<>();
  private static final char[] units = new char[] {'n', 'μ', 'm', ' '};
  private static final String[] colors =
      new String[] {ANSI_PURPLE, ANSI_GREEN, ANSI_YELLOW, ANSI_RED};

  @BeforeAll
  public static void setUp() {
    final InputStream stripped = TestTest.class.getResourceAsStream("stripped");

    try (Scanner in = new Scanner(stripped)) {
      in.nextLine();
      in.nextLine();
      in.nextLine();
      in.nextLine();

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(",");

        expected.put(
            line[0].trim(), Arrays.stream(line).skip(1).limit(10).map(BigInteger::new).toList());
      }
    }
  }

  @Test
  public void testAll() {
    int count = 0;
    long begin = System.nanoTime();

    for (int i = 1; i < 320000; ++i) {
      try {
        final Series series = OEIS.get(String.format("A%06d", i));

        final long start = System.nanoTime();
        List<BigInteger> result =
            series.asStream().limit(Math.min(expected.get(series.getName()).size(), 10)).toList();
        long time = System.nanoTime() - start;

        assertEquals(expected.get(series.getName()), result, series.getName());

        int unit = 0;
        while (time > 1000) {
          time /= 1000;
          ++unit;
        }

        System.out.printf(
            "%s%s (%03d%cs): %s%n", colors[unit], series.getName(), time, units[unit], result);

        ++count;
      } catch (IllegalArgumentException e) {
        // nothing
      }
    }

    System.out.printf(
        "%s%s series tested in %ds.%n",
        ANSI_RESET, count, (System.nanoTime() - begin) / 1000 / 1000 / 1000);
  }
}
