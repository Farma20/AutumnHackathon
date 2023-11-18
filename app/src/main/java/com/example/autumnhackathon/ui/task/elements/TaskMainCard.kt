package com.example.autumnhackathon.ui.task.elements

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autumnhackathon.R
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.backgroundColor
import com.example.autumnhackathon.ui.theme.buttonColor
import com.example.autumnhackathon.ui.theme.primaryTextColor
import com.example.autumnhackathon.ui.theme.redApplicationColor



@Composable
fun TaskMainCard(
    taskNumber: Int
){
    Column {
        TaskNumber(taskNumber = taskNumber)
        Spacer(modifier = Modifier.height(8.dp))
        TaskCard()
    }
}

@Composable
private fun TaskCard() {
    var isClicked by remember { mutableStateOf(false) }
    var cardHeight by remember { mutableStateOf(0) }
    val interactionSource = remember { MutableInteractionSource() }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(0.1.dp, RoundedCornerShape(10.dp))
            .onGloballyPositioned {
                cardHeight = it.size.height
            }
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(radius = 400.dp),
                onClick = {
                    isClicked = !isClicked
                },
            ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Color(0xFFF3DFA2)),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TaskHeader(isClicked)
            Spacer(modifier = Modifier.height(16.dp))
            TaskStatus()
            Spacer(modifier = Modifier.height(10.dp))
            AnimatedVisibility(visible = isClicked) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Товары в заказе:",
                        fontSize = 16.sp,
                        fontFamily = FontOpenSansRegular,
                        fontWeight = FontWeight(600),
                        color = primaryTextColor
                    )
                    PRODUCT_LIST.forEach{product->
                        Spacer(modifier = Modifier.height(10.dp))
                        ProductItem(
                            productName = product.productName,
                            productSize = product.productSize
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    SuccessButton()
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
private fun SuccessButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFA1A1A1)
        ),
        onClick = {

        }
    ) {
        Text(
            text = "Получил заказ",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontOpenSansRegular,
            color = backgroundColor
        )
    }
}

@Composable
private fun ProductItem(
    productName: String,
    productSize:String
){
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = productName,
                fontSize = 12.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(400),
                color = primaryTextColor
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = productSize,
                fontSize = 13.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(600),
                color = primaryTextColor
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color(0xFFE6E6E6)))
    }
}

@Composable
private fun TaskStatus() {
    val statusIcons = listOf(
            painterResource(id = R.drawable.task_status_clock),
            painterResource(id = R.drawable.task_status_box),
            painterResource(id = R.drawable.task_status_finish)
        )
    
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        statusIcons.forEachIndexed{id, icon->
            TaskStatusElement(icon)
            if (id != 2){
                Box(modifier = Modifier
                    .weight(1f)
                    .height(3.dp)
                    .background(redApplicationColor))
            }
        }
    }
}

@Composable
private fun TaskStatusElement(icon: Painter){
    Box(
        modifier = Modifier
            .size(54.dp)
            .clip(CircleShape)
            .background(redApplicationColor),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = icon,
            contentDescription = "testStatus",
            tint = backgroundColor
        )
    }
}

@Composable
private fun TaskHeader(isClicked: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Заказ принят",
            fontSize = 16.sp,
            fontFamily = FontOpenSansRegular,
            fontWeight = FontWeight(400),
            color = primaryTextColor
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "30 минут",
            fontSize = 16.sp,
            fontFamily = FontOpenSansRegular,
            fontWeight = FontWeight(600),
            color = redApplicationColor
        )
        Spacer(modifier = Modifier.width(6.dp))
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(buttonColor)
                .rotate(if (isClicked) 180f else 0f),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                contentDescription = "arrow",
                tint = backgroundColor
            )
        }
    }
}


@Composable
private fun TaskNumber(
    taskNumber: Int
){
    Text(
        text = "Экспедиция №$taskNumber",
        fontSize = 18.sp,
        fontFamily = FontOpenSansRegular,
        fontWeight = FontWeight(600),
        color = primaryTextColor
    )
}

data class ProductItemDataClass(
    val productName:String,
    val productSize:String,
)

val PRODUCT_LIST = listOf<ProductItemDataClass>(
    ProductItemDataClass("Сушки «Кроха»", "10 Х 18 шт."),
    ProductItemDataClass("Сушки «Малютка»»", "10 Х 18 шт."),
    ProductItemDataClass("Пряники «Шоколадные» крупные", "15 Х 12 шт."),
    ProductItemDataClass("Пряники Заварные «абрикос»", "15 Х 12 шт."),
    ProductItemDataClass("Вафли со вкусом «Лимона»", "10 Х 36 шт."),
    ProductItemDataClass("Сухари «Московские»", "17 Х 18 шт."),
    ProductItemDataClass("Сухари «Сливочные»", "17 Х 18 шт."),
    ProductItemDataClass("Сухари «С маком»", "17 Х 18 шт."),
)