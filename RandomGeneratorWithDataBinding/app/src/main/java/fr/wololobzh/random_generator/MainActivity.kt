package fr.wololobzh.random_generator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.wololobzh.random_generator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var db = ActivityMainBinding.inflate(layoutInflater)
        setContentView(db.root)

        db.btnGenerate.setOnClickListener {
            db.aleatoire = (db.minimum!!.toInt()..db.maximum!!.toInt()).random()
        }
    }
}