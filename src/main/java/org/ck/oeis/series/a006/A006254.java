package org.ck.oeis.series.a006;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.PrimeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A006254 extends Series {
  private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);

  public A006254() {
    super("Numbers k such that 2k-1 is prime.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new PrimeSeries(BigInteger.ONE, BigInteger.TWO, MINUS_ONE), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
