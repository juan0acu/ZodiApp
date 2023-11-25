package com.acunalandaetadevs.zodiapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun getHoroscope(sing:String){
        viewModelScope.launch {
            //Hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO){getPredictionUseCase(sing)} //hilo secundario
            if (result!= null){
            _state.value= HoroscopeDetailState.Success(result.horoscope,result.sing)
        }else{
            _state.value = HoroscopeDetailState.Error("Error")
        }
        //hilo principal

        }
    }

}