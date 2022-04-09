package org.ck.oeis.series.a010;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A010751 extends Series {
  private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);

  public A010751() {
    super("Up once, down twice, up three times, down four times, ...");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger current = BigInteger.ZERO;
              BigInteger direction = BigInteger.ONE;
              BigInteger repetition = BigInteger.ONE;
              BigInteger remaining = BigInteger.ONE;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                BigInteger tmp = current;

                if (remaining.compareTo(BigInteger.ZERO) > 0) {
                  current = current.add(direction);
                  remaining = remaining.subtract(BigInteger.ONE);
                } else {
                  direction = direction.multiply(MINUS_ONE);
                  repetition = repetition.add(BigInteger.ONE);
                  remaining = repetition;

                  current = current.add(direction);
                  remaining = remaining.subtract(BigInteger.ONE);
                }

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
