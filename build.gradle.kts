plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.vicrum"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.liquibase:liquibase-core")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// https://mvnrepository.com/artifact/org.modelmapper/modelmapper
	implementation("org.modelmapper:modelmapper:2.1.1")
	// https://mvnrepository.com/artifact/jakarta.validation/jakarta.validation-api
	implementation("jakarta.validation:jakarta.validation-api:3.0.2")
	// https://mvnrepository.com/artifact/org.springframework/spring-aop
	implementation("org.springframework:spring-aop:6.1.2")
	// https://mvnrepository.com/artifact/org.aspectj/aspectjrt
	runtimeOnly("org.aspectj:aspectjrt:1.9.21")





}

tasks.withType<Test> {
	useJUnitPlatform()
}
