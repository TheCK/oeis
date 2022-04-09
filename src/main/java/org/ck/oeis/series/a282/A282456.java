package org.ck.oeis.series.a282;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PowerPrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A282456 extends Series {
  private static final BigInteger EIGHTEEN = BigInteger.valueOf(18);

  public A282456() {
    super("Numbers k such that 18*10^k + 1 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PowerPrimeSeries(
                BigInteger.ZERO, EIGHTEEN, BigInteger.TEN, BigInteger.ONE, BigInteger.ONE),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
