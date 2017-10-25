package cn.wuyijun.java.util;

import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

/**
 * Created by tanke.wyj on 2017/10/25.
 */
public class Nullable {
    public static <T> Optional<T> optional(Supplier<T> supplier) {
        try {
            return ofNullable(supplier.get());
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    public static <T> Supplier<T> nullableSupplier(final Supplier<T> supplier) {
        Supplier<T> nullableSupplier = () -> {
            try {
                return (T)(supplier.get());
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
