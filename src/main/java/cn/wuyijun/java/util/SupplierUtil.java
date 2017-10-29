package cn.wuyijun.java.util;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by tanke.wyj on 2017/10/25.
 */
public class SupplierUtil {
    private static final Set<String> test = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("","")));

    public static void main(String[] args) throws Exception{
        String value = supplyAsync(() -> {
            System.out.println("test output");
            return "";
        }).exceptionally(e -> {
            return null;
        }).get();
    }

    public static <T> Optional<T> optional(Supplier<T> supplier) {
        try {
            return ofNullable(supplier.get());
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    public static <T> Supplier<T> nullable(final Supplier<T> supplier) {
        Supplier<T> nullableSupplier = () -> {
            try {
                return supplier.get();
            } catch (Exception e) {
                return null;
            }
        };
        return nullableSupplier;
    }

    public static <T> T valueOf(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
