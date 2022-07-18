package fr.acos.retrofitchucknorris

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import fr.acos.retrofitchucknorris.entities.Joke
import fr.acos.retrofitchucknorris.ws.ChuckApi
import kotlinx.coroutines.launch

class RandomjokeViewModel(application: Application): AndroidViewModel(application)
{
    val joke = MutableLiveData<Joke>()
    val status = MutableLiveData<String>()

    fun randomBlague()
    {
        viewModelScope.launch {
            try {
                var result = ChuckApi.retrofitService.randomFact()
                status.value = "OK"
                joke.value = result
            }
            catch (e: Exception)
            {
                status.value = "KO : ${e.message}"
            }
        }
    }
}
