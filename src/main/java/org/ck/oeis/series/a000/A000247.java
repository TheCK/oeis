package org.ck.oeis.series.a000;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000247 extends Series {
  public A000247() {
    super("a(n) = 2^n - n - 2.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger n = BigInteger.TWO;
              BigInteger twoToN = BigInteger.valueOf(4);

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                BigInteger tmp = twoToN.subtract(n).subtract(BigInteger.TWO);
                n = n.add(BigInteger.ONE);
                twoToN = twoToN.multiply(BigInteger.TWO);
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
