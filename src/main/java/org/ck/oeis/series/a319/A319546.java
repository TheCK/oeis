package org.ck.oeis.series.a319;

import org.ck.oeis.Series;
import org.ck.oeis.common.iterators.AlternatingPartialFactorialSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A319546 extends Series {
  public A319546() {
    super("a(n) = 1*2*3*4*5*6 - 7*8*9*10*11*12 + 13*14*15*16*17*18 - ... + (up to n).");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new AlternatingPartialFactorialSeries(6), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
