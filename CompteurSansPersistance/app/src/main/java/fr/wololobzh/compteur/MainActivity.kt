package fr.wololobzh.compteur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var compteur = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickCompteur(view: View) {
        compteur++
        val tv = findViewById<TextView>(R.id.tv_valeur)
        tv.text = compteur.toString()
    }
}
