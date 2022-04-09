package org.ck.oeis.series.a316;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.MissingFromFiniteSeriesSeries;
import org.ck.oeis.common.resources.ResourceScanner;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A316335 extends Series {
  private static final BigInteger[] values =
      ResourceScanner.resourceAsBigIntegerArray(A316588.class.getResourceAsStream("A316588"));

  public A316335() {
    super("Numbers missing from A316588.");
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
