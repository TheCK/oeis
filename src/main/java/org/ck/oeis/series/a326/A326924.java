package org.ck.oeis.series.a326;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FiniteSeries;
import org.ck.oeis.common.resources.ResourceScanner;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A326924 extends Series {
  private static final BigInteger[] values =
      ResourceScanner.resourceAsBigIntegerArray(A326924.class.getResourceAsStream("A326924"));

  public A326924() {
    super(
        "Squares visited by a knight on a spirally numbered board, moving always to the unvisited square closest to the origin.");
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
