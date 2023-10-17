package com.example.dto;


import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Serdeable
public class ResponseStatus {
    private String responseCode;
    private String responseDesc;
}
