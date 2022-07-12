package fr.wololobzh.roompersonn

import android.util.Log
import fr.wololobzh.roompersonnecoroutine.Personne

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.wololobzh.roompersonnecoroutine.dao.PersonneDao
import kotlinx.coroutines.launch

class RandomPersonneViewModel(
    val personneDao: PersonneDao
) : ViewModel() {
    val personne = MutableLiveData<Personne>();

    init {
        Log.i("ACOS", "info ==>  " + personneDao.get().value?.size)
        if ((personneDao.get().value?.size ?: 0 == 0) || personneDao.get().value?.size == null) {
            Log.i("ACOS", "info GOGOGO");
            viewModelScope.launch {
                personneDao?.insert(Personne(0, "Cosson", "Anthony"))
                personneDao?.insert(Personne(0, "Cosson", "Nicolas"))
                personneDao?.insert(Personne(0, "Cosson", "Michel"))
                personneDao?.insert(Personne(0, "Cosson", "Barbara"))
                personneDao?.insert(Personne(0, "Cosson", "Emma"))
                personneDao?.insert(Personne(0, "Cosson", "Ricola"))
                randomFromDatabase();
            }
        } else {
            viewModelScope.launch {
                randomFromDatabase();
            }
        }
    }


    fun randomPersonne() {
        viewModelScope.launch {
            randomFromDatabase()
        }
    }

    private suspend fun randomFromDatabase() {
        val count = personneDao.count()
        val numero = (0..count - 1).random()
        personne.value = personneDao.get(numero.toLong())
    }
}
