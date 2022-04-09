package org.ck.oeis.series.a000;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FiniteSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000054 extends Series {
  private static final long[] values =
      new long[] {
        4, 14, 23, 34, 42, 50, 59, 72, 81, 86, 96, 103, 110, 116, 125, 135, 145, 155, 163, 168, 175,
        181, 190, 200, 207
      };

  public A000054() {
    super("Local stops on New York City A line subway.");
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
