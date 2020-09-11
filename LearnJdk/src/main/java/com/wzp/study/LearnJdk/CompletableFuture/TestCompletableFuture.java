package com.wzp.study.LearnJdk.CompletableFuture;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class TestCompletableFuture {

    List<Shop> shops = new ArrayList<>();

    {
        shops.add(new Shop());
        shops.add(new Shop());
        shops.add(new Shop());
    }

    @Test
    public void testPrice(){
        Shop shop = new Shop();
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        CompletableFuture<Double> futureprice1 = shop.getPriceAsync4("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1000000);
        System.out.println("Invocation returned after " + invocationTime);
        Shop.delay();
        try {
            double price = futurePrice.get();
            double price1 = futureprice1.join();
            System.out.println("Price "+price+ "  Price1 "+ price1 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

    }

    @Test
    public void findPrices(String product){
        List<CompletableFuture<String>> priceFuture = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice1(product),Shop.executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), Shop.executor)))
                .collect(Collectors.toList());

        List<String> priceList = priceFuture.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(priceList);
    }


}
