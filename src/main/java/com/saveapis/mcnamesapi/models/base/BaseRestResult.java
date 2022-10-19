package com.saveapis.mcnamesapi.models.base;

/**
 * Class to specify the Result of the REST-API
 *
 * @param <TResult> the Type of the Result
 */
public record BaseRestResult<TResult>(Boolean error, String message, TResult result) {

}

