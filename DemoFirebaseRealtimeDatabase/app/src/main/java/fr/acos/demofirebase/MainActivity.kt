package fr.acos.demofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import fr.acos.demofirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val database = Firebase.database
    val myRef = database.getReference("wololo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vb = ActivityMainBinding.inflate(layoutInflater)

        vb.btnSave.setOnClickListener {
            myRef.setValue(vb.etSaisieValeurWololo.text.toString())
        }

        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()

                vb.valeurWololo.text = value
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("ACOS", "Failed to read value.", error.toException())
            }
        })
        setContentView(vb.root)
    }
}
