package com.bootcamp.fullstackbackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginDto {
    private String email;
    private String password;
}
