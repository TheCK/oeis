package org.ck.oeis.series.a326;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FiniteSeries;
import org.ck.oeis.common.resources.ResourceScanner;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A326918 extends Series {
  private static final BigInteger[] values =
      ResourceScanner.resourceAsBigIntegerArray(A326918.class.getResourceAsStream("A326918"));

  public A326918() {
    super(
        "Squares visited by a knight moving on a single-digit square-spiral numbered board where the knight moves to the smallest numbered unvisited square; the minimum distance from the origin is used if the square numbers are equal; the smallest spiral number ordering is used if the distances are equal.");
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
