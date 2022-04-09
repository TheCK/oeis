package org.ck.oeis.series.a319;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.BasePalindromeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A319584 extends Series {
  public A319584() {
    super("Numbers that are palindromic in bases 2, 4, and 8.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new BasePalindromeSeries(2, 4, 8), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
