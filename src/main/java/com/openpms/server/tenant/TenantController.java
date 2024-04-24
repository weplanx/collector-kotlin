package com.openpms.server.tenant;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.openpms.common.R;
import com.openpms.server.tenant.dto.CreateBody;
import com.openpms.server.tenant.dto.UpdateBody;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("tenants")
public class TenantController {
    private final TenantService tenantService;

    @GetMapping
    public ResponseEntity<?> list(
        @RequestHeader(value = "x-page", defaultValue = "1") @Min(1) long current,
        @RequestHeader(value = "x-pagesize", defaultValue = "10") @Min(1) long size,
        @RequestParam(value = "name", required = false) String name
    ) {
        IPage<Tenant> page = new Page<>(current, size);
        QueryWrapper<Tenant> query = new QueryWrapper<>();
        if (name != null) {
            query.like("name", name);
        }
        IPage<Tenant> result = tenantService.page(page, query);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        Tenant tenant = tenantService.getById(id);
        if (tenant == null) {
            return R.Fail(0, "数据不存在");
        }
        return ResponseEntity.ok(tenant);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody CreateBody body) {
        tenantService.save(body);
        return R.Ok();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UpdateBody body) {
        body.setId(id);
        tenantService.updateById(body);
        return R.Ok();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        tenantService.removeById(id);
        return R.Ok();
    }
}
