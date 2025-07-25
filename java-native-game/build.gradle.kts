/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    `java-library`
    `maven-publish`
    application
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("com.google.dagger:dagger:2.56.2")
    annotationProcessor("com.google.dagger:dagger-compiler:2.56.2")
    testImplementation("com.google.dagger:dagger:2.56.2")
    testAnnotationProcessor("com.google.dagger:dagger-compiler:2.56.2")
    testImplementation(libs.org.junit.jupiter.junit.jupiter)
    testImplementation(libs.org.mockito.mockito.core)
}

group = "org.calebe"
version = "0.2.1-PREVIEW"
description = "java-native-game"
java.sourceCompatibility = JavaVersion.VERSION_16

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

application {
    mainClass.set("com.calebe.Main")
}