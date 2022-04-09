package org.ck.oeis.common.iterators;

import java.math.BigInteger;
import java.util.Iterator;

public class SumSeries implements Iterator<BigInteger> {
  private final BigInteger[] initialVector;
  private final BigInteger[] coefficients;
  private final BigInteger offset;

  private final BigInteger[] history;

  public SumSeries(BigInteger[] initialVector, BigInteger[] coefficients, BigInteger offset) {
    if (initialVector.length != coefficients.length) {
      throw new IllegalArgumentException("Arrays must be same size.");
    }

    this.initialVector = initialVector;
    this.coefficients = coefficients;
    this.offset = offset;

    this.history = new BigInteger[initialVector.length];
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public BigInteger next() {
    int empty = -1;

    for (int i = 0; i < history.length; ++i) {
      if (history[i] == null) {
        empty = i;
        break;
      }
    }

    if (empty == -1) {
      BigInteger current = BigInteger.ZERO;

      for (int i = 0; i < coefficients.length; ++i) {
        current = current.add(coefficients[i].multiply(history[i]));
      }

      current = current.add(offset);

      for (int i = history.length - 2; i >= 0; --i) {
        history[i + 1] = history[i];
      }
      history[0] = current;

      return current;
    }

    for (int i = empty - 1; i >= 0; --i) {
      history[i + 1] = history[i];
    }
    history[0] = initialVector[empty];

    return initialVector[empty];
  }
}
