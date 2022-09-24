package com.example.businesscard

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardWithBoxes("Shubham Pawar","Senior Developer","+918421414009","shubhampawar1705@gmail.com","shupaw007@gmail.com")
                }
            }
        }
    }
}


@Composable
fun BusinessCardWithBoxes(fullname : String ,title : String , phone : String , email : String , email2 : String){
    Column{
        BusinessCardWithImageAndName(fullname = fullname ,title = title)
        BusinessDescriptionWithPhoneAndEmail(phone = phone , email = email , email2 = email2)
    }
}

@Composable
fun BusinessCardWithImageAndName(fullname: String , title: String){
    val cardImage = painterResource(id = R.drawable.card)
    Column (modifier = Modifier.padding(top = 30.dp)){
        Image(painter = cardImage, contentDescription = null , modifier = Modifier
            .height(100.dp)
            .width(100.dp)

        )
        Text(text = fullname, modifier = Modifier.fillMaxWidth() , fontSize = 26.sp , textAlign = TextAlign.Center)
        Text(text = title, modifier = Modifier.fillMaxWidth() , fontSize = 20.sp , textAlign = TextAlign.Center)
    }
}



@Composable
fun BusinessDescriptionWithPhoneAndEmail(phone: String , email: String , email2: String){
    Column (
        modifier = Modifier.padding(top = 20.dp , start = 30.dp))
    {
        BusinessDescription(phone)
        BusinessDescription(email)
        BusinessDescription(email2)
    }
}

@Composable
fun BusinessDescription(data : String){
    val descImage = painterResource(id = R.drawable.card)
    Row {
      Image(painter = descImage, contentDescription = null , modifier = Modifier
          .height(50.dp)
          .width(50.dp)
      )
      Text(text = data , modifier = Modifier.padding(top = 15.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardWithBoxes("Shubham Pawar","Senior Developer","+918421414009","shubhampawar1705@gmail.com","shupaw007@gmail.com")
    }
}