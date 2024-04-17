package com.openpms.server.users;

import com.openpms.common.R;
import com.openpms.server.users.dto.CreateParam;
import com.openpms.server.users.dto.GetResult;
import com.openpms.server.users.dto.UpdateParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UsersController {
    private final UsersService userService;

    @GetMapping("/{id}")
    public GetResult get(@PathVariable("id") Long id) {
        return new GetResult(userService.findById(id));
    }

    @PostMapping("create")
    public R<?> create(@Valid @RequestBody CreateParam param) {
        Long id = userService.create(param);
        return new R<>(0, "ok");
    }

    @PatchMapping("/{id}")
    public R<?> updateById(@PathVariable("id") Long id, @RequestBody UpdateParam param) {
        int count = userService.updateById(id, param);
        return new R<>(0, "ok");
    }

    @DeleteMapping("/{id}")
    public R<?> deleteById(@PathVariable("id") Long id) {
        int count = userService.deleteById(id);
        return new R<>(0, "ok");
    }
}
