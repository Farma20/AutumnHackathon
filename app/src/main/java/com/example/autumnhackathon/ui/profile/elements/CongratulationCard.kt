package com.example.autumnhackathon.ui.profile.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autumnhackathon.R
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.primaryTextColor

@Composable
fun CongratulationCard(){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(95.dp, 112.dp),
            painter = painterResource(id = R.drawable.logo_light),
            contentDescription = "logo"
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            modifier = Modifier.width(190.dp),
            text = "Иван, хорошего рабочего дня!",
            fontSize = 20.sp,
            fontFamily = FontOpenSansRegular,
            fontWeight = FontWeight(400),
            color = primaryTextColor
        )
    }
}