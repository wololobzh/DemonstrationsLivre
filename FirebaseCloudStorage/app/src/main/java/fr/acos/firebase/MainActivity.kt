package fr.acos.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import fr.acos.firebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)


        vb.btnEnregistrer.setOnClickListener {
            val user = hashMapOf(
                "first" to vb.etPrenom.text.toString(),
                "last" to vb.etNom.text.toString(),
                "born" to vb.etAnnee.text.toString()
            )

            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this,"Enregistrement effectué",Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Erreur lors de l'enregistrement", Toast.LENGTH_LONG)
                        .show()
                }
        }

        vb.btnAfficher.setOnClickListener {
            db.collection("users")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d("ACOS", "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("ACOS", "Erreur pour afficher les users", exception)
                }
        }
    }
}