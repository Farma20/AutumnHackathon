package com.example.autumnhackathon.ui.task

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class TaskScreenViewModel @Inject constructor(

): ViewModel()  {
    private val _expeditions = MutableStateFlow(
        listOf(
            Expeditions(
                number = 1,
                time = Random.nextInt(5, 30),
                status = Random.nextInt(1, 4),
                gateNumber = Random.nextInt(1, 6),
                productList = listOf<ProductItemDataClass>(
                    ProductItemDataClass("Сушки «Кроха»", "10 Х 18 шт."),
                    ProductItemDataClass("Сушки «Малютка»»", "10 Х 18 шт."),
                    ProductItemDataClass("Пряники «Шоколадные» крупные", "15 Х 12 шт."),
                    ProductItemDataClass("Пряники Заварные «абрикос»", "15 Х 12 шт."),
                    ProductItemDataClass("Вафли со вкусом «Лимона»", "10 Х 36 шт."),
                    ProductItemDataClass("Сухари «Московские»", "17 Х 18 шт."),
                    ProductItemDataClass("Сухари «Сливочные»", "17 Х 18 шт."),
                    ProductItemDataClass("Сухари «С маком»", "17 Х 18 шт."),
                )
            ),
            Expeditions(
                number = 2,
                time = Random.nextInt(5, 30),
                status = Random.nextInt(1, 4),
                gateNumber = Random.nextInt(1, 6),
                productList = listOf<ProductItemDataClass>(
                    ProductItemDataClass("Вафли со вкусом «Лимона»", "10 Х 36 шт."),
                    ProductItemDataClass("Сухари «Московские»", "17 Х 18 шт."),
                    ProductItemDataClass("Сухари «Сливочные»", "17 Х 18 шт."),
                    ProductItemDataClass("Сухари «С маком»", "17 Х 18 шт."),
                    ProductItemDataClass("Сушки «Кроха»", "10 Х 18 шт."),
                    ProductItemDataClass("Сушки «Малютка»»", "10 Х 18 шт."),
                )
            ),
            Expeditions(
                number = 3,
                time = Random.nextInt(5, 30),
                status = 3,
                gateNumber = Random.nextInt(1, 6),
                productList = listOf<ProductItemDataClass>(
                    ProductItemDataClass("Вафли со вкусом «Лимона»", "10 Х 36 шт."),
                    ProductItemDataClass("Сухари «Московские»", "17 Х 18 шт."),
                    ProductItemDataClass("Сухари «Сливочные»", "17 Х 18 шт."),
                    ProductItemDataClass("Сушки «Кроха»", "10 Х 18 шт."),
                    ProductItemDataClass("Сушки «Малютка»»", "10 Х 18 шт."),
                )
            ),
            Expeditions(
                number = 4,
                time = Random.nextInt(5, 30),
                status = Random.nextInt(1, 4),
                gateNumber = Random.nextInt(1, 6),
                productList = listOf<ProductItemDataClass>(
                    ProductItemDataClass("Вафли со вкусом «Лимона»", "10 Х 36 шт."),
                    ProductItemDataClass("Сухари «Московские»", "17 Х 18 шт."),
                    ProductItemDataClass("Сухари «Сливочные»", "17 Х 18 шт."),
                    ProductItemDataClass("Сушки «Кроха»", "10 Х 18 шт."),
                    ProductItemDataClass("Сушки «Малютка»»", "10 Х 18 шт."),
                    ProductItemDataClass("Пряники Заварные «абрикос»", "15 Х 12 шт."),
                    ProductItemDataClass("Вафли со вкусом «Лимона»", "10 Х 36 шт."),
                    ProductItemDataClass("Сухари «Московские»", "17 Х 18 шт."),
                    ProductItemDataClass("Сухари «Сливочные»", "17 Х 18 шт."),
                    ProductItemDataClass("Сухари «С маком»", "17 Х 18 шт."),
                )
            ),
        )
    )
    val expeditions: StateFlow<List<Expeditions>> = _expeditions

}

data class Expeditions(
    val number: Int,
    val time: Int,
    val status: Int,
    val gateNumber: Int,
    val productList: List<ProductItemDataClass>
)

data class ProductItemDataClass(
    val productName:String,
    val productSize:String,
)