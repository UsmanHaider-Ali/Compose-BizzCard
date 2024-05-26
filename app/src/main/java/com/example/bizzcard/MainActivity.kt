package com.example.bizzcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainCompose()
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MainCompose() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp), shape = RoundedCornerShape(corner = CornerSize(12.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                ImageCompose()
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = "Usman Haider")
                    Text(text = "Mobile App Developer")
                }
            }
            Button(
                onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(text = "Portfolio")
            }
            Divider()
            if (buttonClickedState.value) PortfolioContent(
                listOf(
                    "Project One",
                    "Project Two",
                    "Project Three",
                    "Project Four",
                    "Project Five",
                    "Project One",
                    "Project Two",
                    "Project Three",
                    "Project Four",
                    "Project Five",
                    "Project One",
                    "Project Two",
                    "Project Three",
                    "Project Four",
                    "Project Five"
                )
            )

        }
    }

}

@Composable
fun ImageCompose() {
    Image(painter = painterResource(id = R.drawable.user), contentDescription = "Use Image", modifier = Modifier.size(60.dp))
}

@Composable
fun PortfolioContent(data: List<String>) {
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {
        items(data.size) {
            Card(modifier = Modifier.padding(vertical = 8.dp)) {
                Row(modifier = Modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    ImageCompose()
                    Column(modifier = Modifier.padding(horizontal = 8.dp), verticalArrangement = Arrangement.Center) {
                        Text(text = data[it])
                        Text(text = "A Sample of Recent Project.")
                    }
                }
            }
        }
    }

}