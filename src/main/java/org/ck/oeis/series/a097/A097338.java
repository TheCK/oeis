package org.ck.oeis.series.a097;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A097338 extends Series {
  private static final BigInteger SEVEN = BigInteger.valueOf(7);
  private static final BigInteger MINUS_ELEVEN = BigInteger.valueOf(-11);

  public A097338() {
    super("Positive integers n such that 2n-11 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(SEVEN, BigInteger.TWO, MINUS_ELEVEN), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
