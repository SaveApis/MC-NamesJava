package com.saveapis.mcnamesapi.api.services;

public class TranslationService {
    /*
    public static @NotNull ListenableFuture<ReadonlyCollection<ReadonlyTranslationInfo>> all() {
        BaseObjectRestResult restResult = WebUtils.get(RestPaths.TRANSLATION, BaseObjectRestResult.class);
        if (restResult == null || restResult.getError())
            return AsyncUtils.getAsync(param -> new ReadonlyCollection<>());

        BaseRestResult<List<LinkedTreeMap<String, String>>> infoRestResult = new BaseRestResult<>(false, "", (List<LinkedTreeMap<String, String>>) restResult.getResult());

        List<ReadonlyTranslationInfo> readonlyInfos = new ArrayList<>();
        for (LinkedTreeMap<String, String> info : infoRestResult.getResult())
            readonlyInfos.add(new ReadonlyTranslationInfo(info.get("displayName"), info.get("identifier")));
        return AsyncUtils.getAsync(params -> new ReadonlyCollection<>(params[0]), readonlyInfos);
    }
    */
}
