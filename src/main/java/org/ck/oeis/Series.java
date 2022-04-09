package org.ck.oeis;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class Series {

  private final String name;
  private final String description;

  public Series(String description) {
    this.name = this.getClass().getSimpleName();
    this.description = description;
  }

  public abstract Stream<BigInteger> asStream();

  public abstract long size();

  public Stream<Long> asLongStream() {
    return asStream().map(BigInteger::longValue);
  }

  public Stream<Integer> asIntegerStream() {
    return asStream().map(BigInteger::intValue);
  }

  public IntStream asIntStream() {
    return asStream().mapToInt(BigInteger::intValue);
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
