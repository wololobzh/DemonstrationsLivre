package fr.wololobzh.methode_viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.wololobzh.methode_viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var vb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.tvTitre.text = "Formulaire 53D";

        vb.btnEnvoyer.setOnClickListener {
            Log.i("ACOS","Bonjour ${vb.etPrenom.text} " +
                    "${vb.etNom.text}, vous habitez à ${vb.etNumero.text} " +
                    "${vb.etRue.text} ${vb.etCodePostal.text} ${vb.etVille.text} ")
        }
    }
}
