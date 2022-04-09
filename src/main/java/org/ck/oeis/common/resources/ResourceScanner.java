package org.ck.oeis.common.resources;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResourceScanner {
  public static final BigInteger[] resourceAsBigIntegerArray(InputStream inputStream) {
    try (Scanner scanner = new Scanner(inputStream)) {
      List<BigInteger> values = new ArrayList<>();

      while (scanner.hasNextLine()) {
        values.add(new BigInteger(scanner.nextLine()));
      }

      return values.toArray(new BigInteger[] {});
    }
  }
}
