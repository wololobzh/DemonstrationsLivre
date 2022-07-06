package fr.wololobzh.methode_viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.wololobzh.methode_viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var bd: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bd.root)

        bd.tvTitre.text = "Formulaire 53D";

        bd.btnEnvoyer.setOnClickListener {
            Log.i("ACOS","Bonjour ${bd.etPrenom.text} " +
                    "${bd.etNom.text}, vous habitez à ${bd.etNumero.text} " +
                    "${bd.etRue.text} ${bd.etCodePostal.text} ${bd.etVille.text} ")
        }
    }
}
