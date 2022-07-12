package fr.wololobzh.roompersonnecoroutine.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.wololobzh.roompersonnecoroutine.Personne

@Dao
interface PersonneDao {
    @Insert
    suspend fun insert(personne: Personne)

    @Query("SELECT * FROM Personne WHERE id = :wololo")
    suspend fun get(wololo:Long):Personne

    @Query("SELECT * FROM Personne Order by nom,prenom")
    fun get(): LiveData<List<Personne>>

    @Update
    suspend fun update(personne : Personne)

    @Delete
    suspend fun delete(personne : Personne)

    @Query("SELECT count(*) FROM Personne")
    suspend fun count():Long
}
