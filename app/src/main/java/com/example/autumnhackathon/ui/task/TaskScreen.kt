package com.example.autumnhackathon.ui.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.autumnhackathon.R
import com.example.autumnhackathon.ui.task.elements.ProfileCardShort
import com.example.autumnhackathon.ui.task.elements.TaskMainCard
import com.example.autumnhackathon.ui.theme.backgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(){
    Scaffold(
        topBar = { TopBar() },
        containerColor = backgroundColor
    ) {scaffoldTopPaddings ->
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = scaffoldTopPaddings.calculateTopPadding())
                .verticalScroll(rememberScrollState())
        ) {
            ProfileCardShort()
            Spacer(modifier = Modifier.height(16.dp))
            TaskMainCard(1)
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