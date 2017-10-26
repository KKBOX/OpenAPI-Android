# KKBOX OpenAPI SDK for Android

## SDK usage
### Import the SDK
In the module which uses the SDK, add following lines in build.gradle
```
buildscript {
    repositories {
        jcenter()
    }
}
dependencies {
    compile 'com.kkbox:openapideveloper:${sdk_version}'
}
```
### Prepare client ID & client secret
Browse [KKBOX Developer Website](https://developer.kkbox.com/) and create an developer account, then create an app to get the client ID and client secret.
### Use the SDK
First import the sdk packages.
```
import com.kkbox.openapideveloper.api.Api
import com.kkbox.openapideveloper.auth.Auth
```
Then obtaining the access token with the client ID and client secret you just get.
```
auth = Auth(CLIENT_ID, CLIENT_SECRET, context)
accessToken= auth.clientCredentialsFlow.fetchAccessToken().get().get("access_token").asString
```
After obtaining the access token, you may call APIs like this:
```
api = Api(accessToken, "TW", context)
val searchResult = api.searchFetcher.fetchSearchResult(offset=offset).get()
```
By the way, you can run the app in the `SDK/openapi_android_developer_sdk/OpenAPIDeveloperLibraryClient` directory, it may help you to know the usage clearly.
### SDK document
Please browse [https://kkbox.github.io/OpenAPI-Android/](https://kkbox.github.io/OpenAPI-Android/)

## SDK Development
### Development Environment
1. Android Studio 3.0
   1. __DON'T USE OLDER VERSION OF ANDROID STUDIO!!!__, because it doesn't support kotlin.
   1. __DON'T USE IntelliJ__, because it's project file is not compatible with android studio 3.0.
1. Please use __Kotlin__ to develop.

### Develop the library
Use the android studio to open the `SDK/openapi_android_developer_sdk` directory to open the project for the sdk.

### Test the library
First, browse [KKBOX Developer Website](https://developer.kkbox.com/) and create an developer account, and then create an app to get the client ID and client secret.

Then, create a file `ClientInfo.kt` in the `SDK/openapi_android_developer_sdk/OpenAPIDeveloperLibraryClient/src/main/java/com/kkbox/openapideveloperlibraryclient` directory and put your client id and client secret in it.

    package com.kkbox.openapideveloperlibraryclient
    
    object ClientInfo {
        const val CLIENT_ID = "YOUR_CLIENT_ID"
        const val CLIENT_SECRET = "YOUR_CLIENT_SECRET"
    }

Lastly, use Android Studio to open the `SDK/openapi_android_developer_sdk` directory, change to use the `AllTests` configuration and then debug.

### Build the library

    cd SDK/openapi_android_developer_sdk
    ./gradlew assembleDebug

The result aar will be in `${REPOISITORY_DIR}/SDK/openapi_android_developer_sdk/OpenAPIDeveloperLibraryClient/build/outputs/aar/OpenAPIDeveloperLibraryClient-debug.aar`.

### Use the library as local aar
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
            implementation 'com.google.code.gson:gson:2.8.0'
            // make sure we get kotlin runtime for running the open api library module
            implementation 'org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version'
        }

1. Finally sync the project
1. Now the library should be ready
### Generate Documentation
Go to the `SDK/openapi_android_developer_sdk` directory and execute `./gradlew dokka` to generate the documentation, then open the file `SDK/openapi_android_developer_sdk/OpenAPIDeveloperLibrary/build/javadoc/-open-a-p-i-library/index.html`.

## License
Copyright 2017 KKBOX Technologies Limited

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
