package fr.wololobzh.premierrecyclerviewsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import fr.wololobzh.premierrecyclerviewsimple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val listePersonnesViewModel = ViewModelProvider(this).get(ListePersonnesViewModel::class.java)

        val adapter = ListPersonnesAdapter()
        vb.rvPersonnes.adapter = adapter
        adapter.submitList(listePersonnesViewModel.listePersonnes)
    }
}