package org.ck.oeis.common;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FiniteSeries implements Iterator<BigInteger> {
  private final List<BigInteger> values;
  private int current = 0;

  private FiniteSeries(List<BigInteger> values) {
    this.values = values;
  }

  public static final FiniteSeries of(long... values) {
    return new FiniteSeries(Arrays.stream(values).mapToObj(BigInteger::valueOf).toList());
  }

  public static final FiniteSeries of(BigInteger... values) {
    return new FiniteSeries(Arrays.stream(values).toList());
  }

  @Override
  public boolean hasNext() {
    return current < values.size();
  }

  @Override
  public BigInteger next() {
    BigInteger result = values.get(current);
    ++current;

    return result;
  }
}
