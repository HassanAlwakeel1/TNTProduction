package com.tntproduction.model.customresponse;

import lombok.Builder;
import lombok.Data;

@Data
public class CustomResponse<T>{
    private int status;
    private String message;
    private T data;
}
