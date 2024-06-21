import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import java.util.Base64

plugins {
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("com.android.application")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
}

fun getProperty(key: String): String {
    return gradleLocalProperties(project.rootDir).getProperty(key)
}

fun getDecodedProperty(key: String): String {
    val property = getProperty(key)

    return String(Base64.getDecoder().decode(property))
}

android {
    namespace = "com.speechlesscompany.compasskoala"
    compileSdk = 34

    signingConfigs {
        create("release") {
            storeFile = file("./keys/compasskoala.jks")
            storePassword = getDecodedProperty("STORE_PASSWORD")
            keyAlias = getDecodedProperty("KEY_ALIAS")
            keyPassword = getDecodedProperty("KEY_PASSWORD")
        }
    }

    defaultConfig {
        minSdk = 26
        targetSdk = 34
        applicationId = "com.speechlesscompany.compasskoala"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        versionCode = 1
        versionName = "0.0.1"
    }

    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions.jvmTarget = libs.versions.kotlinJavaTarget.get()

    sourceSets["main"].java {
        srcDir("src/main/java")
    }

    packaging {
        jniLibs.excludes.add("META-INF/licenses/**")
        jniLibs.excludes.add("META-INF/AL2.0")
        jniLibs.excludes.add("META-INF/LGPL2.1")
    }
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.core.testing)

    implementation(libs.lifecycle.scope)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.livedata)
    implementation(libs.material)

    androidTestImplementation(libs.robolectric)
    androidTestImplementation(libs.test.core)
    androidTestImplementation(libs.test.runner)

    implementation(libs.hilt.core)
    implementation(libs.hilt.navigationcompose)
    kapt(libs.hilt.compiler)
    kapt(libs.dagger.compiler)

    implementation(libs.splash)

    implementation(libs.compose.ui)
    implementation(libs.compose.runtime)
    implementation(libs.compose.uigraphics)
    implementation(libs.compose.uitooling)
    implementation(libs.compose.foundationlayout)
    implementation(libs.compose.material)
    implementation(libs.compose.material3)

    implementation(libs.compose.activity)
    implementation(libs.compose.constraintlayout)
    implementation(libs.compose.placeholder)
    implementation(libs.compose.navigation)
    implementation(libs.compose.paging)
    implementation(libs.compose.permissions)

    implementation(libs.generativeai)

    implementation(libs.camera.core)
    implementation(libs.camera.camera2)
    implementation(libs.camera.lifecycle)
    implementation(libs.camera.view)

    implementation(libs.retrofit)
    implementation(libs.gson.converter)
    implementation(libs.gson)
    implementation(libs.okhttp.core)
    implementation(libs.okhttp.interceptors)

    implementation(libs.glide)
    implementation(libs.shimmer)
    implementation(libs.coil)

    implementation(libs.room.core)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    implementation(platform(libs.google.platform))
    implementation(libs.google.analytics.firebasektx)
    implementation(libs.google.crashlytics.firebase)
    implementation(libs.google.analytics.firebase)
    implementation(libs.google.performance.firebase)
    implementation(libs.google.appcheck.firebase)
    implementation(libs.google.appcheck.debug.firebase)
}
