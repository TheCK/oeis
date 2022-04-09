package org.ck.oeis.common;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;

public class FirstOfLengthSeries implements Iterator<BigInteger> {
  private final Iterator<BigInteger> source;
  private int length = 0;

  public FirstOfLengthSeries(Series source) {
    this.source = source.asStream().iterator();
  }

  @Override
  public boolean hasNext() {
    return source.hasNext();
  }

  @Override
  public BigInteger next() {
    BigInteger next = source.next();

    while (next.toString().length() <= length) {
      next = source.next();
    }

    length = next.toString().length();
    return next;
  }
}
