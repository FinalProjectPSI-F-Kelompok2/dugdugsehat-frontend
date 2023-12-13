package ac.id.ub.filkom.dugdugsehat

//import ac.id.ub.filkom.dugdugsehat.Model.DataUser
//import ac.id.ub.filkom.dugdugsehat.ViemModel.RetrofitInstance
import ac.id.ub.filkom.dugdugsehat.Model.RegisterRequest
import ac.id.ub.filkom.dugdugsehat.Model.RegisterResponse
import ac.id.ub.filkom.dugdugsehat.navigation.Navigation
import ac.id.ub.filkom.dugdugsehat.navigation.Screen
import ac.id.ub.filkom.dugdugsehat.network.RetrofitAPI
import ac.id.ub.filkom.dugdugsehat.ui.theme.DugDugSehatTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
//import coil.compose.rememberAsyncImagePainter
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary500
import ac.id.ub.filkom.dugdugsehat.ui.theme.Type
import ac.id.ub.filkom.dugdugsehat.ui.theme.smallSpace
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Signup: ComponentActivity(){
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DugDugSehatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    SignupScreen(navController)
                    Navigation(navController)
                }
            }
        }
    }
}

@Composable
fun SignupScreen(navController: NavHostController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password1 by remember { mutableStateOf("") }
    var fullname by remember { mutableStateOf("") }
    val ctx = LocalContext.current
    LazyColumn(
        Modifier
            .background(color = Color(0xFFFFFFFF))
            .fillMaxSize()
            .fillMaxWidth()
    ) {
        item{
            Image(
                painter = painterResource(R.drawable.signup_1),
                contentDescription = "Red Vector",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        item{
            Column (
                Modifier
                    .background(color = Color(0xFFFFFFFF))
                    .padding(24.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Row(
                    modifier = Modifier
                        .width(360.dp)
                        .height(60.dp)
                        .padding(top = 10.dp)
                        .background(color = Color(0xFFFFFFFF)),
                    horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .width(160.dp)
                            .height(60.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxSize(),
                            text = "Sign Up",
                            style = Type.heading1Bold()
                        )
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(3.dp)
                                .offset(y = 55.dp)
                                .shadow(elevation = 4.dp, shape = CircleShape)
                                .background(color = Primary500),
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .width(smallSpace)
                )
                Row(modifier = Modifier
                    .width(360.dp)
                    .height(30.dp)
                    .padding(top = 0.dp)
                    .background(color = Color(0xFFFFFFFF)),
                    horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Text(
                        text = "Email",
                        modifier = Modifier
                            .width(150.dp)
                            .height(30.dp)
                            .padding(start = 0.dp, top = 10.dp),
                        textAlign = TextAlign.Start,
                        style = Type.body3Regular()
                    )
                }
                TextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Primary500,
                        unfocusedBorderColor = Primary500
                    ),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .width(350.dp)
                )
                Row(modifier = Modifier
                    .width(360.dp)
                    .height(30.dp)
                    .padding(top = 0.dp)
                    .background(color = Color(0xFFFFFFFF)),
                    horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Text(
                        text = "Full Name",
                        modifier = Modifier
                            .width(150.dp)
                            .height(30.dp)
                            .padding(start = 0.dp, top = 10.dp),
                        textAlign = TextAlign.Start,
                        style = Type.body3Regular()
                    )
                }
                TextField(
                    value = fullname,
                    onValueChange = {
                        fullname = it
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Primary500,
                        unfocusedBorderColor = Primary500
                    ),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .width(350.dp)
                )
                Row(modifier = Modifier
                    .width(360.dp)
                    .height(30.dp)
                    .padding(top = 0.dp)
                    .background(color = Color(0xFFFFFFFF)),
                    horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Text(
                        text = "Password",
                        modifier = Modifier
                            .width(150.dp)
                            .height(30.dp)
                            .padding(start = 0.dp, top = 10.dp),
                        textAlign = TextAlign.Start,
                        style = Type.body3Regular()
                    )
                }
                TextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Primary500,
                        unfocusedBorderColor = Primary500
                    ),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .width(350.dp),
                    visualTransformation = PasswordVisualTransformation()
                )
        }
            Spacer(modifier = Modifier.height(3.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.SignIn.route)
                        },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Primary500,
                            contentColor = colorResource(R.color.white)
                        ),
                        modifier = Modifier
                            .height(50.dp)
                    ) {
                        Text("Sign In",
                            modifier = Modifier
                                .padding(
                                    vertical = 8.dp,
                                    horizontal = 8.dp
                                ),
                            style = Type.body5Regular(),
                            color = Color.White
                        )
                    }
                    OutlinedButton(
                        onClick = {
                            RegisterValidate(ctx,email,fullname,password,navController)
                        },
                        shape = CircleShape,
                        border = BorderStroke(1.dp, Color.Red),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .height(50.dp)
                    ) {
                        Text("Sign Up",
                            Modifier.padding(
                                vertical = 8.dp,
                                horizontal = 8.dp),
                            style = Type.body5Regular(),
                            color = Primary500
                        )
                    }
                }
            }
        }
    }
}

private fun RegisterValidate(
    ctx: Context,
    email: String,
    fullname: String,
    password: String,
    navController: NavHostController
) {

    var url = "https://dugdugsehat.anandadf.my.id/"
    // on below line we are creating a retrofit
    // builder and passing our base url
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        // as we are sending data in json format so
        // we have to add Gson converter factory
        .addConverterFactory(GsonConverterFactory.create())
        // at last we are building our retrofit builder.
        .build()
    // below the line is to create an instance for our retrofit api class.
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
    // passing data from our text fields to our model class.
    val registerRequest = RegisterRequest(email, fullname, password)
    // calling a method to create an update and passing our model class.
    val call: Call<RegisterResponse?>? = retrofitAPI.register(registerRequest)
    // on below line we are executing our method.
    call!!.enqueue(object : Callback<RegisterResponse?> {
        override fun onResponse(call: Call<RegisterResponse?>?, response: Response<RegisterResponse?>) {
            // this method is called when we get response from our api.

            // we are getting a response from our body and
            // passing it to our model class.
            val model: RegisterResponse? = response.body()
            // on below line we are getting our data from model class
            // and adding it to our string.
            val resp =
                "Response Code : " + response.code() + "\n" + model?.status
            Toast.makeText(ctx, resp, Toast.LENGTH_SHORT).show()
            val status: String? = model?.status
            if (status=="ok") {
                navController.navigate(Screen.SignIn.route)
            }
        }

        override fun onFailure(call: Call<RegisterResponse?>?, t: Throwable) {
            // we get error response from API.
        }
    })

}

//@Preview(showBackground = true)
//@Composable
//fun SignupPreview() {
//    DugDugSehatTheme {
//        SignupScreen()
//    }
//}
