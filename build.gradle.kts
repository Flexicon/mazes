plugins {
    kotlin("jvm") version "1.8.10"
    id("org.jlleitschuh.gradle.ktlint") version "11.3.1"
    `java-library`
    `maven-publish`
}

group = "com.github.flexicon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
        }
    }
}
