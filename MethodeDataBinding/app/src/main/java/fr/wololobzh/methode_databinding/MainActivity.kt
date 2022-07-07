package fr.wololobzh.methode_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.wololobzh.methode_databinding.databinding.ActivityMainBinding

data class Personne(var nom:String="Nom",var prenom:String="Prénom",var numero:String="Numéro",var rue:String="Rue",var codePostal:String="Code Postal",var ville:String="Ville")

class MainActivity : AppCompatActivity() {
    private lateinit var bd: ActivityMainBinding
    var unePersonne:Personne = Personne()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bd.root)

        bd.tvTitre.text = "Formulaire 53D";

        bd.personne = unePersonne

        bd.btnEnvoyer.setOnClickListener {
            Log.i("ACOS","Bonjour ${unePersonne.nom} " +
                    "${unePersonne.prenom}, vous habitez à ${unePersonne.numero} " +
                    "${unePersonne.rue} ${unePersonne.codePostal} ${unePersonne.ville} ")
        }
    }
}