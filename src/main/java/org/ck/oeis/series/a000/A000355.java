package org.ck.oeis.series.a000;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000355 extends Series {
  private static final BigInteger THREE = BigInteger.valueOf(3);
  private static final BigInteger NINE = BigInteger.valueOf(9);
  private static final BigInteger ELEVEN = BigInteger.valueOf(11);
  private static final BigInteger TWENTY = BigInteger.valueOf(20);

  public A000355() {
    super("Primes = 3, 9, 11 (mod 20) such that 2p+1 is also prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger candidate = BigInteger.TWO;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                while (true) {
                  if (candidate.isProbablePrime(20)) {
                    BigInteger remainder = candidate.remainder(TWENTY);

                    if (THREE.equals(remainder)
                        || NINE.equals(remainder)
                        || ELEVEN.equals(remainder)) {
                      BigInteger doublePlusOne =
                          candidate.multiply(BigInteger.TWO).add(BigInteger.ONE);

                      if (doublePlusOne.isProbablePrime(20)) {
                        BigInteger tmp = candidate;
                        candidate = candidate.add(BigInteger.ONE);
                        return tmp;
                      }
                    }
                  }

                  candidate = candidate.add(BigInteger.ONE);
                }
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
