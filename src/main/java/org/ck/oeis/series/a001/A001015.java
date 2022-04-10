package org.ck.oeis.series.a001;

import org.ck.oeis.OEIS;
import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FunctionOfOtherSeriesSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A001015 extends Series {
  public A001015() {
    super("Seventh powers: a(n) = n^7.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            FunctionOfOtherSeriesSeries.of(OEIS.get("A001477"), number -> number.pow(7)),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
