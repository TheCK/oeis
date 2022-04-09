package org.ck.oeis.series.a326;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FiniteSeries;
import org.ck.oeis.common.resources.ResourceScanner;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A326916 extends Series {
  private static final BigInteger[] values =
      ResourceScanner.resourceAsBigIntegerArray(A326916.class.getResourceAsStream("A326916"));

  public A326916() {
    super(
        "Trajectory of the knight's tour for choice of the square with the lowest digit, then closest to the origin, then first in the spiral.");
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
