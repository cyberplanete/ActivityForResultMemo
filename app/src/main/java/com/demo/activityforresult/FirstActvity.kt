package com.demo.activityforresult

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.activityforresult.databinding.ActivityFirstActvityBinding

private lateinit var activityFirstActvityBinding: ActivityFirstActvityBinding

class FirstActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityFirstActvityBinding = ActivityFirstActvityBinding.inflate(layoutInflater)
        setContentView(activityFirstActvityBinding.root)


       activityFirstActvityBinding.btnFinish.setOnClickListener{
            setResult(Activity.RESULT_OK) // It is used to set the RESULT OK which means it is success action which we wants to send back.
            finish()
        }

    }

}