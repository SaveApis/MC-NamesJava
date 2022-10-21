package com.saveapis.mcnamesapi.utils;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.saveapis.mcnamesapi.utils.interfaces.IAsyncFunction;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncUtils {
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private static final ListeningExecutorService service = MoreExecutors.listeningDecorator(pool);

    public static <T> @NotNull ListenableFuture<T> getAsync(@NotNull IAsyncFunction<T> function) {

        return service.submit(function::execute);
    }
}
