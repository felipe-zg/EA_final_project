package com.example.ea_final_project.payload.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private Integer token;
    private String type = "Bearer";
    private String id;
    private String email;
    private List<String> roles;

    public JwtResponse(Integer accessToken, String id, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.email = email;
        this.roles = roles;
    }

    public Integer getAccessToken() {
        return token;
    }

    public void setAccessToken(Integer accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}