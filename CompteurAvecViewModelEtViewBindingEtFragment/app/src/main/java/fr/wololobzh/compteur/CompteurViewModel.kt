package fr.wololobzh.compteur

import androidx.lifecycle.ViewModel

class CompteurViewModel : ViewModel() {
    //Données devant être affichées dans la vue
    var compteur = 0;
    //Logique métier
    fun plusUn() {
        compteur++
    }
}