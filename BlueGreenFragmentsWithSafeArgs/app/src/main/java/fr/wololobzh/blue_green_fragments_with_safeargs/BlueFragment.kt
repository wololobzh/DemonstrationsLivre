package fr.wololobzh.blue_green_fragments_with_safeargs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
class BlueFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var args = arguments?.let {
            BlueFragmentArgs.fromBundle(it)
        }

        Log.i("ACOS","Info : ${args?.unEntier} ${args?.uneString} ${args?.unePersonne}" )

        return inflater.inflate(R.layout.fragment_blue, container, false)
    }
}
