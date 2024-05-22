package com.tntproduction.model.customresponse;

import lombok.Data;

@Data
public class CustomErrorResponse {
    private int status;
    private String error;
    private String message;
}
