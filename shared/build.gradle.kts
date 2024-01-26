@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose)
    alias(libs.plugins.jetbrains.kotlin.serialization)
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


        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation("io.ktor:ktor-client-okhttp:2.3.7")
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
