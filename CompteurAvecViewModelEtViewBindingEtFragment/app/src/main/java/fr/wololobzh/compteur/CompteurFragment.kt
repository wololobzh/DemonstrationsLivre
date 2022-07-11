package fr.wololobzh.compteur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import fr.wololobzh.compteur.databinding.FragmentCompteurBinding

/**
 * Contrôleur du compteur
 */
class CompteurFragment : Fragment() {
    //Permet d'accéder à tout les éléments de la vue.
    //private lateinit var binding: FragmentCompteurBinding
    //Permet d'accéder à toutes les actions et informations necessaire à l'ihm.
    private lateinit var viewModel: CompteurViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Instance de la classe de liaison(binding) permettant de mettre à jour n'importe quel élément de la vue.
        var binding = FragmentCompteurBinding.inflate(layoutInflater)

        //Instance de la classe viewModel permettant de fournir toutes les infos pour la vue.
        //Si il y a une nouvelle configuration de l'affichage, le fragment sera détruit mais l'instance du viewModel persistera.
        //Cette ligne est ici la clé de compréhension de l'amelioration apportait par les viewModel.
        viewModel = ViewModelProvider(this).get(CompteurViewModel::class.java)

        //On prend des infos du view model pour les mettre dans la vue via l'instance de binding.
        binding.tvValeur.text = viewModel.compteur.toString()
        //On lit des actions du viewModel pour les mettre dans la vue via l'instance de binding.
        binding.btnCompteur.setOnClickListener{
            viewModel.plusUn()
            binding.tvValeur.text = viewModel.compteur.toString()
        }
        return binding.root
    }
}
