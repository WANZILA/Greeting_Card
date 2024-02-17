package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingImage(
//                        stringResource(R.string.happy_birthday_wanzi),
//                        stringResource(R.string.signature_text))
                    JetpackComposeArticle(
                        stringResource(R.string.title_text),
                        stringResource(R.string.content_text1),
                        stringResource(R.string.content_text2),
                        painterResource(R.drawable.bg_compose_background)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
            //            modifier = modifier.padding(24.dp)
        )
        Text(
            text = from,
            fontSize = 20.sp,
            modifier = modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
            )
//        Alignment.CenterHorizontally
    }

}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)

    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }

}


@Composable
fun JetpackComposeArticle(
    title: String,
    contents_txt1: String,
    contents_txt2: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier){
    Column(modifier = modifier){
        Image( painter = imagePainter,contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp)
        )
        Text(
            text = contents_txt1,
            modifier = modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            textAlign = TextAlign.Justify
        )
        Text(
            text = contents_txt2,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )

    }
}


@Composable
fun Taskmanager(
    title: String,
    sub_text: String,
    imagePainter: Painter
){

}


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
//        GreetingImage("Happy Birthday Wanzila", "Ron")
        
        //task 1
        JetpackComposeArticle(
            stringResource(R.string.title_text),
            stringResource(R.string.content_text1),
            stringResource(R.string.content_text2),
            painterResource(R.drawable.bg_compose_background)
        )

    }
}