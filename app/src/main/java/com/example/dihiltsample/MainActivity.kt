package com.example.dihiltsample

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

//注入先を定義(MainActivityはHiltを使います！というのをHiltに対して教えている)
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var action: Action
    var km: Double = 0.0

    //Hiltモジュールを作成(MainActivityにActionクラスを依存性注入)
    //インスタンスの寿命指定 SingleComponentはアプリと寿命が一緒(applicationContext的な)
    @InstallIn(SingletonComponent::class)
    //このクラスがHiltであることの証明
    @Module
    object ActionModule {
        //インスタンス生成時のメソッド
        @Provides
        @Singleton
        fun provideAction(): Action = Action()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        km = action.run(km)
        Log.d("debug-app","$km")
    }
}



class Action() {
    fun run(distance: Double): Double = distance + 10.0
}