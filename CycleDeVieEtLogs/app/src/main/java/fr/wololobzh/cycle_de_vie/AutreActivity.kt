package fr.wololobzh.cycle_de_vie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class AutreActivity : AppCompatActivity() {

    companion object {
        val TAG = "ACOS_AutreActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autre)
        Log.i(TAG,"On passe dans la fonction onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"On passe dans la fonction onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"On passe dans la fonction onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"On passe dans la fonction onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"On passe dans la fonction onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"On passe dans la fonction onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"On passe dans la fonction onDestroy")
    }
}
