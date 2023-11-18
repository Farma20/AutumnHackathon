package com.example.autumnhackathon.ui.points

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class PointsScreenViewModel @Inject constructor(

): ViewModel(){

    private val _tripData: MutableState<TripDataClass>
    val tripData: State<TripDataClass>

    init {
        _tripData = mutableStateOf(
            TripDataClass(
                tripNumber = Random.nextInt(1, 55),
                tripPointList = mutableListOf(
                    TripPoint(
                        pointName = "Фадеевский",
                        address = "ул. Фадеева, 45Б",
                        orderNumber = 1268456,
                    ),
                    TripPoint(
                        pointName = "Дуэт",
                        address = "ул. Каплунова, 2",
                        orderNumber = 1268457,
                    ),
                    TripPoint(
                        pointName = "Трио",
                        address = "ул. Каплунова, 3",
                        orderNumber = 1268458,
                    ),
                    TripPoint(
                        pointName = "Реми",
                        address = "ул. Адмирала Юмашева, 14Г",
                        orderNumber = 1268459,
                    ),
                    TripPoint(
                        pointName = "Eco маркет",
                        address = "ул. Луговая, 89А",
                        orderNumber = 1268460,
                    ),
                    TripPoint(
                        pointName = "Реми",
                        address = "ул. Борисенко, 35 кор. 3",
                        orderNumber = 1268461,
                    ),
                    TripPoint(
                        pointName = "Нейбута",
                        address = "ул. Нейбута, 8Г",
                        orderNumber = 1268462,
                    ),
                    TripPoint(
                        pointName = "Виктория",
                        address = "ул. Борисенко 68 стр. 1",
                        orderNumber = 1234567,
                    ),
                    TripPoint(
                        pointName = "Реми",
                        address = "ул. Адмирала Юмашева, 14Г",
                        orderNumber = 1268459,
                    ),
                    TripPoint(
                        pointName = "Eco маркет",
                        address = "ул. Луговая, 89А",
                        orderNumber = 1268460,
                    ),
                    TripPoint(
                        pointName = "Реми",
                        address = "ул. Борисенко, 35 кор. 3",
                        orderNumber = 1268461,
                    ),
                    TripPoint(
                        pointName = "Нейбута",
                        address = "ул. Нейбута, 8Г",
                        orderNumber = 1268462,
                    ),
                )
            )
        )
        _tripData.value.tripPointList.shuffle()
        tripData = _tripData
    }

}

data class TripDataClass(
    val tripNumber: Int,
    val tripPointList: MutableList<TripPoint>
)

data class TripPoint(
    val pointName: String,
    val address: String,
    val orderNumber: Int
)