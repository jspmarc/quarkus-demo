package dev.jspmarc.quarkusdemo.service.impl;

import dev.jspmarc.quarkusdemo.service.api.FibonacciService;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import java.util.ArrayList;
import java.util.Arrays;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FibonacciServiceImpl implements FibonacciService {

  @Override
  public Uni<Long> computeSequence(int n) {
    return Uni.createFrom().item(n).flatMap(i -> {
      if (i >= 23) {
        Log.info("Got req (NO memoization): " + i);
      }
      if (i == 0 || i == 1) {
        return Uni.createFrom().item(1L);
      }

      var left = computeSequence(i - 1);
      var right = computeSequence(i - 2);

      return Uni.combine().all().unis(left, right).asTuple()
          .map(tup -> tup.getItem1() + tup.getItem2());
    });
  }

  @Override
  public Uni<Long> computeSequenceUsingMemoization(int n) {
    return Uni.createFrom().item(() -> {
      Log.info("Got req (WITH memoization): " + n);
      if (n == 0 || n == 1) {
        return 1L;
      }

      var memo = new ArrayList<>(Arrays.asList(1L, 1L));

      for (var i = 2; i <= n; ++i) {
        var sum = memo.get(i - 1) + memo.get(i - 2);
        memo.add(sum);
      }

      return memo.get(n);
    });
  }
}
