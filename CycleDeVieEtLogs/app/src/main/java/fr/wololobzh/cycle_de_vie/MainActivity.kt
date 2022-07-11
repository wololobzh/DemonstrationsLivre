package fr.wololobzh.cycle_de_vie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "ACOS_MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    fun onClickAutre(view: View) {
        val intent = Intent(this,AutreActivity::class.java)
        startActivity(intent)
    }
}
