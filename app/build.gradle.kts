plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.youtubeplayerapi"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.youtubeplayerapi"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        packagingOptions {
            exclude ("META-INF/DEPENDENCIES")
        }
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation ("com.google.apis:google-api-services-youtube:v3-rev20210915-1.32.1")
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0")
    //Parceler dependencies
    implementation ("org.parceler:parceler-api:1.1.13")
    annotationProcessor ("org.parceler:parceler:1.1.13")


}