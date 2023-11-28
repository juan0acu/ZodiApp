package com.acunalandaetadevs.zodiapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acunalandaetadevs.zodiapp.domain.model.HoroscopeModel
import com.acunalandaetadevs.zodiapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(
    private val getPredictionUseCase: GetPredictionUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state
    lateinit var horoscope:HoroscopeModel

    fun getHoroscope(sing: HoroscopeModel){
        horoscope = sing
        viewModelScope.launch {
            //Hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO){getPredictionUseCase(sing.name)} //hilo secundario
            if (result!= null){
            _state.value= HoroscopeDetailState.Success(result.horoscope,result.sing,horoscope)
        }else{
            _state.value = HoroscopeDetailState.Error("Error")
        }
        //hilo principal

        }
    }

}