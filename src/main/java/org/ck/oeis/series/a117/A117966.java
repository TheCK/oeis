package org.ck.oeis.series.a117;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A117966 extends Series {
  private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
  private static final BigInteger THREE = BigInteger.valueOf(3);

  public A117966() {
    super(
        "Balanced ternary enumeration (based on balanced ternary representation) of integers; write n in ternary and then replace 2's with (-1)'s.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger current = MINUS_ONE;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                current = current.add(BigInteger.ONE);

                String ternary = current.toString(3);

                BigInteger value = BigInteger.ZERO;
                BigInteger power = BigInteger.ONE;
                for (int i = ternary.length() - 1; i >= 0; --i) {
                  if (ternary.charAt(i) != '2') {
                    value = value.add(power.multiply(BigInteger.valueOf(ternary.charAt(i) - '0')));
                  } else {
                    value = value.add(power.multiply(MINUS_ONE));
                  }

                  power = power.multiply(THREE);
                }

                return value;
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
