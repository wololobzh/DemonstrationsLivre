package fr.wololobzh.blue_green_fragments_with_safeargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import fr.wololobzh.blue_green_fragments_with_safeargs.databinding.FragmentPrincipalBinding

class PrincipalFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var vb = FragmentPrincipalBinding.inflate(layoutInflater)

        vb.btnBlue.setOnClickListener {
            val action = PrincipalFragmentDirections.actionPrincipalFragmentToBlueFragment(35,"WOLOLOBZH",Personne(1,"Cosson","Anthony"))
            Navigation.findNavController(it).navigate(action)
        }
        vb.btnGreen.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_principalFragment_to_greenFragment).onClick(it)
        }
        return vb.root
    }
}

