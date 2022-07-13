package fr.wololobzh.recyclerviewsimpleaveconclicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import fr.wololobzh.recyclerviewsimpleaveconclicklistener.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val listePersonnesViewModel = ViewModelProvider(this).get(ListePersonnesViewModel::class.java)

        val adapter = ListPersonnesAdapter(PersonneListener
        {
                personneId -> Toast.makeText(this, "${personneId}", Toast.LENGTH_LONG).show()
        })
        vb.rvPersonnes.adapter = adapter

        vb.rvPersonnes.adapter = adapter
        adapter.submitList(listePersonnesViewModel.listePersonnes)
    }
}