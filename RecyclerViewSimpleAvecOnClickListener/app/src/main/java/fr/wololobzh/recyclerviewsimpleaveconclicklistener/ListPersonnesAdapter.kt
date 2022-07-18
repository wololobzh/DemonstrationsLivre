package fr.wololobzh.recyclerviewsimpleaveconclicklistener

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.wololobzh.recyclerviewsimpleaveconclicklistener.databinding.StyleUneLigneBinding

class PersonneListener(val clickListener: (personneId: Int) -> Unit)
{
    fun onClick(personne: Personne) = clickListener(personne.id)
}

class ListPersonnesAdapter(val clickListener: PersonneListener)  : ListAdapter<Personne,
        ListPersonnesAdapter.ViewHolder>(PersonneDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val item = getItem(position)
        holder.bind(clickListener,item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder.from(parent)                                                           }

    class ViewHolder private constructor(val binding: StyleUneLigneBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(clickListener: PersonneListener,item: Personne) {
            Log.i("ACOS","BIND")
            binding.personne = item
            binding.clickListener = clickListener
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
