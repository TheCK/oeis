package org.ck.oeis.series.a053;

import org.ck.oeis.OEIS;
import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.FunctionOfOtherSeriesSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A053699 extends Series {
  public A053699() {
    super("a(n) = n^4 + n^3 + n^2 + n + 1.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            FunctionOfOtherSeriesSeries.of(
                OEIS.get("A001477"),
                number ->
                    number
                        .pow(4)
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
