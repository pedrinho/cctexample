package com.example.cctexample

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

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

            customTabsIntent.launchUrl(this, uri)
        } else {
            Toast.makeText(v.context, "Please input an approval URL", Toast.LENGTH_LONG).show()
        }
    }

    fun getApproval(v: View) {
        val httpAsync = "https://runkit.io/pedrinho/approval-url/8.0.0"
            .httpGet()
            .responseString { _, _, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        println(ex)
                        Toast.makeText(v.context, "Error getting Approval URL", Toast.LENGTH_LONG).show()
                    }
                    is Result.Success -> {
                        val data = result.get()
                        val text = findViewById<View>(R.id.approval_url) as EditText
                        text.setText(data, TextView.BufferType.EDITABLE)
                        println(data)
                    }
                }
            }

        httpAsync.join()
    }
}
