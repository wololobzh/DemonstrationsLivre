package fr.wololobzh.compteur_livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompteurViewModel : ViewModel() {
    //Donnée observée
    val compteur = MutableLiveData<Int>()


    init {
        compteur.value = 0
    }

    fun plusUn() {
        compteur.value = (compteur.value)?.plus(1)
    }
}
