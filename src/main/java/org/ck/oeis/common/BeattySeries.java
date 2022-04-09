package org.ck.oeis.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

public class BeattySeries implements Iterator<BigInteger> {
  private final BigDecimal multiplier;
  private BigDecimal current = BigDecimal.ONE;

  public BeattySeries(BigDecimal multiplier) {
    this.multiplier = multiplier;
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public BigInteger next() {
    BigDecimal tmp = current;
    current = current.add(BigDecimal.ONE);
    return multiplier.multiply(tmp).toBigInteger();
  }
}
