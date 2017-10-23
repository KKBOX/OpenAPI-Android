# KKBOX OpenAPI SDK for Android

## Development Environment
1. Android Studio 3.0 beta 4 or newer
   1. __DON'T USE OLDER VERSION OF ANDROID STUDIO!!!__, because it doesn't support kotlin.
   1. __DON'T USE IntelliJ__, because it's project file is not compatible with android studio 3.0.
1. Please use __Kotlin__ to develop.

## Develop the library
1. Use the android studio to open the `SDK/openapi_android_developer_sdk` directory to open the project for the sdk.

## Test the library
First, browse [KKBOX Developer Website](https://kkbox.gelato.io/) and create an developer account, and then contact chrisyuan or lance to get client secret for that account.

Then, create a file `ClientInfo.kt` in the `SDK/openapi_android_developer_sdk/OpenAPIDeveloperLibraryClient/src/main/java/com/kkbox/openapideveloperlibraryclient` directory and put your client id and client secret in it.

    package com.kkbox.openapideveloperlibraryclient
    
    object ClientInfo {
        const val CLIENT_ID = "YOUR_CLIENT_ID"
        const val CLIENT_SECRET = "YOUR_CLIENT_SECRET"
    }

Lastly, use Android Studio to open the `SDK/openapi_android_developer_sdk` directory, change to use the `AllTests` configuration and then debug.

## Build the library

    cd SDK/openapi_android_developer_sdk
    ./gradlew assembleDebug

The result aar will be in `${REPOISITORY_DIR}/SDK/openapi_android_developer_sdk/OpenAPIDeveloperLibraryClient/build/outputs/aar/OpenAPIDeveloperLibraryClient-debug.aar`.

## Use the library as local aar
1. Click `File > New > New Module`.
1. Click `Import .JAR/.AAR Package` then click Next.
1. Enter `${REPOISITORY_DIR}/SDK/openapi_android_developer_sdk/OpenAPIDeveloperLibraryClient/build/outputs/aar/OpenAPIDeveloperLibraryClient-debug.aar` then click Finish.
1. Now the module should be copied into your project.
1. Check the app's `settings.gradle`, there should be like this:

        include ':OpenAPIDeveloperLibrary', ':OpenAPIDeveloperLibraryClient'

1. Open the module's `build.gradle` and add dependencies for kotlin and the library like this:

        // only projects that will directly use kotlin files need to apply kotlin-android plugin
        //apply plugin: 'kotlin-android'
        buildscript {
            repositories {
                jcenter()
            }
            ext.kotlin_version = '1.1.51'
            // only projects that will directly use kotlin files need this dependency
            // dependencies {
            //    classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
            //}
        }
        dependencies {
            implementation project(":OpenAPIDeveloperLibrary")
            implementation 'com.koushikdutta.ion:ion:2.2.1'
            implementation "com.google.code.gson:gson:2.8.0"
            // make sure we get kotlin runtime for running the open api library module
            implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
        }

1. Finally sync the project
1. Now the library should be ready
## Documentation
Go to the `SDK/openapi_android_developer_sdk` directory and execute `./gradlew dokka` to generate the documentation, then open the file `SDK/openapi_android_developer_sdk/OpenAPIDeveloperLibrary/build/javadoc/-open-a-p-i-library/index.html`.