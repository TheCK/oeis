package org.ck.oeis.series.a175;

import org.ck.oeis.OEIS;
import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FunctionOfOtherSeriesSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A175221 extends Series {
  private static final BigInteger FOUR = BigInteger.valueOf(4);

  public A175221() {
    super("a(n) = prime(n) + 4.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
                FunctionOfOtherSeriesSeries.of(OEIS.get("A000040"), number -> number.add(FOUR)),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
