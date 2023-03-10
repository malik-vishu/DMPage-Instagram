package com.example.instadmscreen.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instadmscreen.R
import com.example.instadmscreen.data.DM
import com.example.instadmscreen.data.DataSource

@Preview(showSystemUi = true)
@Composable
fun DMScreen(){
    DmTopBar()
}

//@Preview(showBackground = true)
@Composable
fun DmTopBar(listDM: List<DM> = DataSource().loadDmList()) {
    Column {
        TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(3.dp),
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back arrow",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "captain",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h5.fontSize
                    ),
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
                Icon(imageVector = Icons.Rounded.ArrowDropDown, contentDescription = "Drop down")
                Spacer(modifier = Modifier.width(180.dp))
                Icon(
                    modifier = Modifier
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.outline_videocam_24),
                    contentDescription = "video call",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(2.dp))
                Icon(
                    modifier = Modifier.size(26.dp),
                    painter = painterResource(id = R.drawable.baseline_edit_24),
                    contentDescription = "Edit",
                    tint = Color.Black
                )
            }


        }

        SearchBar()
        Surface(modifier = Modifier.fillMaxWidth()) {
            LazyRow{
                items(listDM){
                    LeaveNoteImage(it)
                }
            }
        }
        MessageRequestRow()
        LazyColumn{
            items(listDM){
                DmRow(eachDm = it)
            }
        }
    }

}


//@Preview(showBackground = true)
@Composable
fun SearchBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        var txt by remember{
            mutableStateOf("")
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .padding(horizontal = 14.dp)
                .alpha(0.4f),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(
                    0xFFebeef2
                )
            ),
            shape = RoundedCornerShape(20),
            value = txt,
            onValueChange = { txt = it },
            placeholder = {
                Text(
                    text = "Search",
                    style = TextStyle(fontSize = 11.sp), color = Color.LightGray
                )
            },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search Icon",modifier = Modifier.size(20.dp))
            })

    }
}

//@Preview(showBackground = true)
@Composable
fun LeaveNoteImage(eachDm: DM) {
    Column(
        modifier = Modifier.padding(horizontal = 7.dp, vertical = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .size(75.dp)
                .padding(5.dp),
            shape = CircleShape,
            border = BorderStroke(width = 1.dp, color = Color.LightGray),
            elevation = 1.dp
        ) {

            Image(
                painter = painterResource(id = eachDm.imageId),
                contentDescription = null,
                modifier = Modifier.size(70.dp),
                contentScale = ContentScale.Crop
            )

        }
        Text(
            text = "${eachDm.name}",
            style = TextStyle(
                fontSize = MaterialTheme.typography.caption.fontSize,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}


@Composable
fun MessageRequestRow() {
    Surface{
        Row(modifier = Modifier.padding(bottom = 3.dp)) {
            Text(
                modifier = Modifier.padding(start = 9.dp),
                text = "Messages",
                style = TextStyle(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.width(250.dp))
            Text(
                modifier = Modifier.padding(end = 3.dp),
                color = Color.Blue,
                text = "Requests",
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun DmRow(eachDm: DM) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp), color = MaterialTheme.colors.background
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage(eachDm = eachDm)
            Column(
                modifier = Modifier.padding(2.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${eachDm.name}",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.body2.fontSize,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = "${eachDm.message}",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.body2.fontSize,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

        }
        Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center) {
            Image(
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 3.dp, end = 8.dp, top = 5.dp),
                painter = painterResource(id = R.drawable.outline_camera_alt_24),
                contentDescription = "Camera"
            )
        }
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier, eachDm: DM = DM("","", R.drawable.ironman),  image: Int? = null) {
    Surface(
        modifier = modifier
            .size(75.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(width = 0.5.dp, color = Color.LightGray),
        elevation = 1.dp
    ) {
        if(image!=null){
            Image(
                modifier = Modifier
                    .size(50.dp),
                painter = painterResource(id = image),
                contentDescription = "DP",
                contentScale = ContentScale.Crop
            )
        }
        else{
            Image(
                modifier = Modifier
                    .size(50.dp),
                painter = painterResource(id = eachDm.imageId),
                contentDescription = "DP",
                contentScale = ContentScale.Crop
            )
        }

    }
}
