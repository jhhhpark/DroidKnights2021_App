import dependencies.Dep
import dependencies.Versions

plugins {
    id 'com.android.library'
    id 'kotlin-android'
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
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
    buildFeatures {
        dataBinding true
    }
}

dependencies {
    implementation project(path: ':domain')
    implementation project(path: ':features:core-ui')
    implementation project(path: ':shared')

    implementation Dep.AndroidX.core
    implementation Dep.AndroidX.appcompat
    implementation Dep.AndroidX.fragment
    implementation Dep.AndroidX.material
    implementation Dep.AndroidX.Lifecycle.viewModel
    implementation Dep.AndroidX.recyclerview
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'

    implementation Dep.Kotlin.dateTime

    implementation Dep.Dagger.hiltAndroid
    kapt Dep.Dagger.hiltCompiler

    implementation Dep.timber

    testImplementation Dep.Test.junit
    androidTestImplementation Dep.Test.junitExt
    androidTestImplementation Dep.Test.espresso
}