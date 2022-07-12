package fr.wololobzh.roompersonneviewmodelfactory.dao

import androidx.room.*
import fr.wololobzh.roompersonneviewmodelfactory.Personne

@Dao
interface PersonneDao {
    @Insert
    fun insert(personne: Personne)

    @Query("SELECT * FROM Personne WHERE id = :id")
    fun get(id: Long): Personne

    @Query("SELECT * FROM Personne ORDER BY nom,prenom")
    fun get(): List<Personne?>

    @Update
    fun update(personne: Personne)

    @Delete
    fun delete(personne: Personne)
}
