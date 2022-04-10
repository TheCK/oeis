package org.ck.oeis.series.a097;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A097480 extends Series {
  private static final BigInteger NINE = BigInteger.valueOf(9);
  private static final BigInteger MINUS_FIFTEEN = BigInteger.valueOf(-15);

  public A097480() {
    super("Positive integers n such that 2n-15 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(NINE, BigInteger.TWO, MINUS_FIFTEEN), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
