package fr.wololobzh.random_generator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import fr.wololobzh.random_generator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btnGenerate.setOnClickListener {
            var min = vb.etnMinimum.text.toString().toInt()
            var max = vb.etnMaximum.text.toString().toInt()
            var random = (min..max).random()
            vb.tvValeurResultat.text = random.toString()
        }
    }
}