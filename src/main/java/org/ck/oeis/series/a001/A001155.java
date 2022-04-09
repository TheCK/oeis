package org.ck.oeis.series.a001;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A001155 extends Series {
  public A001155() {
    super("Describe the previous term! (method A - initial term is 0).");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger current = BigInteger.ZERO;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                BigInteger tmp = current;
                current = new BigInteger(count(current.toString()));
                return tmp;
              }

              private String count(final String number) {
                StringBuilder builder = new StringBuilder();

                char last = number.charAt(0);
                int count = 1;

                for (int i = 1; i < number.length(); ++i) {
                  if (number.charAt(i) == last) {
                    ++count;
                  } else {
                    builder.append(count);
                    builder.append(last);
                    last = number.charAt(i);
                    count = 1;
                  }
                }

                builder.append(count);
                builder.append(last);

                return builder.toString();
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
