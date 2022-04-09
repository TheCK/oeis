package org.ck.oeis.series.a000;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000027 extends Series {
  public A000027() {
    super(
        "The positive integers. Also called the natural numbers, the whole numbers or the counting numbers, but these terms are ambiguous.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger current = BigInteger.ONE;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                BigInteger tmp = current;
                current = current.add(BigInteger.ONE);

                return tmp;
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
