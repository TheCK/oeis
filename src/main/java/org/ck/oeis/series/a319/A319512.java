package org.ck.oeis.series.a319;

import org.ck.oeis.Series;
import org.ck.oeis.common.SumSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A319512 extends Series {
  public A319512() {
    super("a(n) = 7*a(n-1) - 14*a(n-2) + 7*a(n-3), a(0) = 1, a(1) = 3, a(2) = 11.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new SumSeries(
                new BigInteger[] {BigInteger.ONE, BigInteger.valueOf(3), BigInteger.valueOf(11)},
                new BigInteger[] {
                  BigInteger.valueOf(7), BigInteger.valueOf(-14), BigInteger.valueOf(7)
                },
                BigInteger.ZERO),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
