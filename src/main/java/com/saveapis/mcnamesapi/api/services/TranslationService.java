package com.saveapis.mcnamesapi.api.services;

import com.google.common.util.concurrent.ListenableFuture;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslation;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationContent;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationInfo;
import com.saveapis.mcnamesapi.api.types.Languages;
import com.saveapis.mcnamesapi.api.types.RestPaths;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import com.saveapis.mcnamesapi.models.base.BaseObjectRestResult;
import com.saveapis.mcnamesapi.models.translations.Translation;
import com.saveapis.mcnamesapi.models.translations.TranslationContent;
import com.saveapis.mcnamesapi.models.translations.TranslationInfo;
import com.saveapis.mcnamesapi.utils.AsyncUtils;
import com.saveapis.mcnamesapi.utils.JsonUtils;
import com.saveapis.mcnamesapi.utils.WebUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class TranslationService {
    public static @NotNull ListenableFuture<ApiResult<ReadonlyCollection<ReadonlyTranslationInfo>>> all() {
        BaseObjectRestResult restResult = WebUtils.get(RestPaths.TRANSLATION, BaseObjectRestResult.class);
        if (restResult == null || restResult.getError())
            return AsyncUtils.getAsync(param -> new ApiResult<>(true, "", new ReadonlyCollection<>()));

        TranslationInfo[] infos = JsonUtils.toObject(JsonUtils.toJson(restResult.getResult()), TranslationInfo[].class);
        List<ReadonlyTranslationInfo> readonlyInfos = new ArrayList<>();

        for (TranslationInfo info : infos)
            readonlyInfos.add(new ReadonlyTranslationInfo(info.getDisplayName(), info.getIdentifier()));
        return AsyncUtils.getAsync(param -> new ApiResult<>(false, restResult.getMessage(), new ReadonlyCollection<>(readonlyInfos)));
    }

    public static @NotNull ListenableFuture<ApiResult<ReadonlyTranslation>> byIdentifier(String identifier) {
        BaseObjectRestResult restResult = WebUtils.get(RestPaths.TRANSLATION, identifier, BaseObjectRestResult.class);
        if (!identifier.equalsIgnoreCase("en") && (restResult == null || restResult.getError()))
            return defaultTranslation();

        Translation translation = JsonUtils.toObject(JsonUtils.toJson(Objects.requireNonNull(restResult).getResult()), Translation.class);
        List<ReadonlyTranslationContent> contents = new ArrayList<>();

        for (TranslationContent content : translation.getContent())
            contents.add(new ReadonlyTranslationContent(content.getKey(), content.getTranslation(), content.getDescription()));

        ReadonlyTranslationInfo readonlyInfo =
                new ReadonlyTranslationInfo(translation.getInfo().getDisplayName(), translation.getInfo().getIdentifier());
        ReadonlyTranslation readonlyTranslation = new ReadonlyTranslation(readonlyInfo, new ReadonlyCollection<>(contents));
        return AsyncUtils.getAsync(params -> new ApiResult<>(false, restResult.getMessage(), readonlyTranslation));
    }

    public static @NotNull ListenableFuture<ApiResult<ReadonlyTranslation>> byIdentifier(Languages types) {
        return byIdentifier(types.getIdentifier());
    }

    public static @NotNull ListenableFuture<ApiResult<ReadonlyTranslation>> defaultTranslation() {
        return byIdentifier("en");
    }
}
