package org.ck.oeis.series.a328;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FiniteSeries;
import org.ck.oeis.common.resources.ResourceScanner;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A328698 extends Series {
  private static final BigInteger[] values =
      ResourceScanner.resourceAsBigIntegerArray(A328698.class.getResourceAsStream("A328698"));

  public A328698() {
    super(
        "Successive squares visited by a knight on the single-digit square spiral, with ties resolved by rotating left from direction of the last leap.");
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
