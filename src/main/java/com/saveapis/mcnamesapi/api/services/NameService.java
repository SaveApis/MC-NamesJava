package com.saveapis.mcnamesapi.api.services;

import com.google.common.util.concurrent.ListenableFuture;
import com.saveapis.mcnamesapi.api.models.ReadonlyName;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.types.Languages;
import com.saveapis.mcnamesapi.api.types.RestPaths;
import com.saveapis.mcnamesapi.base.BaseService;
import com.saveapis.mcnamesapi.models.Name;
import com.saveapis.mcnamesapi.models.base.BaseObjectRestResult;
import com.saveapis.mcnamesapi.utils.AsyncUtils;
import com.saveapis.mcnamesapi.utils.JsonUtils;
import com.saveapis.mcnamesapi.utils.WebUtils;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class NameService extends BaseService {
    public static @NotNull ListenableFuture<ApiResult<ReadonlyName>> byUuid(@NotNull UUID uuid, @NotNull Languages language) {
        return AsyncUtils.getAsync(() -> {
            BaseObjectRestResult restResult = WebUtils.get(RestPaths.NAME, uuid + "?lang=" + language.getIdentifier(), BaseObjectRestResult.class);
            if (restResult == null || restResult.getError())
                return new ApiResult<>(true, restResult != null ? restResult.getMessage() : EMPTY_MESSAGE, ReadonlyName.empty());

            Name restName = JsonUtils.toObject(JsonUtils.toJson(restResult.getResult()), Name.class);
            return new ApiResult<>(restResult.getError(), restResult.getMessage(), new ReadonlyName(restName.getUuid(), restName.getName(), restName.getSince()));
        });
    }
}
