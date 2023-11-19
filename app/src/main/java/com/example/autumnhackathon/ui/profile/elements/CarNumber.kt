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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autumnhackathon.R
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.primaryTextColor

@Composable
fun CarNumber(
    number:String,
    height: Dp = 70.dp,
    border:Dp = 2.dp,
    borderSize:Dp = 10.dp,
    horizontalPaddings: Dp = 6.dp,
    numberSize: TextUnit = 54.sp,
    letterSize:TextUnit = 38.sp,
    codeWith: Dp = 75.dp,
    codeHeight: Dp = 50.dp
){
    Row(
        modifier = Modifier
            .height(height)
            .border(border, color = Color(0xFFA1A1A1), RoundedCornerShape(borderSize)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(horizontal = horizontalPaddings),
            text = buildAnnotatedString {
                append(number[0])
                withStyle(SpanStyle(fontSize = numberSize)){
                    append("${number[1]}${number[2]}${number[3]}")
                }
                append("${number[4]}${number[5]}")
            },
            fontSize = letterSize,
            fontFamily = FontOpenSansRegular,
            fontWeight = FontWeight(400),
            color = primaryTextColor
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(border)
                .background(Color(0xFFA1A1A1))
        )
        Image(
            modifier = Modifier
                .size(codeWith, codeHeight)
                .padding(horizontal = horizontalPaddings),
            painter = painterResource(id = R.drawable.region_flag),
            contentDescription = "regionFlag"
        )
    }

}