package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class RunnableHelper {
    private static int value = 0;

//  Ordenando os recursos de forma crescente em relação ao seus valores
    private static final List<Resource> resources = Arrays.stream(Resource.values()).
            sorted(Comparator.comparing(Resource::getValue)).toList();

/*
    Os processos "runnableNotSafeDeadlock_1" e "runnableNotSafeDeadlock_2" fazem o Lock de recursos de forma
        desordenada/aleatória gerando por consequência um cenário de deadlock
 */
    public static final Runnable runnableNotSafeDeadlock_1 = () -> {
        try {
            final Thread thread = Thread.currentThread();

            synchronized (Resource.RESOURCE_0) {
                System.out.println(thread.getName() + " adquirindo Lock do recurso: " + Resource.RESOURCE_0);
                Thread.sleep(1000L);

                synchronized (Resource.RESOURCE_1) {
                    System.out.println(thread.getName() + " adquirindo Lock do recurso: " + Resource.RESOURCE_1);
                    Thread.sleep(1000L);

                    synchronized (Resource.RESOURCE_2) {
                        System.out.println(thread.getName() + " adquirindo Lock do recurso: " + Resource.RESOURCE_2);
                        Thread.sleep(1000L);
                        System.out.println(thread.getName() + " desfazendo Lock do recurso: " + Resource.RESOURCE_2);

                        value += 1;
                    }
                    System.out.println(thread.getName() + " desfazendo Lock do recurso: " + Resource.RESOURCE_1);
                }
                System.out.println(thread.getName() + " desfazendo Lock do recurso: " + Resource.RESOURCE_0);
            }
        } catch (final Exception exception) {
            throw new RuntimeException(exception);
        }
    };
    public static final Runnable runnableNotSafeDeadlock_2 = () -> {
        try {
            final Thread thread = Thread.currentThread();

            synchronized (Resource.RESOURCE_2) {
                System.out.println(thread.getName() + " adquirindo Lock do recurso: " + Resource.RESOURCE_2);
                Thread.sleep(1000L);

                synchronized (Resource.RESOURCE_0) {
                    System.out.println(thread.getName() + " adquirindo Lock do recurso: " + Resource.RESOURCE_0);
                    Thread.sleep(1000L);

                    synchronized (Resource.RESOURCE_1) {
                        System.out.println(thread.getName() + " adquirindo Lock do recurso: " + Resource.RESOURCE_1);
                        Thread.sleep(1000L);
                        System.out.println(thread.getName() + " desfazendo Lock do recurso: " + Resource.RESOURCE_1);

                        value += 1;
                    }
                    System.out.println(thread.getName() + " desfazendo Lock do recurso: " + Resource.RESOURCE_0);
                }
                System.out.println(thread.getName() + " desfazendo Lock do recurso: " + Resource.RESOURCE_2);
            }
        } catch (final Exception exception) {
            throw new RuntimeException(exception);
        }
    };

/*
    Os processos "runnableSafeDeadlock_1" e "runnableSafeDeadlock_2" fazem o Lock de recursos de forma
        ordenada não gerando por consequência um cenário de deadlock
*/
    public static final Runnable runnableSafeDeadlock_1 = () -> {
        try {
            final Thread thread = Thread.currentThread();

            synchronized (resources.get(0)) {
                System.out.println(thread.getName() + " adquirindo Lock do recurso: " + resources.get(0));
                Thread.sleep(1000L);

                synchronized (resources.get(1)) {
                    System.out.println(thread.getName() + " adquirindo Lock do recurso: " + resources.get(1));
                    Thread.sleep(1000L);

                    synchronized (resources.get(2)) {
                        System.out.println(thread.getName() + " adquirindo Lock do recurso: " + resources.get(2));
                        Thread.sleep(1000L);
                        System.out.println(thread.getName() + " desfazendo Lock do recurso: " + resources.get(2));

                        value += 1;
                    }
                    System.out.println(thread.getName() + " desfazendo Lock do recurso: " + resources.get(1));
                }
                System.out.println(thread.getName() + " desfazendo Lock do recurso: " + resources.get(0));
            }
        } catch (final Exception exception) {
            throw new RuntimeException(exception);
        }
    };
    public static final Runnable runnableSafeDeadlock_2 = () -> {
        try {
            final Thread thread = Thread.currentThread();

            synchronized (resources.get(0)) {
                System.out.println(thread.getName() + " adquirindo Lock do recurso: " + resources.get(0));
                Thread.sleep(1000L);

                synchronized (resources.get(1)) {
                    System.out.println(thread.getName() + " adquirindo Lock do recurso: " + resources.get(1));
                    Thread.sleep(1000L);

                    synchronized (resources.get(2)) {
                        System.out.println(thread.getName() + " adquirindo Lock do recurso: " + resources.get(2));
                        Thread.sleep(1000L);
                        System.out.println(thread.getName() + " desfazendo Lock do recurso: " + resources.get(2));

                        value += 1;
                    }
                    System.out.println(thread.getName() + " desfazendo Lock do recurso: " + resources.get(1));
                }
                System.out.println(thread.getName() + " desfazendo Lock do recurso: " + resources.get(0));
            }
        } catch (final Exception exception) {
            throw new RuntimeException(exception);
        }
    };

}
