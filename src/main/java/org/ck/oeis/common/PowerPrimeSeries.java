package org.ck.oeis.common;

import java.math.BigInteger;
import java.util.Iterator;

public class PowerPrimeSeries implements Iterator<BigInteger> {
  private final BigInteger multiplier;
  private final BigInteger power;
  private final BigInteger addition;
  private final BigInteger divider;

  private BigInteger current;
  private BigInteger currentPower = BigInteger.ONE;

  public PowerPrimeSeries(
      BigInteger start,
      BigInteger multiplier,
      BigInteger power,
      BigInteger addition,
      BigInteger divider) {
    this.current = start;

    this.multiplier = multiplier;
    this.power = power;
    this.addition = addition;
    this.divider = divider;
  }

  private BigInteger getNumber() {
    return multiplier.multiply(currentPower).add(addition).divide(divider);
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public BigInteger next() {
    while (!getNumber().isProbablePrime(20)) {
      current = current.add(BigInteger.ONE);
      currentPower = currentPower.multiply(power);
    }

    BigInteger tmp = current;
    current = current.add(BigInteger.ONE);
    currentPower = currentPower.multiply(power);

    return tmp;
  }
}
