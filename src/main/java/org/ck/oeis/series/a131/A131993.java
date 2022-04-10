package org.ck.oeis.series.a131;

import org.ck.oeis.OEIS;
import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FunctionOfOtherSeriesSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A131993 extends Series {
  public A131993() {
    super("1 + prime(n) + prime(n)^2 + prime(n)^3 + prime(n)^4 + prime(n)^5.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            FunctionOfOtherSeriesSeries.of(
                OEIS.get("A000040"),
                number ->
                    number
                        .pow(5)
                        .add(number.pow(4))
                        .add(number.pow(3))
                        .add(number.pow(2))
                        .add(number)
                        .add(BigInteger.ONE)),
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
