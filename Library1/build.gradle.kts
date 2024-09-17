plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "vn.alitrade.library1"
    compileSdk = 34

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.tuyendv-dev"
                artifactId = "Library1"
                version = "1.0.0"

                // Configure the generated POM
                pom {
                    name.set("Library1")
                    description.set("An awesome Android library1.")
                    url.set("https://github.com/tuyendv-dev/TuyenLib222")

                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }

                    developers {
                        developer {
                            id.set("tuyendv-dev")
                            name.set("Doan Tuyen")
                            email.set("developer@example.com")
                        }
                    }

                    scm {
                        connection.set("scm:git:git://github.com/tuyendv-dev/TuyenLib222.git")
                        developerConnection.set("scm:git:ssh://github.com/tuyendv-dev/TuyenLib222.git")
                        url.set("https://github.com/tuyendv-dev/TuyenLib222")
                    }
                }
            }
        }
    }
}