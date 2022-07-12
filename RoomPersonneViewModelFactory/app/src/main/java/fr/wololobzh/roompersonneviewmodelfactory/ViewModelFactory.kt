package fr.wololobzh.roompersonneviewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.wololobzh.roompersonneviewmodelfactory.dao.AppDatabase

class ViewModelFactory(val ctx: Context): ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        if(modelClass.isAssignableFrom(RandomPersonneViewModel::class.java))
        {
            val dao = AppDatabase.getInstance(ctx).personneDao()
            var vm = RandomPersonneViewModel(dao)
            return vm as T
        }
        throw IllegalArgumentException("Ce ViewModel n'existe pas")
    }

}
