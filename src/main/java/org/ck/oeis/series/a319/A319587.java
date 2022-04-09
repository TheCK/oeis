package org.ck.oeis.series.a319;

import org.ck.oeis.Series;
import org.ck.oeis.common.FiniteSeries;

import java.math.BigInteger;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A319587 extends Series {
  private static final BigInteger[] values =
      new BigInteger[] {
        new BigInteger("3"),
        new BigInteger("261"),
        new BigInteger("110912"),
        new BigInteger("17895697067018274"),
        new BigInteger(
            "276030377510396880405960918479893106167306145487285888162120430431287593362768250278440785732148990805749233608902345600"),
        new BigInteger(
            "766763880932933169887273030733538085358609122257169736888927632490737237024578980987856869372538457184327099971611938362734096892597672167038031491034688652085344854326500522688594573809994182701789670186137064914989248103796617433453820640367431045653306351008575104883495152159360968294400000000000000000000")
      };

  public A319587() {
    super(
        "The number of distinct solid nets of the six convex regular 4D-polytopes in the order of their 3D-cell count.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliterator(FiniteSeries.of(values), values.length, Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
