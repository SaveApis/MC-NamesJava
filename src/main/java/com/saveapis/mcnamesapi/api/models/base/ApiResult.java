package com.saveapis.mcnamesapi.api.models.base;

public record ApiResult<T>(Boolean error, String message, T result) {
}
