package org.ck.oeis.common.iterators;

import java.math.BigInteger;
import java.util.Iterator;

public class BasePalindromeSeries implements Iterator<BigInteger> {
  private final int[] bases;
  private BigInteger current = BigInteger.ZERO;

  public BasePalindromeSeries(int... bases) {
    this.bases = bases;
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public BigInteger next() {
    while (!allPalindromic(current)) {
      current = current.add(BigInteger.ONE);
    }

    BigInteger tmp = current;
    current = current.add(BigInteger.ONE);
    return tmp;
  }

  private boolean allPalindromic(final BigInteger current) {
    for (int base : bases) {
      if (!isPalindromic(current.toString(base))) {
        return false;
      }
    }

    return true;
  }

  private boolean isPalindromic(final String number) {
    for (int i = 0; i < number.length() / 2; ++i) {
      if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
        return false;
      }
    }

    return true;
  }
}
