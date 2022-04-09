package org.ck.oeis.common;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;

public class LastOfLengthSeries implements Iterator<BigInteger> {
  private final Iterator<BigInteger> source;
  private int length = 0;
  private BigInteger last = null;

  public LastOfLengthSeries(Series source) {
    this.source = source.asStream().iterator();
  }

  @Override
  public boolean hasNext() {
    return source.hasNext();
  }

  @Override
  public BigInteger next() {
    BigInteger next = source.next();

    if (last == null) {
      last = next;
      length = next.toString().length();
    }

    while (next.toString().length() <= length) {
      last = next;
      next = source.next();
    }

    BigInteger tmp = last;
    last = next;
    length = next.toString().length();
    return tmp;
  }
}
