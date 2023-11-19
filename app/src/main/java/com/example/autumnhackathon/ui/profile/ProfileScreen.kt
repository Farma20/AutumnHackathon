package com.example.autumnhackathon.ui.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.autumnhackathon.R
import com.example.autumnhackathon.ui.profile.elements.CarNumber
import com.example.autumnhackathon.ui.profile.elements.CongratulationCard
import com.example.autumnhackathon.ui.profile.elements.ProfileCard
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.backgroundColor
import com.example.autumnhackathon.ui.theme.buttonColor
import com.example.msmgrouptest.ui.sing_in.SingInScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = { TopBar()},
        containerColor = backgroundColor
    ) {scaffoldTopPaddings ->

        val viewModel = hiltViewModel<ProfileScreenViewModel>()

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = scaffoldTopPaddings.calculateTopPadding())
        ) {
            if (!viewModel.isLoadingData.value){
                ProfileCard(viewModel.userData.value!!)
                Spacer(modifier = Modifier.height(12.dp))
                CarNumber(viewModel.userData.value!!.carNum)
                Spacer(modifier = Modifier.weight(1f))
                CongratulationCard(viewModel.userData.value!!.firstName)
                Spacer(modifier = Modifier.weight(1f))
                StartWorkButton(viewModel)
                Spacer(modifier = Modifier.weight(1f))
            }else{
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator(
                        color = buttonColor
                    )
                }
            }
        }
    }
}

@Composable
private fun TopBar(){
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, end = 24.dp)
            .background(backgroundColor)
    ){
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(Color(0xFFF0F0F0))){
            IconButton(
                modifier = Modifier,
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.bell_icon),
                    contentDescription = "notifications",
                    tint = Color(0xFFC3C3C3),

                )
            }
        }
    }
}

@Composable
private fun StartWorkButton(viewModel: ProfileScreenViewModel){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp),
        shape = RoundedCornerShape(13.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        onClick = {
            if (!viewModel.userData.value!!.activeShift){
                viewModel.startShift()
            }else
                viewModel.endShift()
        }
    ) {
        if (!viewModel.isLoadingShiftData.value){
            Text(
                text = if (!viewModel.userData.value!!.activeShift)"Начать смену" else "Завершить смену",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontOpenSansRegular,
                color = backgroundColor
            )
        }
        else{
            CircularProgressIndicator(
                color = backgroundColor
            )
        }
    }
}

