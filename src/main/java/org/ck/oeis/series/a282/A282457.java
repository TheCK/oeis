package org.ck.oeis.series.a282;

import org.ck.oeis.Series;
import org.ck.oeis.common.PowerPrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A282457 extends Series {
  private static final BigInteger SEVEN = BigInteger.valueOf(7);
  private static final BigInteger MINUS_FORTY_SEVEN = BigInteger.valueOf(-47);

  public A282457() {
    super("Numbers k such that 7*10^k - 47 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PowerPrimeSeries(
                BigInteger.ZERO, SEVEN, BigInteger.TEN, MINUS_FORTY_SEVEN, BigInteger.ONE),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
