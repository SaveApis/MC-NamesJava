package com.saveapis.mcnamesapi.base;

/**
 * Class to specify the Result of the REST-API
 *
 * @param <TResult> the Type of the Result
 */
public class BaseRestResult<TResult> {
    private Boolean error;
    private String message;
    private TResult result;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TResult getResult() {
        return result;
    }

    public void setResult(TResult result) {
        this.result = result;
    }
}
