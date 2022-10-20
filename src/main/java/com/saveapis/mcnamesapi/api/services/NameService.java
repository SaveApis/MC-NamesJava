package com.saveapis.mcnamesapi.api.services;

import com.google.common.util.concurrent.ListenableFuture;
import com.saveapis.mcnamesapi.api.models.ReadonlyName;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.types.RestPaths;
import com.saveapis.mcnamesapi.base.BaseService;
import com.saveapis.mcnamesapi.models.Name;
import com.saveapis.mcnamesapi.models.base.BaseObjectRestResult;
import com.saveapis.mcnamesapi.utils.AsyncUtils;
import com.saveapis.mcnamesapi.utils.JsonUtils;
import com.saveapis.mcnamesapi.utils.WebUtils;
import org.jetbrains.annotations.NotNull;

public final class NameService extends BaseService {
    public static @NotNull ListenableFuture<ApiResult<ReadonlyName>> byUuid(@NotNull String name) {
        BaseObjectRestResult restResult = WebUtils.get(RestPaths.NAME, name, BaseObjectRestResult.class);
        if (restResult == null || restResult.getError())
            return AsyncUtils.getAsync(params -> new ApiResult<>(true, restResult != null ? restResult.getMessage() : EMPTY_MESSAGE, ReadonlyName.empty()));

        Name restName = JsonUtils.toObject(JsonUtils.toJson(restResult.getResult()), Name.class);
        return AsyncUtils.getAsync(
                paramName ->
                        new ApiResult<>(
                                restResult.getError(),
                                restResult.getMessage(),
                                new ReadonlyName(paramName[0].getUuid(), paramName[0].getName(), paramName[0].getSince())),
                restName);
    }
}
