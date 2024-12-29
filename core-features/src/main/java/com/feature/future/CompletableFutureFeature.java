package com.feature.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureFeature {

    public static void main() throws ExecutionException, InterruptedException {
        System.out.println("************** STARTED ***************");
        CompletableFuture cf1 = new CompletableFuture();
        // System.out.println(completableFuture.get()); This will block
        System.out.println(cf1.getNow("get now"));

        cf1.complete("complete");
        System.out.println(cf1.get());

        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 5; i++) {
                sleep(100);
                System.out.println("no is " + i);
            }
        }).thenRun(() -> System.out.println("Printed all nos"));


        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName())
                .thenApply(s -> "then apply 1 " + s)
                .thenApply(s -> "then apply 2 " + s)
                .whenComplete((s, e) -> System.out.println(s +" "+e));


        CompletableFuture<Account> accountsFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return new Account("US12IBAN122324234", "John Doe");
        });

        CompletableFuture<Double> balanceFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return 505.5d;
        });

        CompletableFuture<Double> cf4 = accountsFuture.thenCompose(acc -> balanceFuture);
        System.out.println(cf4.get());


        CompletableFuture<Void> cf5 = accountsFuture
                .thenCombine(balanceFuture, (account, balance) -> account + " has a blanance of" + balance)
                .thenAccept(System.out::println);


        CompletableFuture.allOf(cf1, cf2, cf3, cf4, cf5).join();

        System.out.println("************** ENDED ***************");
    }




    private static void sleep(int ms) {
        try {Thread.sleep(ms);} catch (InterruptedException e) {}
    }

    record Account(String iban, String title){}
}
