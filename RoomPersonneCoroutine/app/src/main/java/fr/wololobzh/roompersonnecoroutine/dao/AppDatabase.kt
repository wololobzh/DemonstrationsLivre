package fr.wololobzh.roompersonnecoroutine.dao

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import fr.wololobzh.roompersonnecoroutine.Personne

@Database(entities = arrayOf(Personne::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personneDao(): PersonneDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "la_base_de_donnees"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)

                                Log.i("ACOS","Création")
                            }
                        })
                        .build()
                }
                return INSTANCE as AppDatabase
            }}}}