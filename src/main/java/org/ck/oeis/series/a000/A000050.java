package org.ck.oeis.series.a000;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

// defunct
class A000050 extends Series {
  public A000050() {
    super("Number of positive integers <= 2^n of form x^2 + y^2.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliterator(
            new BigInteger[] {
              BigInteger.valueOf(1),
              BigInteger.valueOf(2),
              BigInteger.valueOf(3),
              BigInteger.valueOf(5),
              BigInteger.valueOf(9),
              BigInteger.valueOf(16),
              BigInteger.valueOf(29),
              BigInteger.valueOf(54),
              BigInteger.valueOf(97),
              BigInteger.valueOf(180)
            },
            0),
        false);
    /*return StreamSupport.stream(
    Spliterators.spliteratorUnknownSize(
        new Iterator<>() {
          long current = 1;

          @Override
          public boolean hasNext() {
            return true;
          }

          @Override
          public BigInteger next() {
            BigInteger count = BigInteger.ZERO;
            BigInteger limit = BigInteger.valueOf((long) Math.pow(2, current));

            long x = 1;
            while (true) {
              long y = 1;
              final BigInteger xSquared = BigInteger.valueOf(x).multiply(BigInteger.valueOf(x));

              if (xSquared.compareTo(limit) > 0) {
                break;
              }

              while (true) {
                BigInteger value =
                    xSquared.add(BigInteger.valueOf(y).multiply(BigInteger.valueOf(y)));

                if (value.compareTo(limit) <= 0) {
                  count = count.add(BigInteger.ONE);
                } else {
                  break;
                }

                ++y;
              }

              ++x;
            }

            ++current;
            return count;
          }
        },
        Spliterator.IMMUTABLE),
    false);*/
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
