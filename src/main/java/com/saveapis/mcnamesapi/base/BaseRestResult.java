package com.saveapis.mcnamesapi.base;

/**
 * Class to specify the Result of the REST-API
 *
 * @param <TResult> the Type of the Result
 */
public class BaseRestResult<TResult> {

    public BaseRestResult(Boolean error, String message, TResult result) {
        this.error = error;
        this.message = message;
        this.result = result;
    }

    private final Boolean error;
    private final String message;
    private final TResult result;

    public Boolean getError() {
        return error;
    }


    public String getMessage() {
        return message;
    }


    public TResult getResult() {
        return result;
    }

}

