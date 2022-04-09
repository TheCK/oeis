package org.ck.oeis.common.iterators;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingFromFiniteSeriesSeries implements Iterator<BigInteger> {
  private final Set<BigInteger> values;
  private BigInteger current;

  private MissingFromFiniteSeriesSeries(BigInteger initial, Set<BigInteger> values) {
    this.current = initial;
    this.values = values;
  }

  public static final MissingFromFiniteSeriesSeries of(BigInteger initial, BigInteger... values) {
    return new MissingFromFiniteSeriesSeries(
        initial, Arrays.stream(values).collect(Collectors.toSet()));
  }

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public BigInteger next() {
    while (values.contains(current)) {
      current = current.add(BigInteger.ONE);
    }

    BigInteger tmp = current;
    current = current.add(BigInteger.ONE);
    return tmp;
  }
}
