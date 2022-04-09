package org.ck.oeis.series.a000;

import org.ck.oeis.Series;
import org.ck.oeis.common.BeattySeries;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000201 extends Series {
  private static final BigDecimal PHI =
      BigDecimal.ONE
          .add(BigDecimal.valueOf(5).sqrt(MathContext.DECIMAL128))
          .divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);

  public A000201() {
    super(
        "Lower Wythoff sequence (a Beatty sequence): a(n) = floor(n*phi), where phi = (1+sqrt(5))/2 = A001622.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(new BeattySeries(PHI), Spliterator.IMMUTABLE), false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
