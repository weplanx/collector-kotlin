package com.openpms.server.tenants;

import lombok.Data;

import java.time.Instant;

@Data
public class Tenant {
    private Long id;
    private int kind;
    private String code;
    private String name;
    private String logo;
    private String cover;
    private int status;
    private int sort;
    private int del;
    private Instant createTime;
    private Instant updateTime;
}
