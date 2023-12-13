package ac.id.ub.filkom.dugdugsehat

import ac.id.ub.filkom.dugdugsehat.R
import ac.id.ub.filkom.dugdugsehat.ui.theme.DugDugSehatTheme
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import ac.id.ub.filkom.dugdugsehat.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class Profile : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DugDugSehatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val response = remember {
        mutableStateOf("")
    }

    LaunchedEffect(mainViewModel.user.value) {
        mainViewModel.getUser("tata123@gmail.com")
    }

    val user by mainViewModel.user
    val isLoading by mainViewModel.isLoading

    if (isLoading)
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
        }
    else {
        var isVisible by rememberSaveable { mutableStateOf(false) }
        var name by remember {
            mutableStateOf(user?.user?.name.toString())
        }

        val email = remember {
            mutableStateOf(TextFieldValue(user?.user?.email.toString()))
        }
        val password = remember {
            mutableStateOf(TextFieldValue(user?.user?.password.toString()))
        }
        val age = remember {
            mutableStateOf(user?.healthProfile?.age)
        }
        val bodyHeight = remember {
            mutableStateOf(user?.healthProfile?.bodyHeight)
        }
        val bodyWeight = remember {
            mutableStateOf(user?.healthProfile?.bodyWeight)
        }
        val selectedGender = remember { mutableStateOf(false/*mainViewModel.healt.genderIsMale*/) }
        /*val isSelectedItem: (String) -> Boolean = { selectedGender.value.equals(true)  }
        val onChangeState: (String) -> Unit = { selectedGender.value.equals(false) }*/

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFDFDFD))
                .verticalScroll(rememberScrollState())
        )

        {

            Row(
                modifier = Modifier
                    .width(360.dp)
                    .height(60.dp)
                    .padding(top = 20.dp)
                    .background(color = Color(0xFFFFFFFF)),
                horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.End),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    modifier = Modifier
                        .width(120.dp)
                        .height(32.dp),
                    text = "My Profile",
                    style = TextStyle(
                        fontSize = 25.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )

                Column(modifier = Modifier
                    .padding(end = 15.dp)
                    .width(32.dp)
                    .height(32.dp)
                    .background(
                        color = Color(0xFFFF5D73),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .clickable { isVisible = !isVisible }
                )

                {
                    Image(
                        modifier = Modifier
                            .padding(top = 8.dp, start = 10.dp)
                            .width(14.dp)
                            .height(14.49874.dp),
                        painter = painterResource(id = R.drawable.group_group),
                        contentDescription = "image description",
                        contentScale = ContentScale.None
                    )
                }
            }

            ProfileImage()

            Text(
                text = "Full Name",
                modifier = Modifier
                    .width(150.dp)
                    .height(30.dp)
                    .padding(start = 40.dp, top = 10.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000)
                )
            )
            Spacer(modifier = Modifier.size(5.dp))
            Row(
                modifier = Modifier
                    .defaultMinSize(minWidth = 1.dp)
                    .height(50.dp)
            ) {
                OutlinedTextField(
                    value = name, onValueChange = { name = it },
                    singleLine = true,
                    modifier = Modifier
                        .width(350.dp)
                        .padding(start = 40.dp)
                        .background(color = Color(0x33FF5D73)),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
            }

            Text(
                text = "Email",
                modifier = Modifier
                    .width(150.dp)
                    .height(30.dp)
                    .padding(start = 40.dp, top = 10.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),

                    )
            )
            Spacer(modifier = Modifier.size(5.dp))
            Row(
                modifier = Modifier
                    .defaultMinSize(minWidth = 1.dp)
                    .height(50.dp)
            ) {
                OutlinedTextField(
                    email.value, onValueChange = { email.value = it },
                    singleLine = true,
                    modifier = Modifier
                        .width(350.dp)
                        .padding(start = 40.dp)
                        .background(color = Color(0x33FF5D73)),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
            }

            Text(
                text = "Age",
                modifier = Modifier
                    .width(150.dp)
                    .height(30.dp)
                    .padding(start = 40.dp, top = 10.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),

                    )
            )
            Spacer(modifier = Modifier.size(5.dp))
            Row(
                modifier = Modifier
                    .defaultMinSize(minWidth = 1.dp)
                    .height(50.dp)
            ) {
                OutlinedTextField(
                    age.value.toString(), onValueChange = { newValue ->
                        if (newValue.isNotBlank() && newValue.toIntOrNull() != null) {
                            age.value = newValue.toInt()
                        } else {

                        }
                    },
                    singleLine = true,
                    modifier = Modifier
                        .width(350.dp)
                        .padding(start = 40.dp)
                        .background(color = Color(0x33FF5D73)),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
            }

            Text(
                text = "Gender",
                modifier = Modifier
                    .width(150.dp)
                    .height(30.dp)
                    .padding(start = 40.dp, top = 5.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),

                    )
            )

            Column(
                modifier = Modifier
                    .padding(start = 30.dp, top = 5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(
                        selected = selectedGender.value,
                        onClick = { selectedGender.value = true },
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)
                    )
                    Text(
                        "Male",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),

                            )
                    )
                    RadioButton(
                        selected = !selectedGender.value,
                        onClick = { selectedGender.value = false },
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)
                    )
                    Text(
                        "Female",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),

                            )
                    )
                }

            }
            Text(
                text = "Weight (Kg)",
                modifier = Modifier
                    .width(150.dp)
                    .height(30.dp)
                    .padding(start = 40.dp, top = 10.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),

                    )
            )
            Spacer(modifier = Modifier.size(5.dp))
            Row(
                modifier = Modifier
                    .defaultMinSize(minWidth = 1.dp)
                    .height(50.dp)
            ) {
                OutlinedTextField(
                    bodyWeight.value.toString(), onValueChange = { newValue ->
                        if (newValue.isNotBlank() && newValue.toIntOrNull() != null) {
                            bodyWeight.value = newValue.toInt()
                        } else {

                        }
                    },
                    singleLine = true,
                    modifier = Modifier
                        .width(350.dp)
                        .padding(start = 40.dp)
                        .background(color = Color(0x33FF5D73)),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
            }

            Text(
                text = "Height (Cm)",
                modifier = Modifier
                    .width(150.dp)
                    .height(30.dp)
                    .padding(start = 40.dp, top = 10.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),

                    )
            )
            Spacer(modifier = Modifier.size(5.dp))
            Row(
                modifier = Modifier
                    .defaultMinSize(minWidth = 1.dp)
                    .height(50.dp)
            ) {
                OutlinedTextField(
                    bodyHeight.value.toString(), onValueChange = { newValue ->
                        if (newValue.isNotBlank() && newValue.toIntOrNull() != null) {
                            bodyHeight.value = newValue.toInt()
                        } else {

                        }
                    },
                    singleLine = true,
                    modifier = Modifier
                        .width(350.dp)
                        .padding(start = 40.dp)
                        .background(color = Color(0x33FF5D73)),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 775.dp)
                .shadow(
                    elevation = 30.dp,
                    spotColor = Color(0x40435D6B),
                    ambientColor = Color(0x40435D6B)
                )
                .shadow(
                    elevation = 30.dp,
                    spotColor = Color(0x40435D6B),
                    ambientColor = Color(0x40435D6B)
                )
                .fillMaxWidth()
                .height(75.dp)
                .background(color = Color.Transparent, shape = RoundedCornerShape(size = 10.dp)),
            horizontalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Image(
                    modifier = Modifier
                        .width(40.dp)
                        .height(23.dp)
                        .clickable { /*NavController.navigate("Pesan") */ },
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
            Column {
                Image(
                    modifier = Modifier
                        .width(40.dp)
                        .height(23.dp)
                        .clickable {/* NavController.navigate("History")*/ },
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
            Column {
                Image(
                    modifier = Modifier
                        .width(40.dp)
                        .height(23.dp)
                        .clickable { /*NavController.navigate("History")*/ },
                    painter = painterResource(id = R.drawable.bolt),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
            Column {
                Image(
                    modifier = Modifier
                        .width(40.dp)
                        .height(27.dp)
                        .clickable { /*NavController.navigate("History")*/ },
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
            Column {
                Image(
                    modifier = Modifier
                        .width(40.dp)
                        .height(23.dp)
                        .clickable {/* NavController.navigate("History") */ },
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }

        if (isVisible) {
            val notification = rememberSaveable { mutableStateOf("") }
            if (notification.value.isNotEmpty()) {
                Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
                notification.value = ""
            }

            ExtendedFloatingActionButton(
                modifier = Modifier.padding(
                    top = 750.dp,
                    start = 100.dp,
                    bottom = 50.dp,
                    end = 100.dp
                ),
                icon = { Icon(Icons.Filled.Favorite, "") },
                text = { Text("Save") },
                onClick = {
                    mainViewModel.updateProfile(
                        name,
                        email.value.text,
                        password.value.text,
                        age.value!!,
                        selectedGender.value,
                        bodyHeight.value!!,
                        bodyWeight.value!!
                    )
                    mainViewModel.getUser("tata123@gmail.com")
                },
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = response.value,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

//private fun postDataUsingRetrofit(
//    ctx: Context,
//    nama: MutableState<TextFieldValue>,
//    email: MutableState<TextFieldValue>,
//    password: MutableState<TextFieldValue>,
//    Gender: MutableState<Boolean>,
//    Age: MutableState<Int>,
//    BodyWeight: MutableState<Int>,
//    BodyHeight: MutableState<Int>,
//    result: MutableState<String>
//) {
//    var url = "https://dugdugsehat.anandadf.my.id/"
//    // on below line we are creating a retrofit
//    // builder and passing our base url
//    val retrofit = Retrofit.Builder()
//        .baseUrl(url)
//        // as we are sending data in json format so
//        // we have to add Gson converter factory
//        .addConverterFactory(GsonConverterFactory.create())
//        // at last we are building our retrofit builder.
//        .build()
//    // below the line is to create an instance for our retrofit api class.
//    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
//    // passing data from our text fields to our model class.
//    val dataModel = DataModel(
//        User(nama.value.text, email.value.text, password.value.text),
//        HealthProfile(Gender.value, Age.value, BodyWeight.value, BodyHeight.value)
//    )
//    // calling a method to create an update and passing our model class.
//    val call: Call<DataModel?>? = retrofitAPI.postData(dataModel)
//    // on below line we are executing our method.
//    call!!.enqueue(object : Callback<DataModel?> {
//        override fun onResponse(call: Call<DataModel?>?, response: Response<DataModel?>) {
//            // this method is called when we get response from our api.
//            Toast.makeText(ctx, "Data posted to API", Toast.LENGTH_SHORT).show()
//            // we are getting a response from our body and
//            // passing it to our model class.
//            val model: DataModel? = response.body()
//            // on below line we are getting our data from model class
//            // and adding it to our string.
//            val resp =
//                "Response Code : " + response.code()
//            // below line we are setting our string to our response.
//            result.value = resp
//        }
//
//        override fun onFailure(call: Call<DataModel?>?, t: Throwable) {
//            // we get error response from API.
//            result.value = "Error found is : " + t.message
//        }
//    })
//
//}

//private fun getDataUsingRetrofit(
//    ctx: Context,
//    result: MutableState<String>,
//    mainViewModel: MainViewModel
//) {
//    try {
//        var url = "https://dugdugsehat.anandadf.my.id/"
//        // on below line we are creating a retrofit
//        // builder and passing our base url
//        val retrofit = Retrofit.Builder()
//            .baseUrl(url)
//            // as we are sending data in json format so
//            // we have to add Gson converter factory
//            .addConverterFactory(GsonConverterFactory.create())
//            // at last we are building our retrofit builder.
//            .build()
//        // below the line is to create an instance for our retrofit api class.
//        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
//        // passing data from our text fields to our model class.
//        val profile = ProfileRequest("tata12345@gmail.com")
//        // calling a method to create an update and passing our model class.
//        val call: Call<ProfileResponse?>? = retrofitAPI.getdata(profile)
//        // on below line we are executing our method.
//        call!!.enqueue(object : Callback<ProfileResponse?> {
//            override fun onResponse(
//                call: Call<ProfileResponse?>?,
//                response: Response<ProfileResponse?>
//            ) {
//                // this method is called when we get response from our api.
//                // we are getting a response from our body and
//                // passing it to our model class.
//                val model: ProfileResponse? = response.body()
//                // on below line we are getting our data from model class
//                // and adding it to our string.
//                val resp =
//                    "Response Code : " + response.code()
//                // below line we are setting our string to our response.
//                /*Toast.makeText(ctx, resp, Toast.LENGTH_SHORT).show()*/
//                Toast.makeText(ctx, resp, Toast.LENGTH_SHORT).show()
//
//                if (model != null) {
//                    mainViewModel.profile = model.data
//                }
//
//
//            }
//
//            override fun onFailure(call: Call<ProfileResponse?>?, t: Throwable) {
//                // we get error response from API.
//                result.value = "Error found is : " + t.message
//            }
//        })
//    } catch (e: Exception) {
//        Toast.makeText(ctx, e.message.toString(), Toast.LENGTH_SHORT).show()
//    }
//
//
//}

@Composable
fun ProfileImage() {
    val imageUrl = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        if (imageUrl.value.isEmpty())
            R.drawable.ic_user
        else
            imageUrl.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    )
    { uri: Uri? ->
        uri?.let { imageUrl.value = it.toString() }
    }


    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(130.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .fillMaxSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    DugDugSehatTheme {
        ProfileScreen()
    }
}
