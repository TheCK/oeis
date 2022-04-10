package org.ck.oeis.series.a089;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A089192 extends Series {
  private static final BigInteger FIVE = BigInteger.valueOf(5);
  private static final BigInteger MINUS_SEVEN = BigInteger.valueOf(-7);

  public A089192() {
    super("Numbers n such that 2n - 7 is a prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(FIVE, BigInteger.TWO, MINUS_SEVEN), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
