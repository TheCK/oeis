package org.ck.oeis.series.a098;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A098090 extends Series {
  private static final BigInteger MINUS_THREE = BigInteger.valueOf(-3);

  public A098090() {
    super("Numbers k such that 2k-3 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(BigInteger.ONE, BigInteger.TWO, MINUS_THREE), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
