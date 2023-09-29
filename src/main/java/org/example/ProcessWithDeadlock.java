package org.example;

import java.util.List;

/*
    Cenário onde OCORRE um deadlock devido as duas Thread's estarem dando Lock de forma desordenada/aleatória
        em recursos compartilhados entre ambas
 */

public class ProcessWithDeadlock {
    public static void main(String[] args) {
        final List<Thread> threads = List.of(
                new Thread(RunnableHelper.runnableNotSafeDeadlock_1, "Thread com deadlock exemplo 1"),
                new Thread(RunnableHelper.runnableNotSafeDeadlock_2, "Thread com deadlock exemplo 2")
        );

        threads.forEach(Thread::start);
    }
}