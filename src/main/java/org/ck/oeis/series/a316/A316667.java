package org.ck.oeis.series.a316;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FiniteSeries;
import org.ck.oeis.common.resources.ResourceScanner;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A316667 extends Series {
  private static final BigInteger[] values =
      ResourceScanner.resourceAsBigIntegerArray(A316667.class.getResourceAsStream("A316667"));

  public A316667() {
    super(
        "Squares visited by a knight moving on a spirally numbered board always to the lowest available unvisited square.");
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
