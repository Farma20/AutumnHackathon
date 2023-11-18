package com.example.autumnhackathon.ui.profile.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autumnhackathon.R
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.primaryTextColor

@Composable
fun CarNumber(){
    Row(
        modifier = Modifier
            .height(70.dp)
            .border(2.dp, color = Color(0xFFA1A1A1), RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 6.dp),
            text = buildAnnotatedString {
                append("п")
                withStyle(SpanStyle(fontSize = 54.sp)){
                    append("125")
                }
                append("ми")
            },
            fontSize = 38.sp,
            fontFamily = FontOpenSansRegular,
            fontWeight = FontWeight(400),
            color = primaryTextColor
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(2.dp)
                .background(Color(0xFFA1A1A1))
        )
        Image(
            modifier = Modifier.padding(horizontal = 6.dp),
            painter = painterResource(id = R.drawable.region_flag),
            contentDescription = "regionFlag"
        )
    }

}