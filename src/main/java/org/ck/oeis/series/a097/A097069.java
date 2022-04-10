package org.ck.oeis.series.a097;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A097069 extends Series {
  private static final BigInteger FIVE = BigInteger.valueOf(5);
  private static final BigInteger MINUS_NINE = BigInteger.valueOf(-9);

  public A097069() {
    super("Positive integers n such that 2n - 9 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(FIVE, BigInteger.TWO, MINUS_NINE), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
