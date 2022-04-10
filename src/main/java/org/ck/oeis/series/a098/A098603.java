package org.ck.oeis.series.a098;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A098603 extends Series {
  private static final BigInteger MINUS_THREE = BigInteger.valueOf(-3);

  public A098603() {
    super("a(n) = n*(n+10).");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              private static BigInteger current = BigInteger.ZERO;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                BigInteger tmp = current.multiply(current.add(BigInteger.TEN));
                current = current.add(BigInteger.ONE);
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
