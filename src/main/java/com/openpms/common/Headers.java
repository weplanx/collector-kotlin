package com.openpms.common;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestHeader;

@Data
public class Headers {
    private long page = 1;
    private long pagesize = 20;
}
