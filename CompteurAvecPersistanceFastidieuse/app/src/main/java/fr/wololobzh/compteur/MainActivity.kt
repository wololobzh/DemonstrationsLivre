package fr.wololobzh.compteur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var compteur = 0;
    lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById<TextView>(R.id.tv_valeur)
    }

    fun onClickCompteur(view: View) {
        compteur++
        tv.text = compteur.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("ACOS","Sauvegarde : $compteur")
        outState.putInt("compteur",compteur)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        compteur = savedInstanceState.getInt("compteur")
        Log.i("ACOS","Chargement : $compteur")
        tv.text = compteur.toString()
    }
}
