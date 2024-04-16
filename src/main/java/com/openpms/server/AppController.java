package com.openpms.server;

import com.openpms.common.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AppController {
    @GetMapping
    public R index() {
        return new R(0, "no error");
    }
}
