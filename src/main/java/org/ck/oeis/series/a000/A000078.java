package org.ck.oeis.series.a000;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.SumSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000078 extends Series {
  public A000078() {
    super(
        "Tetranacci numbers: a(n) = a(n-1) + a(n-2) + a(n-3) + a(n-4) for n >= 4 with a(0) = a(1) = a(2) = 0 and a(3) = 1.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new SumSeries(
                new BigInteger[] {
                  BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE
                },
                new BigInteger[] {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ONE},
                BigInteger.ZERO),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
