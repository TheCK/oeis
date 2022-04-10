package org.ck.oeis.series.a098;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A098605 extends Series {
  private static final BigInteger MINUS_SEVENTEEN = BigInteger.valueOf(-17);

  public A098605() {
    super("Positive integers n such that 2n - 17 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(BigInteger.TEN, BigInteger.TWO, MINUS_SEVENTEEN),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
