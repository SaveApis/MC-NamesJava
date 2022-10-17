package com.saveapis.mcnamesapi.api.services;

import com.google.common.util.concurrent.ListenableFuture;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationInfo;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import com.saveapis.mcnamesapi.base.BaseObjectRestResult;
import com.saveapis.mcnamesapi.base.BaseRestResult;
import com.saveapis.mcnamesapi.models.translations.TranslationInfo;
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

        BaseRestResult<List<TranslationInfo>> infoRestResult = new BaseRestResult<>(false, "", (List<TranslationInfo>) restResult.getResult());

        List<ReadonlyTranslationInfo> readonlyInfos = new ArrayList<>();
        for (TranslationInfo info : infoRestResult.getResult())
            readonlyInfos.add(new ReadonlyTranslationInfo(info.getIdentifier(), info.getIdentifier()));
        return AsyncUtils.getAsync(params -> new ReadonlyCollection<>(params[0]), readonlyInfos);
    }
}
