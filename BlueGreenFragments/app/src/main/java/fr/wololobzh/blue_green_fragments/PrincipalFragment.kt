package fr.wololobzh.blue_green_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import fr.wololobzh.blue_green_fragments.databinding.FragmentPrincipalBinding

class PrincipalFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var vb = FragmentPrincipalBinding.inflate(layoutInflater)

        vb.btnBlue.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_principalFragment_to_blueFragment).onClick(it)
        }
        vb.btnGreen.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_principalFragment_to_greenFragment).onClick(it)
        }
        return vb.root
    }
}
