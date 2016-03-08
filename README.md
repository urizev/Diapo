# Under construction

This `README.md` file is under heavy edition and could change in next days. Please, wait til this section is removed

------

# Gradle Dependency

### Repository

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

And add this in `build.gradle` file of the module you want to use the library.

```gradle
dependencies {
	...
    compile('com.github.urizev:diapo:0.4') {
    }
}
```

---

# Sample Project

You can download the latest sample APK from Google Play

<a href="https://play.google.com/store/apps/details?id=org.urizev.diapo" target="_blank">
  <img alt="Get it on Google Play"
       src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" height="60"/>
</a>

Having the sample project installed is a good way to be notified of new releases. Although Watching this 
repository will allow GitHub to email you whenever I publish a release.

