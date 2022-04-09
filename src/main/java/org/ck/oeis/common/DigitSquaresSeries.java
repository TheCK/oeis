package org.ck.oeis.common;

import java.math.BigInteger;
import java.util.Iterator;

public class DigitSquaresSeries implements Iterator<BigInteger> {
  private BigInteger current;

  public DigitSquaresSeries(BigInteger init) {
    this.current = init;
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public BigInteger next() {
    BigInteger tmp = current;
    current = next(current.toString());
    return tmp;
  }

  private BigInteger next(final String number) {
    BigInteger next = BigInteger.ZERO;

    for (int i = 0; i < number.length(); ++i) {
      BigInteger digit = new BigInteger(number.substring(i, i + 1));

      next = next.add(digit.multiply(digit));
    }

    return next;
  }
}
