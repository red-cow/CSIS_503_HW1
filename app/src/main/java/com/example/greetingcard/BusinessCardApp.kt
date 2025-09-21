package com.example.greetingcard

import androidx.compose.foundation.layout.Row


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme


class BusinessCardApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeBusinessCard()
                }
            }
        }
    }
}

@Composable
fun ComposeBusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // outer padding
        verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopCard(
            name = "My Name",
            title = "Manufacturing IT Co-op",
            imagePainter = painterResource(R.drawable.jetpack)
        )

        BottomCard(
            phone = "(999)-999-9999",
            social = "@socialmediahandle",
            email = "test@gmail.com"
        )
    }
}

@Composable
private fun TopCard(
    name: String,
    title: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
        Column {
            Image(painter = imagePainter, contentDescription = null)
            Text(
                text = name,
                modifier = Modifier.padding(16.dp),
                fontSize = 36.sp
            )
            Text(
                text = title,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                fontSize = 24.sp
            )
        }
    }


@Composable
private fun BottomCard(
    phone: String,
    email: String,
    social: String
) {

    Column {
        Row {
            Image(painter = painterResource(R.drawable.phone_icon), contentDescription = null,
                modifier = Modifier
                    .size(20.dp))
            Text(
                text = phone,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                fontSize = 16.sp
            )
        }
        Row {
            Image(painter = painterResource(R.drawable.twitterlogo), contentDescription = null,
                modifier = Modifier
                    .size(20.dp))
            Text(
                text = social,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                fontSize = 16.sp
            )
        }
        Row {
            Image(painter = painterResource(R.drawable.email), contentDescription = null,
                modifier = Modifier
                    .size(20.dp))
            Text(
                text = email,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeBusinessAppPreview() {
    GreetingCardTheme {
        ComposeBusinessCard()
    }
}