package com.ldh.smarthouse.Model.Response;

public class LoginResult {
    private String access_token;

    public LoginResult(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
