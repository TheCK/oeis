package org.ck.oeis.series.a319;

import org.ck.oeis.Series;
import org.ck.oeis.common.AlternatingPartialFactorialSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A319549 extends Series {
  public A319549() {
    super(
        "a(n) = 1*2*3*4*5*6*7*8 - 9*10*11*12*13*14*15*16 + 17*18*19*20*21*22*23*24 - ... + (up to n).");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new AlternatingPartialFactorialSeries(8), Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
