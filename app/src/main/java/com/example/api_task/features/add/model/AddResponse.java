package com.example.api_task.features.add.model;

import com.google.gson.annotations.SerializedName;

public class AddResponse {
    private String result ;
    private String targetUrl ;
    private boolean success ;
    @SerializedName("error")
    private Error error ;
    private boolean unAuthorizedRequest ;
    private boolean __abp ;

    public AddResponse(String result, String targetUrl, boolean success, Error error, boolean unAuthorizedRequest, boolean __abp) {
        this.result = result;
        this.targetUrl = targetUrl;
        this.success = success;
        this.error = error;
        this.unAuthorizedRequest = unAuthorizedRequest;
        this.__abp = __abp;
    }


    public String getResult() {
        return result;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }

    public boolean isUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public boolean is__abp() {
        return __abp;
    }







    public static class Error{
        private int code ;
        private String message ;
        private String details ;
        private String validationErrors ;

        public Error(int code, String message, String details, String validationErrors) {
            this.code = code;
            this.message = message;
            this.details = details;
            this.validationErrors = validationErrors;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public String getDetails() {
            return details;
        }

        public String getValidationErrors() {
            return validationErrors;
        }
    }
    public int getCode() {
        return error.getCode();
    }

    public String getMessage() {
        return error.getMessage();
    }

    public String getDetails() {
        return error.getDetails();
    }

    public String getValidationErrors() {
        return error.getValidationErrors();
    }

}
