package com.saveapis.mcnamesapi.api.services;

import com.google.common.util.concurrent.ListenableFuture;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslation;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationContent;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationInfo;
import com.saveapis.mcnamesapi.api.types.Languages;
import com.saveapis.mcnamesapi.api.types.RestPaths;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import com.saveapis.mcnamesapi.base.BaseService;
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

public final class TranslationService extends BaseService {
    public static @NotNull ListenableFuture<ApiResult<ReadonlyCollection<ReadonlyTranslationInfo>>> infos() {
        return AsyncUtils.getAsync(() -> {
            BaseObjectRestResult restResult = WebUtils.get(RestPaths.TRANSLATION, BaseObjectRestResult.class);
            if (restResult == null || restResult.getError())
                return new ApiResult<>(true, restResult != null ? restResult.getMessage() : EMPTY_MESSAGE, new ReadonlyCollection<>());

            TranslationInfo[] infos = JsonUtils.toObject(JsonUtils.toJson(restResult.getResult()), TranslationInfo[].class);
            List<ReadonlyTranslationInfo> readonlyInfos = new ArrayList<>();

            for (TranslationInfo info : infos)
                readonlyInfos.add(new ReadonlyTranslationInfo(info.getDisplayName(), info.getIdentifier()));
            return new ApiResult<>(false, restResult.getMessage(), new ReadonlyCollection<>(readonlyInfos));
        });
    }

    public static @NotNull ListenableFuture<ApiResult<ReadonlyTranslation>> byIdentifier(String identifier) {
        return AsyncUtils.getAsync(() -> {
            BaseObjectRestResult restResult = WebUtils.get(RestPaths.TRANSLATION, identifier, BaseObjectRestResult.class);
            if (restResult == null || restResult.getError()) {
                ApiResult<ReadonlyTranslation> result = new ApiResult<>(true, restResult != null ? restResult.getMessage() : EMPTY_MESSAGE, ReadonlyTranslation.empty());
                return result;
            }
            Translation translation = JsonUtils.toObject(JsonUtils.toJson(restResult.getResult()), Translation.class);
            ReadonlyTranslationInfo readonlyInfo = new ReadonlyTranslationInfo(translation.getInfo().getDisplayName(), translation.getInfo().getIdentifier());
            List<ReadonlyTranslationContent> readonlyContentList = new ArrayList<>();
            for (TranslationContent content : translation.getContent())
                readonlyContentList.add(new ReadonlyTranslationContent(content.getKey(), content.getTranslation(), content.getDescription()));
            ReadonlyCollection<ReadonlyTranslationContent> readonlyContent = new ReadonlyCollection<>(readonlyContentList);

            ReadonlyTranslation readonlyTranslation = new ReadonlyTranslation(readonlyInfo, readonlyContent);
            ApiResult<ReadonlyTranslation> result = new ApiResult<>(false, restResult.getMessage(), readonlyTranslation);
            return result;
        });
    }

    public static @NotNull ListenableFuture<ApiResult<ReadonlyTranslation>> byIdentifier(Languages types) {
        return byIdentifier(types.getIdentifier());
    }

    public static @NotNull ListenableFuture<ApiResult<ReadonlyTranslation>> defaultTranslation() {
        return byIdentifier("en");
    }
}
