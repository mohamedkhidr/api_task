package com.example.api_task.login.model;

import com.google.gson.annotations.SerializedName;

public class AuthenticationResponse {
    private Result result;
    private String targetUrl;
    private boolean success;
    private Error error;
    private boolean unAuthorizedRequest;
    private boolean __abp;

    public AuthenticationResponse(Result result,
                                  String targetUrl, boolean success, Error error,
                                  boolean unAuthorizedRequest, boolean __abp) {
        this.result = result;
        this.targetUrl = targetUrl;
        this.success = success;
        this.error = error;
        this.unAuthorizedRequest = unAuthorizedRequest;
        this.__abp = __abp;
    }

    public Result getResult() {
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

    // parse result object
    public static class Result {
        @SerializedName("accessToken")
        private String accessToken;
        private Profile profile;

        public Result(String accessToken, Profile profile) {
            this.accessToken = accessToken;
            this.profile = profile;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public Profile getProfile() {
            return profile;
        }
        // parse profile object
        public static class Profile {
            private String avatarUrl;
            private String avatar;
            private String address;
            private String birthDate;
            private int gender;
            private String genderText;
            private String cityName;
            private String countryName;
            private int userId;
            private String name;

            public Profile(String avatarUrl, String avatar,
                           String address, String birthDate, int gender,
                           String genderText, String cityName, String countryName,
                           int userId, String name) {
                this.avatarUrl = avatarUrl;
                this.avatar = avatar;
                this.address = address;
                this.birthDate = birthDate;
                this.gender = gender;
                this.genderText = genderText;
                this.cityName = cityName;
                this.countryName = countryName;
                this.userId = userId;
                this.name = name;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getAddress() {
                return address;
            }

            public String getBirthDate() {
                return birthDate;
            }

            public int grtGender() {
                return gender;
            }

            public String getGenderText() {
                return genderText;
            }

            public String getCityName() {
                return cityName;
            }

            public String getCountryName() {
                return countryName;
            }

            public int getUserId() {
                return userId;
            }

            public String getName() {
                return name;
            }
        }
    }


}
