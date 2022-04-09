package org.ck.oeis.series.a000;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.DigitSquaresSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000221 extends Series {
  public A000221() {
    super("Take sum of squares of digits of previous term; start with 5.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new DigitSquaresSeries(BigInteger.valueOf(5)), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
