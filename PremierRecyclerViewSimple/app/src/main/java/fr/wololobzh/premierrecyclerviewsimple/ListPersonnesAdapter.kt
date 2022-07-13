package fr.wololobzh.premierrecyclerviewsimple

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.wololobzh.premierrecyclerviewsimple.databinding.StyleUneLigneBinding

class ListPersonnesAdapter : ListAdapter<Personne, ListPersonnesAdapter.ViewHolder>(PersonneDiffCallback())
{
    //Fonction appelée automatiquement pour changer le contenu d'un conteneur de ligne
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        //On va chercher la données à afficher, c'est le sysème qui s'occupe de vous fournir la position
        val item = getItem(position)
        //holder représente un conteneur et on lui donne la donnée à charger
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder.from(parent)
    }

    //Représente un conteneur de ligne
    class ViewHolder private constructor(val binding: StyleUneLigneBinding) : RecyclerView.ViewHolder(binding.root)
    {
        //Fait le travail de chargement des données dans la ligne
        fun bind(item: Personne)
        {
            //On fournit à la ligne les données, le dataBinding de l'IHM fait le reste
            binding.personne = item
            binding.executePendingBindings()
        }

        //Ici c'est toujours pareil
        companion object
        {
            fun from(parent: ViewGroup): ViewHolder
            {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = StyleUneLigneBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}
//Ici c'est toujours pareil aussi
class PersonneDiffCallback : DiffUtil.ItemCallback<Personne>()
{
    override fun areItemsTheSame(oldItem: Personne, newItem: Personne): Boolean
    {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Personne, newItem: Personne): Boolean
    {
        return oldItem == newItem
    }
}
