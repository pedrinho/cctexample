package com.example.cctexample

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openCCT(v: View) {
        val text = findViewById<View>(R.id.approval_url) as EditText
        val approvalUrl = text.text.toString()

        if (approvalUrl.isNotEmpty()) {
            val uri = Uri.parse(approvalUrl)

            val intentBuilder = CustomTabsIntent.Builder()
            val customTabsIntent = intentBuilder.build()
            customTabsIntent.launchUrl(v.context, uri)
        } else {
            Toast.makeText(this, "Please input an approval URL", Toast.LENGTH_LONG).show()
        }
    }
}
