package org.ck.oeis.series.a097;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A097932 extends Series {
  private static final BigInteger ELEVEN = BigInteger.valueOf(11);
  private static final BigInteger MINUS_NINETEEN = BigInteger.valueOf(-19);

  public A097932() {
    super("Positive integers n such that 2n-19 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(ELEVEN, BigInteger.TWO, MINUS_NINETEEN), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
