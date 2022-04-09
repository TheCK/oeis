package org.ck.oeis.series.a000;

import org.ck.oeis.Series;
import org.ck.oeis.common.SumSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000045 extends Series {
  public A000045() {
    super("Fibonacci numbers: F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new SumSeries(
                new BigInteger[] {BigInteger.ZERO, BigInteger.ONE},
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
