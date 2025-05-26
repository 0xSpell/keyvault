plugins {
    kotlin("jvm") version "2.1.21"
    kotlin("plugin.allopen") version "2.1.21"
    id("com.google.devtools.ksp") version "2.1.21-2.0.1"
    id("com.gradleup.shadow") version "8.3.6"
    id("io.micronaut.application") version "4.5.3"
    id("io.micronaut.aot") version "4.5.3"
}

version = "0.1"
group = "com.example.keyvault"

repositories {
    mavenCentral()
}

dependencies {
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut.discovery:micronaut-discovery-client")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.apache.logging.log4j:log4j-core:2.22.1")
    runtimeOnly("org.apache.logging.log4j:log4j-api:2.22.1")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl:2.22.1")
}

application {
    mainClass.set("com.example.keyvault.ApplicationKt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.keyvault.*")
    }
}

ksp {
    arg("micronaut.processing.incremental", "true")
    arg("micronaut.processing.annotations", "com.example.keyvault.*")
}

graalvmNative {
    toolchainDetection.set(false)
}
