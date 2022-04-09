package org.ck.oeis.series.a000;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000655 extends Series {
  private static final BigInteger THREE = BigInteger.valueOf(3);
  private static final BigInteger FOUR = BigInteger.valueOf(4);
  private static final BigInteger FIVE = BigInteger.valueOf(5);

  private static final Map<BigInteger, BigInteger> map =
      new HashMap<>() {
        {
          put(BigInteger.ONE, THREE);
          put(THREE, FIVE);
          put(FOUR, FOUR);
          put(FIVE, FOUR);
        }
      };

  public A000655() {
    super("a(n) = number of letters in a(n-1), a(1) = 1 (in English).");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger current = BigInteger.ONE;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                BigInteger tmp = current;
                current = map.get(current);
                return tmp;
              }
            },
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
