# YouTubeExtractor
A helper to extract the streaming URL from a YouTube video using RxJava and Retrofit

[![Build Status](https://travis-ci.org/Commit451/YouTubeExtractor.svg?branch=master)](https://travis-ci.org/Commit451/YouTubeExtractor)
[![](https://jitpack.io/v/Commit451/YouTubeExtractor.svg)](https://jitpack.io/#Commit451/YouTubeExtractor)

## Gradle Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

Then, add the library to your project `build.gradle`
```gradle
dependencies {
    implementation 'com.github.Commit451:YouTubeExtractor:latest.version.here'
}
```

## Usage
If you are familiar with RxJava, the extractor returns a Single:

```kotlin
val extractor = YouTubeExtractor.Builder()
            .build()
extractor.extract("9d8wWcJLnFI")
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({ extraction ->
        bindVideoResult(extraction)
    }, { t ->
        onError(t)
    })
```
Note: the above example also requires [RxAndroid](https://github.com/ReactiveX/RxAndroid) for `AndroidSchedulers`

You can also extract the result right away:
```kotlin
// Don't do this on the main thread!
val extraction = extractor.extract("9d8wWcJLnFI")
    .blockingGet()
```

## Video Playback
This library was only created to extract video stream URLs from YouTube, not provide a video player. [ExoMedia](https://github.com/brianwernick/ExoMedia) is a great library for playing the video streams to the user. See the sample app for an example.

## ProGuard
This library uses [OkHttp](https://github.com/square/okhttp), [Moshi](https://github.com/square/moshi#proguard) and [Rhino](https://github.com/facebook/stetho/tree/master/stetho-js-rhino#proguard) under the hood, so you may need to apply their ProGuard rules.

## Notes
This library is intentionally being kept pretty lightweight, with the main priority being the stream URLs.

Known Failure Points:
- Videos that are age restricted
- Videos that are audio only

License
--------

    Copyright 2018 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
