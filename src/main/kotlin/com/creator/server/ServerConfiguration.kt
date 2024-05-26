package com.creator.server

import cn.dev33.satoken.context.SaHolder
import cn.dev33.satoken.filter.SaFilterAuthStrategy
import cn.dev33.satoken.filter.SaFilterErrorStrategy
import cn.dev33.satoken.filter.SaServletFilter
import cn.dev33.satoken.`fun`.SaFunction
import cn.dev33.satoken.router.SaRouter
import cn.dev33.satoken.stp.StpUtil
import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.JSONReader
import com.alibaba.fastjson2.JSONWriter
import com.alibaba.fastjson2.support.config.FastJsonConfig
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter
import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import com.creator.common.R
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer
import org.springframework.http.MediaType
import java.nio.charset.StandardCharsets

@Configuration
class ServerConfiguration {
    @get:Bean
    val saServletFilter: SaServletFilter
        get() = SaServletFilter()
            .addInclude("/**")
            .addExclude("/favicon.ico")
            .setAuth(SaFilterAuthStrategy { obj: Any? ->
                SaRouter.match(
                    "/**",
                    "/login",
                    SaFunction { StpUtil.checkLogin() })
            })
            .setError(SaFilterErrorStrategy { e: Throwable ->
                SaHolder.getResponse()
                    .setHeader("Content-Type", "application/json;charset=UTF-8")
                    .setStatus(401)
                JSON.toJSONString(R(0, e.message as String))
            })
            .setBeforeAuth(
                SaFilterAuthStrategy { r: Any? ->
                    SaHolder
                        .getResponse()
                        .setServer("pms")
                        .setHeader("X-Frame-Options", "SAMEORIGIN")
                        .setHeader("X-XSS-Protection", "1; mode=block")
                        .setHeader("X-Content-Type-Options", "nosniff")
                }
            )

    @Bean
    fun mybatisPlusInterceptor(): MybatisPlusInterceptor {
        val interceptor = MybatisPlusInterceptor()
        interceptor.addInnerInterceptor(PaginationInnerInterceptor(DbType.POSTGRE_SQL))
        return interceptor
    }

    @Bean
    fun fastJsonConverters(): HttpMessageConverters {
        val converter = FastJsonHttpMessageConverter()
        val config = FastJsonConfig()
        config.setDateFormat("yyyy-MM-dd HH:mm:ss")
        config.setReaderFeatures(JSONReader.Feature.FieldBased, JSONReader.Feature.SupportArrayToBean)
        config.setWriterFeatures(JSONWriter.Feature.WriteMapNullValue, JSONWriter.Feature.PrettyFormat)
        converter.setFastJsonConfig(config)
        converter.setDefaultCharset(StandardCharsets.UTF_8)
        converter.setSupportedMediaTypes(listOf(MediaType.APPLICATION_JSON))
        return HttpMessageConverters(converter)
    }

    @Bean
    fun redisTemplate(factory: RedisConnectionFactory?): RedisTemplate<String, String> {
        val template: RedisTemplate<String, String> = RedisTemplate<String, String>()
        template.setConnectionFactory(factory)
        template.setKeySerializer(StringRedisSerializer())
        template.setValueSerializer(StringRedisSerializer())
        template.afterPropertiesSet()
        return template
    }
}
