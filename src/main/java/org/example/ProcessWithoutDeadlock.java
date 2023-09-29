package org.example;

import java.util.List;

/*
    Cenário onde NÃO OCORRE um deadlock devido as duas Thread's estarem dando Lock de forma ordenada
        em recursos compartilhados entre ambas
 */

public class ProcessWithoutDeadlock {
    public static void main(String[] args) {
        final List<Thread> threads = List.of(
                new Thread(RunnableHelper.runnableSafeDeadlock_1, "Thread sem deadlock exemplo 1"),
                new Thread(RunnableHelper.runnableSafeDeadlock_2, "Thread sem deadlock exemplo 2")
        );

        threads.forEach(Thread::start);
    }
}