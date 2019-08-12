package com.example.cctexample

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HandleReturn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val action: String? = intent?.action
        val data: Uri? = intent?.data

        val baToken = data?.getQueryParameter("ba_token")

        val msg = if (baToken != null) "User accepted Billing Agreement" else "User canceled"

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}