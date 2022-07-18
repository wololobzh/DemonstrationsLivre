package fr.wololobzh.premierrecyclerviewsimple

import androidx.lifecycle.ViewModel

data class Personne(var id:Int,var nom:String, var prenom:String)

/**
 * ViewModel contenant une liste pour alimenter le RecyclerView
 */
class ListePersonnesViewModel() : ViewModel()
{
    //Liste de personnes
    val listePersonnes:List<Personne> = listOf(
        Personne(1,"Cosson","Anthony"),
        Personne(2,"Rousse","Leï"),
        Personne(3,"Adne","Sandy"),
        Personne(4,"Legli","Anne"),
        Personne(5,"Delang","Emilie"),
        Personne(6,"Dupont","Sarah"),
        Personne(7,"Ecural","Alan"),
        Personne(8,"Presse","Sulian"),
        Personne(9,"Boursi","Guillaume"),
        Personne(10,"Jossi","Romain"),
        Personne(11,"Chap","Laura"),
        Personne(12,"Lotto","Aurélie"),
        Personne(13,"Paunet","Gauvin"),
        Personne(14,"Urtil","Alain"),
        Personne(15,"Sage","Nicolas"),
        )
}
