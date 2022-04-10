package org.ck.oeis.series.a089;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A089253 extends Series {
  private static final BigInteger MINUS_FIVE = BigInteger.valueOf(-5);

  public A089253() {
    super("Numbers n such that 2n - 5 is a prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(BigInteger.TWO, BigInteger.TWO, MINUS_FIVE), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
