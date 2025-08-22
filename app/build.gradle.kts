plugins {
    application
    checkstyle
    id("org.sonarqube") version "6.2.0.5505"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("hexlet.code.App")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("ch.qos.logback:logback-classic:1.2.6")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "10.12.1"
    configFile = file("config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false
    isShowViolations = true
}

sonar {
    properties {
        property("sonar.projectKey", "TechWizard-SS_java-project-71")
        property("sonar.organization", "techwizard-ss")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}