import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
}

val githubProperties = Properties().apply {
    load(FileInputStream(rootProject.file("github.properties")))
}

val versionName = "0.0.1"
val artifactId = "composable"

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("bar") {
                from(components["release"])

                groupId = "id.co.edtslib"
                artifactId = artifactId
                version = versionName

                pom {
                    name.set(artifactId)
                    description.set("A collection of composable for Edts Android project")
                    url.set("https://github.com/Dhanfinix/EdtsComposable")
                }
            }
        }

        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/Dhanfinix/EdtsComposable")

                credentials {
                    username = githubProperties["USER_ID"]?.toString() ?: System.getenv("USER_ID")
                    password = githubProperties["ACCESS_TOKEN"]?.toString() ?: System.getenv("ACCESS_TOKEN")
                }
            }
        }
    }
}

android {
    namespace = "edts.android.composable"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}