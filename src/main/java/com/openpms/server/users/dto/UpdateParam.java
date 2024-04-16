package com.openpms.server.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateParam {
    private String email;
    private String password;
    private String name;
    private String avatar;
    private Boolean status;
}
