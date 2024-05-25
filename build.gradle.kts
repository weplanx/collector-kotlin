import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}

group = "com.creator"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    maven {
        url = uri("https://maven.aliyun.com/repository/public/")
    }
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("com.baomidou:mybatis-plus-spring-boot3-starter:3.5.6")
    implementation("com.alibaba.fastjson2:fastjson2-kotlin:2.0.50")
    implementation("com.alibaba.fastjson2:fastjson2-extension-spring6:2.0.50")
    implementation("cn.dev33:sa-token-spring-boot3-starter:1.37.0")
    implementation("cn.dev33:sa-token-redis-fastjson2:1.37.0")
    implementation("org.bouncycastle:bcprov-jdk15to18:1.78.1")
    implementation("cn.hutool:hutool-all:5.8.26")

    runtimeOnly("io.lettuce:lettuce-core")
    runtimeOnly("org.postgresql:postgresql")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
