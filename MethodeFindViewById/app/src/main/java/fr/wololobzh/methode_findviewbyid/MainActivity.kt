package fr.wololobzh.methode_findviewbyid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    lateinit var tvTitre: TextView
    lateinit var etNom: EditText
    lateinit var etPrenom:EditText
    lateinit var etNumero:EditText
    lateinit var etRue:EditText
    lateinit var etVille:EditText
    lateinit var etCodePostal:EditText
    lateinit var btnEnvoyer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTitre = findViewById(R.id.tv_titre)
        etNom = findViewById<EditText>(R.id.et_nom)
        etPrenom = findViewById<EditText>(R.id.et_prenom)
        etNumero = findViewById<EditText>(R.id.et_numero)
        etRue = findViewById<EditText>(R.id.et_rue)
        etVille = findViewById<EditText>(R.id.et_ville)
        etCodePostal = findViewById<EditText>(R.id.et_code_postal)
        btnEnvoyer = findViewById<Button>(R.id.btn_envoyer)

        tvTitre.text = "Formulaire 53D";

        btnEnvoyer.setOnClickListener {
            Log.i("ACOS","Bonjour ${etPrenom} " +
                    "${etNom.text}, vous habitez à ${etNumero.text} " +
                    "${etRue.text} ${etCodePostal} ${etVille.text} ")
        }
    }
}