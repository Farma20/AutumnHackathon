package com.example.autumnhackathon.ui.task.elements

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autumnhackathon.R
import com.example.autumnhackathon.ui.task.Expeditions
import com.example.autumnhackathon.ui.task.ProductItemDataClass
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.backgroundColor
import com.example.autumnhackathon.ui.theme.buttonColor
import com.example.autumnhackathon.ui.theme.greyApplicationColor
import com.example.autumnhackathon.ui.theme.primaryTextColor
import com.example.autumnhackathon.ui.theme.redApplicationColor


@Composable
fun TaskMainCard(
    expedition: Expeditions
){
    Column {
        TaskNumber(taskNumber = expedition.number)
        Spacer(modifier = Modifier.height(8.dp))
        TaskCard(
            expedition
        )
    }
}

@Composable
private fun TaskCard(
    expedition: Expeditions
) {
    var isClicked by remember { mutableStateOf(false) }
    var cardHeight by remember { mutableStateOf(0) }
    val interactionSource = remember { MutableInteractionSource() }

    val expeditionIsReady = expedition.status > 2

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
            TaskHeader(isClicked, expedition.status, expedition.time)
            Spacer(modifier = Modifier.height(16.dp))
            TaskStatus(expedition.status, expedition.gateNumber)
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
                    expedition.productList.forEach{product->
                        Spacer(modifier = Modifier.height(10.dp))
                        ProductItem(
                            productName = product.productName,
                            productSize = product.productSize
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    SuccessButton(expeditionIsReady)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
private fun SuccessButton(
    expeditionIsReady: Boolean
) {

    var isClicked by remember { mutableStateOf(false) }
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp),
        enabled = expeditionIsReady,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            disabledContainerColor = Color(0xFFA1A1A1)
        ),
        onClick = {
            isClicked != isClicked
        }
    ) {
        Text(
            text = if (isClicked) "Заказ получен" else "Получил заказ",
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
private fun TaskStatus(taskStatus:Int, gateNumber: Int) {
    val statusIcons = listOf(
            painterResource(id = R.drawable.task_status_clock),
            painterResource(id = R.drawable.task_status_box),
            painterResource(id = R.drawable.task_status_finish)
        )
    
    if (taskStatus < 3){
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            statusIcons.forEachIndexed{id, icon->
                val enabled = id+1 <= taskStatus

                TaskStatusElement(
                    icon,
                    enabled
                )
                if (id != 2){
                    Box(modifier = Modifier
                        .weight(1f)
                        .height(3.dp)
                        .background(if (enabled) redApplicationColor else greyApplicationColor))
                }
            }
        }
    }else{
        FinishedTaskStatus(gateNumber = gateNumber)
    }
}

@Composable
private fun TaskStatusElement(
    icon: Painter,
    enabled:Boolean
){
    Box(
        modifier = Modifier
            .size(54.dp)
            .clip(CircleShape)
            .border(3.dp, if (enabled) redApplicationColor else greyApplicationColor, CircleShape)
            .background(if (enabled) redApplicationColor else backgroundColor),
        contentAlignment = Alignment.Center
    ){
        Icon(
            painter = icon,
            contentDescription = "testStatus",
            tint = if (enabled) backgroundColor else greyApplicationColor
        )
    }
}

@Composable
private fun FinishedTaskStatus(
    gateNumber: Int
){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
                .background(redApplicationColor),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.task_status_finish),
                contentDescription = "testStatus",
                tint = backgroundColor
            )
        }
        Box(modifier = Modifier
            .weight(1f)
            .height(3.dp)
            .background(redApplicationColor))
        Row(
            modifier = Modifier.padding(bottom = 10.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = "гейт",
                fontSize = 23.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(400),
                color = primaryTextColor
            )
            Text(
                modifier = Modifier.padding(end = 28.dp),
                text = "№$gateNumber",
                fontSize = 26.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(400),
                color = redApplicationColor
            )
        }
    }
}

@Composable
private fun TaskHeader(
    isClicked: Boolean,
    status: Int,
    time: Int
) {
    val taskStatus = when(status){
        1 -> "Заказ принят"
        2 -> "Заказ в работе"
        3 -> "Заказ готов"
        else -> "Неизвестный статус"
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = taskStatus,
            fontSize = 16.sp,
            fontFamily = FontOpenSansRegular,
            fontWeight = FontWeight(400),
            color = primaryTextColor
        )
        Spacer(modifier = Modifier.weight(1f))
        if (status < 3){
            Text(
                text = "$time мин.",
                fontSize = 16.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(600),
                color = redApplicationColor
            )
        }
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

