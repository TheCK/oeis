package org.ck.oeis.series.a282;

import org.ck.oeis.Series;
import org.ck.oeis.common.PowerPrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A282458 extends Series {
  private static final BigInteger SEVEN_HUNDRED_FORTY_SIX = BigInteger.valueOf(746);
  private static final BigInteger NINE = BigInteger.valueOf(9);

  public A282458() {
    super("Numbers k such that (746*10^k + 1)/9 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PowerPrimeSeries(
                BigInteger.ZERO, SEVEN_HUNDRED_FORTY_SIX, BigInteger.TEN, BigInteger.ONE, NINE),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
