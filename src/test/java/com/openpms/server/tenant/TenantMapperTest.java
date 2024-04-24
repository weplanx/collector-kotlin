package com.openpms.server.tenant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
public class TenantMapperTest {
    @Autowired
    private TenantService tenantService;

    @Test
    void mockTenants() {
        Collection<Tenant> tenants = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Tenant tenant = new Tenant();
            tenant.setKind(1);
            tenant.setCode("code" + i);
            tenant.setName("tenant" + i);
            tenant.setStatus(1);
            tenants.add(tenant);
        }
        tenantService.saveBatch(tenants);
    }
}
