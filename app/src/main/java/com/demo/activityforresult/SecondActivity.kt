package com.demo.activityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.activityforresult.databinding.ActivitySecondBinding


private lateinit var activitySecondBinding: ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySecondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(activitySecondBinding.root)

        activitySecondBinding.btnSubmit.setOnClickListener() {
// This is used send the custom data with the result.
            val intent = Intent()
            intent.putExtra(MainActivity.NOM, activitySecondBinding.etEmail.text.toString())
            intent.putExtra(MainActivity.EMAIL, activitySecondBinding.etName.text.toString())

            setResult(
                Activity.RESULT_OK,
                intent
            ) // It is used to set the RESULT OK and a custom data values which we wants to send back.
            finish()
        }


    }
}