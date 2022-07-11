package fr.wololobzh.compteur_livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import fr.wololobzh.compteur_livedata.databinding.FragmentCompteurBinding

class CompteurFragment : Fragment() {

    private lateinit var viewModel:CompteurViewModel
    private lateinit var binding: FragmentCompteurBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompteurBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(CompteurViewModel::class.java)

        //Fonction executée quand la donnée observée est mise à jour
        viewModel.compteur.observe(viewLifecycleOwner, Observer { valeur ->
            binding.model = viewModel
        })
        return binding.root
    }
}
