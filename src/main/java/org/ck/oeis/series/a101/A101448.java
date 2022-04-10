package org.ck.oeis.series.a101;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A101448 extends Series {
  private static final BigInteger ELEVEN = BigInteger.valueOf(11);

  public A101448() {
    super("Nonnegative numbers k such that 2k + 11 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(BigInteger.ZERO, BigInteger.TWO, ELEVEN), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
