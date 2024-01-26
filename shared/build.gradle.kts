import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.gmazzo.buildconfig)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here

            // ktor
            implementation("io.ktor:ktor-client-core:2.3.7")
            implementation("io.ktor:ktor-client-logging:2.3.7")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
            implementation("io.ktor:ktor-client-content-negotiation:2.3.7")

            // serialization
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

            // image loader
            api("io.github.qdsfdhvh:image-loader:1.7.1")

            // koin
            api(libs.koin.core)
            api(libs.koin.compose)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation("io.ktor:ktor-client-okhttp:2.3.7")

            // koin
            implementation(libs.koin.android)
            implementation(libs.koin.compose)
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.7")
            implementation("io.ktor:ktor-client-ios:2.3.7")
        }

    }

}

android {
    namespace = "com.hmwn.cinemakmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
    }
}
dependencies {
    implementation("androidx.core:core-ktx:+")
}

val properties = Properties()
properties.load(project.rootProject.file("local.properties").inputStream())

buildConfig {

    useKotlinOutput { topLevelConstants = true }

    buildConfigField("String", "API_KEY", "\"${properties.getProperty("api_key")}\"")
//    buildConfigField("String", "BASE_URL", "https://api.themoviedb.org/")
//    buildConfigField("String", "IMAGE_URL", "https://image.tmdb.org/t/p/w342")
}
