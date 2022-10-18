package com.saveapis.mcnamesapi.api.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class ReadonlyCollection<T> {
    private final List<T> collection;

    public ReadonlyCollection(List<T> collection) {
        this.collection = collection;
    }

    @SafeVarargs
    public ReadonlyCollection(T... collection) {
        this(Arrays.asList(collection));
    }

    public @Nullable T get(@NotNull Integer index) {
        try {
            return collection.get(index);
        } catch (Exception e) {
            return null;
        }
    }

    public @NotNull List<T> toList() {
        return collection;
    }
}
