package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImageAndName(name = "Shubham" , from="Pawar")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImageAndName(name : String , from : String){

//    Need to store the image in the variable
    val image = painterResource(id = R.drawable.birthday)
    Box{
        Image(painter = image, contentDescription = null , modifier = Modifier.fillMaxHeight().fillMaxWidth(), contentScale = ContentScale.Crop)
        BirthdayGreetingWithName(name = name , from = from)
    }


}


@Composable
fun BirthdayGreetingWithName(name : String , from : String) {
    Column {
        Text(text = "Happy Birthday $name" ,
            fontSize = 30.sp ,
            modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.Start).padding(start = 16.dp , top = 16.dp)
        )

        Text(text = "from $from",
            fontSize = 24.sp,
            modifier = Modifier.wrapContentWidth(align = Alignment.End)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BirthdayCardTheme {
        BirthdayGreetingWithImageAndName(name = "Shubham" , from="Pawar")
    }
}