package org.ck.oeis.series.a000;

import org.ck.oeis.Series;
import org.ck.oeis.common.FiniteSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A000053 extends Series {
  private static final long[] values =
      new long[] {
        14, 18, 23, 28, 34, 42, 50, 59, 66, 72, 79, 86, 96, 103, 110, 116, 125, 137, 145, 157, 168,
        181, 191, 207, 215, 225, 231, 238, 242
      };

  public A000053() {
    super("Local stops on New York City Broadway line (IRT #1) subway.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliterator(FiniteSeries.of(values), values.length, Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return values.length;
  }
}
