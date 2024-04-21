package com.openpms.server.tenants;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TenantMapper {
    Long create(Tenant tenant);

    void createInfo(TenantInfo tenantInfo);

    Tenant[] findMany(Long id);

    TenantInfo find(Long id);

    int update(Tenant tenant);

    int updateInfo(TenantInfo tenantInfo);

    int delete(Long id);

    int deleteInfo(Long id);
}