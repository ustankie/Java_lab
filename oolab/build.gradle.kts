plugins {
//    kotlin("jvm") version "1.5.31"
    application
//    id("application")
    id("java")
    id("org.openjfx.javafxplugin") version "0.0.13"
}



group = "org.example"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

javafx {

    modules("javafx.base", "javafx.controls", "javafx.fxml", "javafx.graphics", "javafx.media", "javafx.swing", "javafx.web")
    version = "17"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.openjfx:javafx-controls:17")
    implementation("org.openjfx:javafx-fxml:17")
    implementation("org.openjfx:javafx-graphics:17")
    implementation("org.openjfx:javafx-media:17")
    implementation("org.openjfx:javafx-swing:17")
    implementation("org.openjfx:javafx-web:17")

}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("agh.ics.oop.World")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}