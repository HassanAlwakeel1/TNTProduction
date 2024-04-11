package com.tntproduction.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ChangePasswordRequest {
    private String token;
    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
}
