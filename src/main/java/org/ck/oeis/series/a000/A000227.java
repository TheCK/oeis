package org.ck.oeis.series.a000;

import org.ck.oeis.Series;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000227 extends Series {
  private static final BigDecimal E = BigDecimal.valueOf(Math.E);

  public A000227() {
    super("Nearest integer to e^n.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigDecimal current = BigDecimal.ONE;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                BigDecimal tmp = current;
                current = current.multiply(E);
                return tmp.setScale(0, RoundingMode.HALF_UP).toBigInteger();
              }
            },
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
