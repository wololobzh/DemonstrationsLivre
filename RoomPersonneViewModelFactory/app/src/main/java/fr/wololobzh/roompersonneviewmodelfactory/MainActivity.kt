package fr.wololobzh.roompersonneviewmodelfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.wololobzh.roompersonneviewmodelfactory.databinding.ActivityMainBinding

@Entity
data class Personne (@PrimaryKey(autoGenerate = true) var id:Long = 0L, var nom:String, var prenom:String)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var db = ActivityMainBinding.inflate(layoutInflater)

        var vm = ViewModelProvider(this,ViewModelFactory(this)).get(RandomPersonneViewModel::class.java)

        db.model = vm.personne.value;

        vm.personne.observe(this, Observer {
            db.model = it
        })

        db.btnRandom.setOnClickListener {
            vm.randomPersonne()
        }

        setContentView(db.root)
    }
}
