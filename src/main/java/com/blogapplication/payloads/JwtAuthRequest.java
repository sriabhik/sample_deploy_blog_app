package com.blogapplication.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {
    String username;
    String password;
}
