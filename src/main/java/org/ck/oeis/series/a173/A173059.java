package org.ck.oeis.series.a173;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A173059 extends Series {
  private static final BigInteger SEVENTEEN = BigInteger.valueOf(17);

  public A173059() {
    super("Nonnegative numbers n such that 2*n + 17 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(BigInteger.ZERO, BigInteger.TWO, SEVENTEEN), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
