package com.saveapis.mcnamesapi.utils;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class AsyncUtils {
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private static final ListeningExecutorService service = MoreExecutors.listeningDecorator(pool);

    @SafeVarargs
    public static <T, P> @NotNull ListenableFuture<T> getAsync(@NotNull Function<P[], T> function, @Nullable P... parameter) {
        return service.submit(() -> function.apply(parameter));
    }
}
