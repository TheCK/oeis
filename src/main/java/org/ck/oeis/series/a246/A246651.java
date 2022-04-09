package org.ck.oeis.series.a246;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FiniteSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A246651 extends Series {
  private static final long[] values = new long[] {10, 7, 3, 6, 9, 2, 11, 5};

  public A246651() {
    super(
        "Red Squadron fighter numbers, in reported order, from the 1977 motion picture \"Star Wars\".");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliterator(FiniteSeries.of(values), values.length, Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return values.length;
  }
}
