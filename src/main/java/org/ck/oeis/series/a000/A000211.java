package org.ck.oeis.series.a000;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.SumSeries;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000211 extends Series {
  private static final BigDecimal E = BigDecimal.valueOf(Math.E).subtract(BigDecimal.ONE);

  public A000211() {
    super("a(n) = a(n-1) + a(n-2) - 2, a(0) = 4, a(1) = 3.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new SumSeries(
                new BigInteger[] {BigInteger.valueOf(4), BigInteger.valueOf(3)},
                new BigInteger[] {BigInteger.ONE, BigInteger.ONE},
                BigInteger.valueOf(-2)),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
