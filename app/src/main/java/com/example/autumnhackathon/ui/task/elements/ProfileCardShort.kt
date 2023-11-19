package com.example.autumnhackathon.ui.task.elements

import android.service.autofill.UserData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autumnhackathon.R
import com.example.autumnhackathon.domain.models.UserDataDataModel
import com.example.autumnhackathon.ui.profile.elements.CarNumber
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.buttonColor
import com.example.autumnhackathon.ui.theme.primaryTextColor
import com.example.autumnhackathon.utils.USER_DATA

@Composable
fun ProfileCardShort() {
    Row(
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.profile_pick),
                contentDescription = "profilePhoto",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        UserData(USER_DATA)
    }
}

@Composable
private fun UserData(userData: UserDataDataModel){
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${userData.firstName} ${userData.secondName}",
                fontSize = 16.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(600),
                color = primaryTextColor,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Box(
                modifier = Modifier
                    .padding(top = 3.dp)
                    .size(11.dp)
                    .clip(CircleShape)
                    .background(buttonColor)
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            CarNumber(
                number = userData.carNum,
                height = 20.dp,
                border = 0.5.dp,
                borderSize = 2.5.dp,
                horizontalPaddings = 2.dp,
                numberSize = 15.sp,
                letterSize = 11.sp,
                codeWith = 20.dp,
                codeHeight = 13.dp
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "id${userData.id}",
                fontSize = 14.sp,
                fontFamily = FontOpenSansRegular,
                fontWeight = FontWeight(400),
            )
        }
    }
}