package com.example.autumnhackathon.ui.points.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autumnhackathon.R
import com.example.autumnhackathon.ui.points.TripDataClass
import com.example.autumnhackathon.ui.points.TripPoint
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.backgroundColor
import com.example.autumnhackathon.ui.theme.buttonColor
import com.example.autumnhackathon.ui.theme.primaryTextColor
import com.example.autumnhackathon.ui.theme.secondaryTextColor

@Composable
fun TripList(data:TripDataClass){
   Column(
       Modifier.fillMaxWidth()
   ) {
       Text(
           text = "Рейс №${data.tripNumber}",
           fontSize = 20.sp,
           fontFamily = FontOpenSansRegular,
           fontWeight = FontWeight(600),
           color = primaryTextColor
       )
       Spacer(modifier = Modifier.height(16.dp))
       Row(

       ) {
           Column {
                data.tripPointList.forEachIndexed{ id, point ->
                    val isFinished = id+1 == data.tripPointList.size
                    val isStart = id+1 == 1
                    TripPointItem(
                        isFinish = isFinished,
                        isStart = isStart,
                        data = point
                    )
                }
           }
       }
   }
}

@Composable
fun TripPointItem(
    isStart: Boolean,
    isFinish: Boolean,
    data: TripPoint
){
    Row {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!isStart){
                Box(
                    modifier = Modifier
                        .width(4.dp)
                        .height(1.dp)
                        .background(buttonColor)
                )
            }else{
                Spacer(modifier = Modifier.height(1.dp))
            }
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(backgroundColor)
                    .border(4.dp, buttonColor, CircleShape)
            )
            if (!isFinish){
                Box(
                    modifier = Modifier
                        .width(4.dp)
                        .height(75.dp)
                        .background(buttonColor)
                )
            }
        }
        Spacer(modifier = Modifier.width(20.dp))
        AddressItem(data)
    }
}

@Composable
fun AddressItem(
    data: TripPoint
){
    var isClicked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = data.pointName,
                fontSize = 16.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(600),
                color = primaryTextColor
            )
            Text(
                text = data.address,
                fontSize = 16.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(400),
                color = secondaryTextColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = data.orderNumber.toString(),
                fontSize = 12.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(400),
                color = secondaryTextColor
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {
            isClicked = !isClicked
        }) {
            Image(
                painter = if(isClicked)
                    painterResource(id = R.drawable.trip_checkbox_enebled)
                else
                    painterResource(id = R.drawable.trip_checkbox)
                ,
                contentDescription = "tripCheckbox"
            )
        }
    }
}