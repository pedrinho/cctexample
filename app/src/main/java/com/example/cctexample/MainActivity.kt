package com.example.cctexample

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openCCT(v: View) {
        val uri = Uri.parse("https://inlinebr.herokuapp.com/")

        val intentBuilder = CustomTabsIntent.Builder()

        val customTabsIntent = intentBuilder.build()
        customTabsIntent.launchUrl(v.context, uri)
    }
}
