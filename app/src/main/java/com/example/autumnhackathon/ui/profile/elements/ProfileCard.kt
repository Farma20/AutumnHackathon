package com.example.autumnhackathon.ui.profile.elements

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
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.buttonColor
import com.example.autumnhackathon.ui.theme.primaryTextColor

@Composable
fun ProfileCard(userData:UserDataDataModel){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
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
        UserData(userData)
    }
}

@Composable
private fun UserData(userData:UserDataDataModel){
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = userData.firstName,
                fontSize = 20.sp,
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
        Text(
            text = userData.secondName,
            fontSize = 20.sp,
            fontFamily = FontOpenSansRegular,
            fontWeight = FontWeight(600),
            color = primaryTextColor,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "id${userData.id}",
            fontSize = 20.sp,
            fontFamily = FontOpenSansRegular,
            fontWeight = FontWeight(400),
        )
    }
}