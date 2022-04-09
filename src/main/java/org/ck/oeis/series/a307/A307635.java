package org.ck.oeis.series.a307;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A307635 extends Series {
  public A307635() {
    super(
        "a(0)=1; thereafter a(n) = largest number that can be obtained by  applying \"Choix de Bruxelles (version 2)\" (see A323460) to a(n-1).");
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
                current = next(current);
                return tmp;
              }

              private BigInteger next(final BigInteger current) {
                String decimal = current.toString();

                int val = 0;

                for (int i = decimal.length() - 1; i >= 0; --i) {
                  if (decimal.charAt(i) > '5') {
                    val = i;
                    break;
                  }
                }

                return new BigInteger(
                    decimal.substring(0, val)
                        + new BigInteger(decimal.substring(val)).multiply(BigInteger.TWO));
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
