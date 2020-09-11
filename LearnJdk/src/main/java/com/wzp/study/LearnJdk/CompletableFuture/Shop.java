package com.wzp.study.LearnJdk.CompletableFuture;

import java.util.Random;
import java.util.concurrent.*;

public class Shop {
    Random random = new Random();

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPrice1(String product) {
        double price =  calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", product, price, code);
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsync1(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsync2(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public static final Executor executor = Executors.newFixedThreadPool(100,
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                }
            });

    public Future<Double> getPriceAsync3(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product),executor);
    }

    public CompletableFuture<Double> getPriceAsync4(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
