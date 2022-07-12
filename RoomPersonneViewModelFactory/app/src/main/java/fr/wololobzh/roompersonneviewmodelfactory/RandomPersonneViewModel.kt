package fr.wololobzh.roompersonneviewmodelfactory

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.wololobzh.roompersonneviewmodelfactory.dao.PersonneDao

class RandomPersonneViewModel(val personneDao: PersonneDao) : ViewModel()
{
    val personne = MutableLiveData<Personne>()

    init {
        if(personneDao.get().size==0) {
            personneDao?.insert(Personne(0, "Cosson", "Anthony"))
            personneDao?.insert(Personne(0, "Cosson", "Nicolas"))
            personneDao?.insert(Personne(0, "Cosson", "Michel"))
            personneDao?.insert(Personne(0, "Cosson", "Barbara"))
            personneDao?.insert(Personne(0, "Cosson", "Emma"))
            personneDao?.insert(Personne(0, "Cosson", "Ricola"))
        }
        personne.value = personneDao.get(1)
    }

    fun randomPersonne()
    {

        val count = personneDao.get().size
        val id = (0 until count).random().toLong()
        var hasard = personneDao.get(id)
        Log.i("ACOS","random : " + hasard);
        personne.value = hasard
    }
}
