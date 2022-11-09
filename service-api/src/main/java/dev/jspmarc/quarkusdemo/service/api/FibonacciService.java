package dev.jspmarc.quarkusdemo.service.api;

import io.smallrye.mutiny.Uni;

public interface FibonacciService {

  Uni<Long> computeSequence(int n);

  Uni<Long> computeSequenceUsingMemoization(int n);
}
