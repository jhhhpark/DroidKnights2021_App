import dependencies.Dep
import dependencies.Versions

plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
}

android {
    compileSdk Versions.compileSdk
    buildToolsVersion Versions.buildTools

    defaultConfig {
        applicationId "com.droidknights.app2021"
        minSdk Versions.minSdk
        targetSdk Versions.targetSdk
        versionCode Versions.versionCode
        versionName Versions.versionName

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding true
        dataBinding true
    }
    kapt {
        correctErrorTypes true
    }
}

dependencies {
    implementation project(path: ':features:home')
    implementation project(path: ':features:schedule')
    implementation project(path: ':features:setting')
    implementation project(path: ':features:detail')
    implementation project(path: ':navigator')
    implementation project(path: ':shared')
    implementation project(path: ':domain')
    implementation project(path: ':data')

    implementation Dep.AndroidX.core
    implementation Dep.AndroidX.appcompat
    implementation Dep.AndroidX.material
    implementation Dep.AndroidX.constraintlayout
    implementation Dep.AndroidX.Navigation.fragment
    implementation Dep.AndroidX.Navigation.ui

    implementation Dep.Dagger.hiltAndroid
    kapt Dep.Dagger.hiltCompiler

    implementation Dep.Kotlin.coroutine

    implementation Dep.timber

    testImplementation Dep.Test.junit
    androidTestImplementation Dep.Test.junitExt
    androidTestImplementation Dep.Test.espresso
}