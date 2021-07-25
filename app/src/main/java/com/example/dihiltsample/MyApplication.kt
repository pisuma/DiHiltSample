package com.example.dihiltsample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//このアプリはHiltで動きますというのを教えました。
@HiltAndroidApp
class MyApplication: Application() {
}