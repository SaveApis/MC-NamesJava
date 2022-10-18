package com.saveapis.mcnamesapi.api.services;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.internal.LinkedTreeMap;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationInfo;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import com.saveapis.mcnamesapi.base.BaseObjectRestResult;
import com.saveapis.mcnamesapi.base.BaseRestResult;
import com.saveapis.mcnamesapi.types.RestPaths;
import com.saveapis.mcnamesapi.utils.AsyncUtils;
import com.saveapis.mcnamesapi.utils.WebUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TranslationService {
    public static @NotNull ListenableFuture<ReadonlyCollection<ReadonlyTranslationInfo>> All() {
        BaseObjectRestResult restResult = WebUtils.get(RestPaths.TRANSLATION, BaseObjectRestResult.class);
        if (restResult == null || restResult.getError())
            return AsyncUtils.getAsync(param -> new ReadonlyCollection<>());

        BaseRestResult<List<LinkedTreeMap<String, String>>> infoRestResult = new BaseRestResult<>(false, "", (List<LinkedTreeMap<String, String>>) restResult.getResult());

        List<ReadonlyTranslationInfo> readonlyInfos = new ArrayList<>();
        for (LinkedTreeMap<String, String> info : infoRestResult.getResult())
            readonlyInfos.add(new ReadonlyTranslationInfo(info.get("displayName"), info.get("identifier")));
        return AsyncUtils.getAsync(params -> new ReadonlyCollection<>(params[0]), readonlyInfos);
    }
}
