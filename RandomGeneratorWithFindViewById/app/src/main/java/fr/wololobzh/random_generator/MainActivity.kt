package fr.wololobzh.random_generator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickGenerate(view: View)
    {
        val min = findViewById<EditText>(R.id.etn_minimum)
        val max = findViewById<EditText>(R.id.etn_maximum)

        val generate = (min.text.toString().toInt()..max.text.toString().toInt()).random()
        val resultat = findViewById<TextView>(R.id.tv_valeur_resultat)
        resultat.setText(generate.toString())
    }
}
