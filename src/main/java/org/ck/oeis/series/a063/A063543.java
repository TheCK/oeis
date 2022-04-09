package org.ck.oeis.series.a063;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A063543 extends Series {
  public A063543() {
    super("a(n) = n - product of nonzero digits of n.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger current = BigInteger.ZERO;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                current = current.add(BigInteger.ONE);

                String decimal = current.toString();

                BigInteger value = current;
                for (int i = 0; i < decimal.length(); ++i) {
                  value = value.subtract(BigInteger.valueOf(decimal.charAt(i) - '0'));
                }

                return value;
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
