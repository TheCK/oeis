package org.ck.oeis.series.a001;

import org.ck.oeis.OEIS;
import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FunctionOfOtherSeriesSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A001016 extends Series {
  public A001016() {
    super("Eighth powers: a(n) = n^8.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            FunctionOfOtherSeriesSeries.of(OEIS.get("A001477"), number -> number.pow(8)),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
