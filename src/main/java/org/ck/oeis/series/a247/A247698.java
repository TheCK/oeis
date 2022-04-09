package org.ck.oeis.series.a247;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.SumSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A247698 extends Series {
  public A247698() {
    super("Brady numbers: B(n) = B(n - 1) + B(n - 2) with B(1) = 2308 and  B(2) = 4261.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new SumSeries(
                new BigInteger[] {BigInteger.valueOf(2308), BigInteger.valueOf(4261)},
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
