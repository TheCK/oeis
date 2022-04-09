package org.ck.oeis.common;

import java.math.BigInteger;
import java.util.Iterator;

public class AlternatingPartialFactorialSeries implements Iterator<BigInteger> {
  private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);

  private final BigInteger length;
  private BigInteger finished = BigInteger.ZERO;
  private BigInteger unfinised = BigInteger.ZERO;
  private BigInteger current = BigInteger.ONE;

  public AlternatingPartialFactorialSeries(long length) {
    this.length = BigInteger.valueOf(length);
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public BigInteger next() {
    final BigInteger[] bigIntegers = current.divideAndRemainder(length);

    if (bigIntegers[1].equals(BigInteger.ONE)) {
      finished = finished.add(unfinised);
      unfinised = BigInteger.ONE;

      if (bigIntegers[0].mod(BigInteger.TWO).equals(BigInteger.ONE)) {
        unfinised = unfinised.multiply(MINUS_ONE);
      }
    }

    unfinised = unfinised.multiply(current);

    current = current.add(BigInteger.ONE);
    return finished.add(unfinised);
  }
}
