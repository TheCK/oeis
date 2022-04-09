package org.ck.oeis.series.a000;

import org.ck.oeis.Series;
import org.ck.oeis.common.BeattySeries;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000210 extends Series {
  private static final BigDecimal E = BigDecimal.valueOf(Math.E).subtract(BigDecimal.ONE);

  public A000210() {
    super("A Beatty sequence: floor(n*(e-1)).");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(new BeattySeries(E), Spliterator.IMMUTABLE), false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
