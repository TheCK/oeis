package org.ck.oeis.series.a123;

import org.ck.oeis.Series;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class A123466 extends Series {
  public A123466() {
    super(
        "Write the positive integer n in binary. Subdivide the binary n into runs each consisting entirely of 0's or of 1's, where the runs alternate between those of 1's and those of 0's. The sequence gives those numbers n such that there is at least one run of 1's of the same length as at least one run of 0's.");
  }

  @Override
  public Stream<BigInteger> asStream() {
    return StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(
            new Iterator<>() {
              BigInteger current = BigInteger.TWO;

              @Override
              public boolean hasNext() {
                return true;
              }

              @Override
              public BigInteger next() {
                while (!hasValidRuns(current)) {
                  current = current.add(BigInteger.ONE);
                }
                BigInteger tmp = current;
                current = current.add(BigInteger.ONE);
                return tmp;
              }

              private boolean hasValidRuns(final BigInteger current) {
                String binary = current.toString(2) + '\0';

                List<Set<Integer>> lengths = List.of(new HashSet<>(), new HashSet<>());
                char last = '1';
                int count = 0;

                for (int i = 0; i < binary.length(); ++i) {
                  if (last == binary.charAt(i)) {
                    ++count;
                  } else {
                    lengths.get(last - '0').add(count);
                    count = 1;
                    last = binary.charAt(i);
                  }
                }

                return lengths.get(0).stream().anyMatch(lengths.get(1)::contains);
              }
            },
            Spliterator.IMMUTABLE),
        false);
  }

  @Override
  public long size() {
    return Long.MAX_VALUE;
  }
}
