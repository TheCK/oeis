package org.ck.oeis.series.a316;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.MissingFromFiniteSeriesSeries;
import org.ck.oeis.common.resources.ResourceScanner;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A316336 extends Series {
  private static final BigInteger[] values =
      ResourceScanner.resourceAsBigIntegerArray(A316334.class.getResourceAsStream("A316334"));

  public A316336() {
    super("Numbers missing from A316334.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliterator(
            MissingFromFiniteSeriesSeries.of(BigInteger.ONE, values),
            values.length,
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return values.length;
  }
}
