package org.ck.oeis.common.iterators;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.function.Function;

public class FunctionOfOtherSeriesSeries implements Iterator<BigInteger> {
  private final Iterator<BigInteger> source;
  private final Function<BigInteger, BigInteger> function;

  private FunctionOfOtherSeriesSeries(
      Iterator<BigInteger> source, Function<BigInteger, BigInteger> function) {
    this.source = source;
    this.function = function;
  }

  public static final FunctionOfOtherSeriesSeries of(
      Series source, Function<BigInteger, BigInteger> function) {
    return new FunctionOfOtherSeriesSeries(source.asStream().iterator(), function);
  }

  public static final FunctionOfOtherSeriesSeries of(
      Series source, Function<BigInteger, BigInteger> function, int offset) {
    Iterator<BigInteger> iterator = source.asStream().iterator();
    for (int i = 0; i < offset; ++i) {
      iterator.next();
    }

    return new FunctionOfOtherSeriesSeries(iterator, function);
  }

  @Override
  public boolean hasNext() {
    return source.hasNext();
  }

  @Override
  public BigInteger next() {
    return function.apply(source.next());
  }
}
