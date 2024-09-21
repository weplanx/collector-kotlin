plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.weplanx"
version = "1.0-SNAPSHOT"


repositories {
    maven {
        setUrl("https://maven.aliyun.com/repository/public/")
    }
    maven {
        setUrl("https://maven.aliyun.com/repository/gradle-plugin/")
    }
    mavenLocal()
    mavenCentral()
}



dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}