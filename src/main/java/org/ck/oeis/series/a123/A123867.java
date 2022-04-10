package org.ck.oeis.series.a123;

import org.ck.oeis.OEIS;
import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FunctionOfOtherSeriesSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A123867 extends Series {
  public A123867() {
    super("a(n) = n^10 - 1.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            FunctionOfOtherSeriesSeries.of(
                OEIS.get("A008454"), number -> number.subtract(BigInteger.ONE), 1),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
