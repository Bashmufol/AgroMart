package com.bash.agricdeckmvp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseModel<T> {
    private int status;
    private String message;
    private T data;
}
