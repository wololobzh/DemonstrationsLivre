package fr.wololobzh.compteuravecviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import fr.wololobzh.compteuravecviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        var vm = ViewModelProvider(this).get(CompteurViewModel::class.java)

        vb.tvValeur.text = vm.compteur.toString()

        vb.btnCompteur.setOnClickListener {
            vm.plusUn()
            vb.tvValeur.text = vm.compteur.toString()
        }
    }
}