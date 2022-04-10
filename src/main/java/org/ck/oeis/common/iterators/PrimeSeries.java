package org.ck.oeis.common.iterators;

import java.math.BigInteger;
import java.util.Iterator;

public class PrimeSeries implements Iterator<BigInteger> {
  private final BigInteger multiplier;
  private final BigInteger addition;

  private BigInteger current;

  public PrimeSeries(BigInteger start, BigInteger multiplier, BigInteger addition) {
    this.current = start;

    this.multiplier = multiplier;
    this.addition = addition;
  }

  private BigInteger getNumber() {
    return multiplier.multiply(current).add(addition);
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public BigInteger next() {
    while (!getNumber().isProbablePrime(20)) {
      current = current.add(BigInteger.ONE);
    }

    BigInteger tmp = current;
    current = current.add(BigInteger.ONE);

    return tmp;
  }
}
