import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.jmailen.kotlinter") version "3.12.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.odenizturker"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    // Spring
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-oauth2-jose")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

    // Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // Postgres
    runtimeOnly("org.postgresql:postgresql")

    // Flyway Migration
    implementation("org.flywaydb:flyway-core")

    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Security
    implementation("org.springframework.security:spring-security-oauth2-authorization-server:1.0.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.bootRun {
    doFirst {
        systemProperty("database.endpoint", System.getenv("DATABASE_ENDPOINT") ?: "localhost:5433")
        systemProperty("database.name", System.getenv("DATABASE_NAME") ?: "gather_test")
        systemProperty("database.user", System.getenv("DATABASE_USER") ?: "db_user")
        systemProperty("database.password", System.getenv("DATABASE_PASSWORD") ?: "db_pass")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
