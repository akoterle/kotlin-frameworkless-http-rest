import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.11"
}

group = "it.koterle.learning.kotlin"
version = "1.0-SNAPSHOT"
group = "it.akoterle.learning.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("javax.servlet:javax.servlet-api:4.0.1")
    compile("org.eclipse.jetty:jetty-servlet:9.4.12.v20180830")
    compile ("io.jsonwebtoken:jjwt:0.9.0")
    compile("com.fasterxml.jackson.core:jackson-annotations:2.9.7")
    compile ("com.fasterxml.jackson.core:jackson-databind:2.9.7")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Wrapper> {
    gradleVersion = "5.0"
}