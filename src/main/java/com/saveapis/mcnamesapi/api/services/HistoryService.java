package com.saveapis.mcnamesapi.api.services;

import com.google.common.util.concurrent.ListenableFuture;
import com.saveapis.mcnamesapi.api.models.ReadonlyHistory;
import com.saveapis.mcnamesapi.api.models.base.ApiResult;
import com.saveapis.mcnamesapi.api.types.Languages;
import com.saveapis.mcnamesapi.api.types.RestPaths;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import com.saveapis.mcnamesapi.base.BaseService;
import com.saveapis.mcnamesapi.models.History;
import com.saveapis.mcnamesapi.models.base.BaseObjectRestResult;
import com.saveapis.mcnamesapi.utils.AsyncUtils;
import com.saveapis.mcnamesapi.utils.JsonUtils;
import com.saveapis.mcnamesapi.utils.WebUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class HistoryService extends BaseService {
    public static @NotNull ListenableFuture<ApiResult<ReadonlyCollection<ReadonlyHistory>>> byUuid(@NotNull UUID uuid) {
        return byUuid(uuid, Languages.ENGLISH);
    }

    public static @NotNull ListenableFuture<ApiResult<ReadonlyCollection<ReadonlyHistory>>> byUuid(@NotNull UUID uuid, @NotNull Languages languages) {
        return AsyncUtils.getAsync(() -> {
            BaseObjectRestResult baseRestResult = WebUtils.get(RestPaths.HISTORY, uuid + "?lang=" + languages.getIdentifier(), BaseObjectRestResult.class);

            if (baseRestResult == null || baseRestResult.getError()) {
                ApiResult<ReadonlyCollection<ReadonlyHistory>> apiResult = new ApiResult<>(true, baseRestResult != null ? baseRestResult.getMessage() : EMPTY_MESSAGE, new ReadonlyCollection<>());
                return apiResult;
            }

            History[] historyList = JsonUtils.toObject(JsonUtils.toJson(baseRestResult.getResult()), History[].class);
            List<ReadonlyHistory> readonlyHistoryList = new ArrayList<>();

            for (History history : historyList) {
                readonlyHistoryList.add(new ReadonlyHistory(history.getHistoryName(), history.getFrom(), history.getTo()));
            }

            ApiResult<ReadonlyCollection<ReadonlyHistory>> apiResult = new ApiResult<>(false, baseRestResult.getMessage(), new ReadonlyCollection<>(readonlyHistoryList));
            return apiResult;
        });
    }
}
