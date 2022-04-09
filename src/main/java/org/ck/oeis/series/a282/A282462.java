package org.ck.oeis.series.a282;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A282462 extends Series {
  public A282462() {
    super("Integers but with the primes cubed.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger candidate = BigInteger.ZERO;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {

                BigInteger tmp = candidate;
                candidate = candidate.add(BigInteger.ONE);

                if (tmp.isProbablePrime(20)) {
                  return tmp.multiply(tmp).multiply(tmp);
                }

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
