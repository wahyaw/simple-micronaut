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
public class ResponseEntity<T> {
    private ResponseStatus responseStatus;
    private T data;

    public ResponseEntity(T data) {
        this.responseStatus = new ResponseStatus("00", "SUCCESS");
        this.data = data;
    }
}
