import dependencies.Dep
import dependencies.Versions

plugins {
    id 'com.android.library'
    id 'kotlin-android'
}

android {
    compileSdk Versions.compileSdk
    buildToolsVersion Versions.buildTools

    defaultConfig {
        minSdk Versions.minSdk
        targetSdk Versions.targetSdk
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles "consumer-rules.pro"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

dependencies {
    implementation project(path: ':shared')
    implementation project(path: ':data')

    implementation Dep.AndroidX.core
    implementation Dep.AndroidX.appcompat
    implementation Dep.AndroidX.material

    implementation Dep.inject

    implementation Dep.Kotlin.coroutine
    implementation Dep.Kotlin.dateTime

    implementation Dep.timber

    testImplementation project(path: ':test-shared')
    testImplementation Dep.Test.junit
    androidTestImplementation Dep.Test.junitExt
    androidTestImplementation Dep.Test.espresso
}