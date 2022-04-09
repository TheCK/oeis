package org.ck.oeis.series.a319;

import org.ck.oeis.Series;
import org.ck.oeis.common.BasePalindromeSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A319585 extends Series {
  public A319585() {
    super("Numbers in base 10 that are palindromic in bases 2, 8, and 16.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new BasePalindromeSeries(2, 8, 16), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
