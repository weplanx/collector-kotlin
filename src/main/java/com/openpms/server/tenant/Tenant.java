package com.openpms.server.tenant;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.Instant;

@Data
@TableName("`tenant`")
public class Tenant {
    private Long id;
    protected int kind;
    private String code;
    private String name;
    private String nameEn;
    private String tel;
    private String logo;
    private String description;
    private String address;
    protected int status;
    private int sort;
    private Instant createTime;
    private Instant updateTime;
}
