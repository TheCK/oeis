package org.ck.oeis.series.a000;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000040 extends Series {
  public A000040() {
    super("The prime numbers.");
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
                  boolean prime = true;

                  for (BigInteger i = BigInteger.TWO;
                      i.compareTo(candidate.sqrt()) <= 0;
                      i = i.add(BigInteger.ONE)) {
                    if (candidate.remainder(i).compareTo(BigInteger.ZERO) == 0) {
                      prime = false;
                      break;
                    }
                  }

                  if (prime) {
                    BigInteger tmp = candidate;
                    candidate = candidate.add(BigInteger.ONE);
                    return tmp;
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
