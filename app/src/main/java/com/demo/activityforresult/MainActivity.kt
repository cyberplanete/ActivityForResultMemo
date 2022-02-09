package com.demo.activityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.demo.activityforresult.databinding.ActivityMainBinding


private lateinit var activityMainBinding: ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object{
        const val NOM = "nom"
        const val EMAIL = "email"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnLaunchActivityFirst?.setOnClickListener {
            val intent = Intent(this@MainActivity, FirstActvity::class.java)
            firstActivityResultLauncher.launch(intent)
        }

        activityMainBinding.btnLaunchActivitySecond?.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            secondActivityResultLauncher.launch(intent)
        }


    }

    /// The ActivityResultLauncher is of generic type which means it can launch different types like intent, uri, string and so on. In this case we are launching an intent
    // so we create an ActivityResultLauncher variable of type Intent to register the intent for a result.
    var firstActivityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                //receive data from firstActivity
                activityMainBinding.tvFirstActivityResult?.text = "First Activity Result Success."
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                Log.e("Cancelled", "Cancelled")
                Toast.makeText(this@MainActivity, "Result Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

    private var secondActivityResultLauncher:ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if (result.resultCode== Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            //receive data from secondActivity
            if (data != null) {
                // Here the data which we have sent from the second activity is received and displayed in the textview.
                val name = data.getStringExtra(NOM)
                val email = data.getStringExtra(EMAIL)

               activityMainBinding.tvSecondActivityResult?.text= "$name    $email"
            }
        } else if (result.resultCode== Activity.RESULT_CANCELED) {
            Log.e("Cancelled", "Cancelled")
            Toast.makeText(this@MainActivity,"Result Cancelled", Toast.LENGTH_SHORT).show()
        }
    }


}
