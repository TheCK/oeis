package org.ck.oeis.series.a030;

import org.ck.oeis.OEIS;
import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FunctionOfOtherSeriesSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A030078 extends Series {
  public A030078() {
    super("Cubes of primes.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            FunctionOfOtherSeriesSeries.of(OEIS.get("A000040"), number -> number.pow(3)),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
