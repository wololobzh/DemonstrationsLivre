package fr.wololobzh.roomwithpersonne

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.wololobzh.roomwithpersonne.dao.AppDatabase
import fr.wololobzh.roomwithpersonne.dao.PersonneDao
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    private lateinit var personneDao: PersonneDao
    private lateinit var db: AppDatabase

    @Before
    @Throws(Exception::class)
    fun creerBdd()
    {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
        personneDao = db.personneDao()
    }

    @After
    fun deconnexionBdd()
    {
        db.close()
    }

    @Test
    fun insertions()
    {
        personneDao.insert(Personne(0, "Terieur", "Alex"))
        personneDao.insert(Personne(0, "Centrique", "Alex"))
        val personne = personneDao.get(1)
        assertTrue(personne.nom == "Terieur")
    }

    @Test
    fun update()
    {
        personneDao.insert(Personne(0, "Terieur", "Alex"))
        personneDao.insert(Personne(0, "Centrique", "Alex"))
        var personne = personneDao.get(1)
        personne.nom = "XXX"
        personne.prenom = "YYY"
        personneDao.update(personne)

        personne = personneDao.get(1)
        assertTrue(personne.nom == "XXX")
        assertTrue(personne.prenom == "YYY")
    }
}
