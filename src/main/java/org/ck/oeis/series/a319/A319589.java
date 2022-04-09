package org.ck.oeis.series.a319;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FiniteSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A319589 extends Series {
  private static final long[] values =
      new long[] {34969, 83521, 7585, 14641, 42025, 69409, 76465, 529, 49081};

  public A319589() {
    super("A 3 X 3 magic square with five square entries, read by rows.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliterator(FiniteSeries.of(values), values.length, Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
