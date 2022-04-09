package org.ck.oeis.series.a000;

import org.ck.oeis.Series;
import org.ck.oeis.common.SumSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000204 extends Series {
  public A000204() {
    super("Lucas numbers (beginning with 1): L(n) = L(n-1) + L(n-2) with L(1) = 1, L(2) = 3.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new SumSeries(
                new BigInteger[] {BigInteger.ONE, BigInteger.valueOf(3)},
                new BigInteger[] {BigInteger.ONE, BigInteger.ONE},
                BigInteger.ZERO),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
