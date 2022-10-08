package com.saveapis.mcnamesapi.api.utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadonlyCollection<TType> {
    private final List<TType> dataList;

    @SafeVarargs
    public ReadonlyCollection(TType @NotNull ... readonlyCollection) {
        this.dataList = Arrays.asList(readonlyCollection);
    }

    public ReadonlyCollection(@NotNull List<TType> readonlyCollection) {
        this.dataList = readonlyCollection;
    }

    public TType get(@NotNull Integer index) {
        return dataList.get(index);
    }

    public ReadonlyCollection<TType> get(Integer @NotNull ... indexes) {
        List<TType> result = new ArrayList<>();
        for (int index : indexes) {
            if (index >= dataList.size())
                continue;
            result.add(dataList.get(index));
        }
        return new ReadonlyCollection<>(result);
    }

    public List<TType> toList() {
        return dataList;
    }
}
