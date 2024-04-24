package com.openpms.server.tenant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TenantInfo extends Tenant {
    private String cover;
    private String fax;
    private String email;
    private Object album;
    private String content;
    private Object location;
}
