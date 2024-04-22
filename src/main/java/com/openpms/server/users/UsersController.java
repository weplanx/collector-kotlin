package com.openpms.server.users;

import com.openpms.server.users.dto.CreateParam;
import com.openpms.server.users.dto.GetResult;
import com.openpms.server.users.dto.UpdateParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> create(@Valid @RequestBody CreateParam param) {
        Long id = userService.create(param);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UpdateParam param) {
        int count = userService.update(id, param);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        int count = userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
