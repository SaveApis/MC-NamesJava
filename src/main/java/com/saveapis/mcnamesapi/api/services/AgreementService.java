package com.saveapis.mcnamesapi.api.services;

import com.google.common.util.concurrent.ListenableFuture;
import com.saveapis.mcnamesapi.api.models.ReadonlyAgreement;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.models.Agreement;
import com.saveapis.mcnamesapi.models.base.BaseObjectRestResult;
import com.saveapis.mcnamesapi.types.Languages;
import com.saveapis.mcnamesapi.types.RestPaths;
import com.saveapis.mcnamesapi.utils.AsyncUtils;
import com.saveapis.mcnamesapi.utils.JsonUtils;
import com.saveapis.mcnamesapi.utils.WebUtils;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class AgreementService {
    public static @NotNull ListenableFuture<ApiResult<ReadonlyAgreement>> hasAgreement(@NotNull UUID uuid, @NotNull Languages language) {
        BaseObjectRestResult restResult = WebUtils.get(RestPaths.AGREEMENT, uuid + "?lang=" + language.getIdentifier(), BaseObjectRestResult.class);
        if (restResult == null || restResult.getError())
            return AsyncUtils.getAsync(params -> new ApiResult<>(true, "", new ReadonlyAgreement(new UUID(0L, 0L), false)));

        Agreement agreement = JsonUtils.toObject(JsonUtils.toJson(restResult.getResult()), Agreement.class);
        ReadonlyAgreement readonlyAgreement = new ReadonlyAgreement(agreement.getUuid(), agreement.getAgreementValue());
        return AsyncUtils.getAsync(params -> new ApiResult<>(false, restResult.getMessage(), readonlyAgreement));
    }

    public static @NotNull ListenableFuture<ApiResult<ReadonlyAgreement>> toggleAgreement(@NotNull UUID uuid, @NotNull Languages languages) {
        BaseObjectRestResult restResult = WebUtils.post(RestPaths.AGREEMENT, uuid + "?lang=" + languages.getIdentifier(), BaseObjectRestResult.class);
        if (restResult == null || restResult.getError())
            return AsyncUtils.getAsync(params -> new ApiResult<>(false, "", new ReadonlyAgreement(new UUID(0L, 0L), false)));

        Agreement agreement = JsonUtils.toObject(JsonUtils.toJson(restResult.getResult()), Agreement.class);
        ReadonlyAgreement readonlyAgreement = new ReadonlyAgreement(agreement.getUuid(), agreement.getAgreementValue());
        return AsyncUtils.getAsync(params -> new ApiResult<>(false, restResult.getMessage(), readonlyAgreement));
    }
}
