package org.ck.oeis.series.a089;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A089038 extends Series {
  private static final BigInteger FIVE = BigInteger.valueOf(5);

  public A089038() {
    super("Nonnegative numbers k such that 2k+5 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(BigInteger.ZERO, BigInteger.TWO, FIVE), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
