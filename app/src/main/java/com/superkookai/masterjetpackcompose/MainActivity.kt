package com.superkookai.masterjetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.superkookai.masterjetpackcompose.ui.theme.MasterJetpackComposeTheme

class MainActivity : ComponentActivity(), NetworkStateListener by NetworkStateHandler() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        observeNetworkState(this,this)
        setContent {
            MasterJetpackComposeTheme {
                Scaffold(
//                    topBar = {
//                        MyTopAppBar()
//                    },
                    bottomBar = {
                        MyBottomAppBar()
                    },
                    floatingActionButton = {
                        MyFAB()
                    }
                ) {
                    MyCard()
                }


//                MySurface()
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 100.dp)
//                ) {
//                    MyBox()
//                    MyColumn()
//                    MyRow()
//                    ChallengeComposable2()
//                        CircularProgressIndicatorExample()
//                        LinearProgressIndicatorExample()
//                        CheckboxExample()
//                        SwitchExample()
//                        RadioButtonExample()
//                        RadioButtonWithText()
//                        var text by remember { mutableStateOf("") }
//
//                        StatelessTextField(text = text) {
//                            text = it
//                        }
//                        StatefulTextField()
//                        Counter()
//                        FilledButton(onClick = {Log.v("TAGY", "FilledButton click!")})
//                        FilledTonal(onClick = {Log.v("TAGY", "FilledTonal click!")})
//                        Elevated { Log.v("TAGY", "Elevated Button click!") }
//                        Outlined { Log.v("TAGY", "Outlined Button click!") }
//                        TextButtonExample { Log.v("TAGY", "Text Button click!") }
//                        MyTextField()
//                }
            }
        }
    }
}

//Scaffold
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    val context = LocalContext.current
    TopAppBar(
        title = {Text("TopAppBar Tiltle")},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton({
                Toast.makeText(context,
                    "You click Nav Icon!", Toast.LENGTH_SHORT).show()
            }) {
                Icon(painter = painterResource(R.drawable.outline_menu_24),
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton({
                Toast.makeText(context,
                    "You click Action Icon!", Toast.LENGTH_SHORT).show()
            }){
                Icon(painter = painterResource(R.drawable.baseline_play_circle_filled_24),
                    contentDescription = "Play"
                )
            }
        }
    )
}

@Composable
fun MyBottomAppBar() {
    val context = LocalContext.current
    BottomAppBar(
        containerColor = Color.LightGray,
        contentColor = Color.Blue
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton({
                Toast.makeText(context,
                    "You click 1st Icon!", Toast.LENGTH_SHORT).show()
            }
            ) {
                Icon(painter = painterResource(R.drawable.outline_home_24),
                    contentDescription = "Home",
                    modifier = Modifier.size(50.dp)
                )
            }

            IconButton({
                Toast.makeText(context,
                    "You click 2nd Icon!", Toast.LENGTH_SHORT).show()
            }) {
                Icon(painter = painterResource(R.drawable.outline_bookmark_24),
                    contentDescription = "Bookmark",
                    modifier = Modifier.size(50.dp)
                )
            }

            IconButton({
                Toast.makeText(context,
                    "You click 3rd Icon!", Toast.LENGTH_SHORT).show()
            }) {
                Icon(painter = painterResource(R.drawable.outline_person_24),
                    contentDescription = "People",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}

@Composable
fun MyFAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context,
            "You click FAB!", Toast.LENGTH_SHORT).show()
    },
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        Icon(painter = painterResource(R.drawable.outline_add_24),
            contentDescription = "Add")
    }
}

//Scroll Column
@Composable
fun ScrollingColumn() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Image(painter = painterResource(R.drawable.pic1,)
            , contentDescription = "pic1",
            contentScale = ContentScale.FillBounds)

        Image(painter = painterResource(R.drawable.pic2,)
            , contentDescription = "pic2",
            contentScale = ContentScale.FillBounds)

        Image(painter = painterResource(R.drawable.pic3,)
            , contentDescription = "pic3",
            contentScale = ContentScale.FillBounds)
    }
}

//Scroll Row
@Composable
fun ScrollingRow() {
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        Image(painter = painterResource(R.drawable.pic1,)
            , contentDescription = "pic1",
            contentScale = ContentScale.FillBounds)

        Image(painter = painterResource(R.drawable.pic2,)
            , contentDescription = "pic2",
            contentScale = ContentScale.FillBounds)

        Image(painter = painterResource(R.drawable.pic3,)
            , contentDescription = "pic3",
            contentScale = ContentScale.FillBounds)
    }
}

//Lazy Scrolling
@Composable
fun MyLazyColumn() {
    val itemList = listOf<String>(
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6",
        "Item 7","Item 8", "Item 9", "Item 10","Item 11", "Item 12", "Item 13",
        "Item 14", "Item 15", "Item 16", "Item 17","Item 18", "Item 19", "Item 20"
    )
    LazyColumn(
        contentPadding = PaddingValues(vertical = 120.dp)
    ) {
        stickyHeader {
            Text("Sticky Header", fontSize = 42.sp, color = Color.White,
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(10.dp)
                    .fillMaxWidth())
        }
        item { Text("Title for items", fontSize = 42.sp)}
        items(itemList) {
            MyCustomItem(it)
        }
    }
}

@Composable
fun MyCustomItem(title: String) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { //if implement detectTapGesture cannot use this
                Toast.makeText(
                    context,
                    "You click $title",
                    Toast.LENGTH_SHORT).show()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title,
            fontSize = 42.sp,
            modifier = Modifier
                .background(Color.Green)
                .padding(10.dp)
                .fillMaxWidth()
                .pointerInput(Unit) {
                    detectTapGestures (
                        onLongPress = {
                            Toast.makeText(
                                context,
                                "You long press $title",
                                Toast.LENGTH_SHORT).show()
                        },

                        onTap = {
                            Toast.makeText(
                                context,
                                "You tap $title",
                                Toast.LENGTH_SHORT).show()
                        }

                    )
                }
        )
    }
}

//Lazy Row
@Composable
fun MyLazyRow() {
    val itemList = listOf<String>(
        "Master Coding App", "Master Flutter App", "Navigation App"
        , "Master Android App", "Master iOS App")

    LazyRow(
        contentPadding = PaddingValues(top = 120.dp)
    ) {
        items(items = itemList) {
            MyCustomItem(it)
        }
    }
}

//Card Composable
@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(30.dp),
    ) {
        Text("This is a simple card", modifier = Modifier.padding(16.dp))
    }
}

//Layout Deep Dive
//1. Row
@Composable
fun MyRow(){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Welcome back!")
        Text("Download Master Coding App!")
        Text("From PlayStore")
    }
}
//2. Column
@Composable
fun MyColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Welcome back!")
        Text("Download Master Coding App!")
        Text("From PlayStore")
    }
}

//3. Box
@Composable
fun MyBox() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Welcome back!", modifier = Modifier.align(Alignment.TopStart))
        Text("Download Master Coding App!", modifier = Modifier.align(Alignment.Center))
        Text("From PlayStore", modifier = Modifier.align(Alignment.BottomEnd))
    }
}

//4. Surface - hold one child at a time
//provide many styles treatment for its children
@Composable
fun MySurface() {
    Surface(
        modifier = Modifier
            .size(100.dp)
        ,
        color = Color.Red,
        contentColor = colorResource(id = R.color.white),
        shadowElevation = 1.dp,
        border = BorderStroke(1.dp, Color.Green)
    ) {
        MyColumn()
    }
}



//State management
//Compose provide State(read-only) and MutableState(read-write)
@Composable
fun Counter() {
    var count = remember { mutableStateOf(0) }
    Column() {
        Text(text = "Count: ${count.value}")
        Button(onClick = {
            count.value++
            Log.v("TAGY", "Count: ${count.value}")
        }) {
            Text(text = "Increment")
        }
    }
}

//Stateful Composable: Manage its own state
@Composable
fun StatefulTextField() {
    var text by remember { mutableStateOf("") }
    Column() {
        TextField(value = text, onValueChange = {text = it}
        , label = {Text("Enter your text")})

        Text("Your text: $text")
    }
}

//Stateless Composable
@Composable
fun StatelessTextField(
    text: String,
    onTextChange: (String) -> Unit
) {
    Column() {
        TextField(value = text, onValueChange = onTextChange,
            label = {Text("Enter your text")})

        Text("Your text: $text")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
            .border(1.dp, Color.Gray)
    ) {
        Text(
            text = "สวัสดี $name!",
            modifier = modifier
//                .padding(16.dp)
                .background(Color.Blue),
            color = Color.White,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            ),
            textAlign = TextAlign.Center
        )

        Text("Download from Internet!")

        Row(horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()) {
            Text("One")
            Text("Two")
        }

        Box(modifier = Modifier
            .background(Color.Cyan),
            contentAlignment = Alignment.Center) {
            Text("Bottom", modifier = Modifier.padding(6.dp))
            Text("Top")
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun GreetingPreview() {
    MasterJetpackComposeTheme {
        Greeting("Android")
    }
}

@Composable
fun ChallengeView(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .border(1.dp, Color.Red)
            .padding(10.dp)
            .border(0.5.dp, Color.Blue)
            .padding(1.dp)
    ) {
        Text(
            "Hello Master Coding App",
            color = Color.Red,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            ),
            modifier = Modifier.padding(start = 10.dp)
        )

        Text(
            "Download it from Playstore",
            fontSize = 5.sp,
            textDecoration = TextDecoration.Underline,
            lineHeight = 5.sp
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun ChallengePreview() {
    MasterJetpackComposeTheme {
        ChallengeView()
    }
}

@Composable
fun DisplayImage() {
    //load image from drawable resource
    val myPainter = painterResource(R.drawable.target)
    //display the image with a content description
    Image(painter = myPainter,
        contentDescription = "Target logo",
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .padding(5.dp)
            .border(1.dp, Color.Blue)
    )
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun ImagePreview() {
    MasterJetpackComposeTheme {
        DisplayImage()
    }
}

//Button Composable
//1. Filled Button
@Composable
fun FilledButton(onClick: ()-> Unit) {
    Button(onClick = {
        onClick()
    }) {
        Text("Click Me!!")
    }
}

//2. Filled Tonal Button
@Composable
fun FilledTonal(onClick: () -> Unit) {
    FilledTonalButton(onClick = {onClick()}) {
        Text("Filled Tonal Button")
    }
}

//3. Elevated Button
@Composable
fun Elevated(onClick: () -> Unit) {
    ElevatedButton(onClick = {onClick()},
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp)
    ) {
        Text("Elevated Button")
    }
}

//4. Outlined Button
@Composable
fun Outlined(onClick: () -> Unit) {
    OutlinedButton(onClick = {onClick()}) {
        Text("Outlined Button")
    }
}

//Text Button
@Composable
fun TextButtonExample(onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text("Text Button")
    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun ButtonPreview() {
    MasterJetpackComposeTheme {
        Column() {
            FilledButton(onClick = {})
            FilledTonal(onClick = {})
            Elevated (onClick = {})
            Outlined {  }
            TextButtonExample {  }
        }
    }
}

//TextField
@Composable
fun MyTextField() {
    var text by remember { mutableStateOf(TextFieldValue()) }

    TextField(value = text, onValueChange = { text = it })
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun TextFieldPreview() {
    MasterJetpackComposeTheme {
        MyTextField()
    }
}

//Checkbox
@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()) {
        Checkbox(checked = checked, onCheckedChange = { isChecked ->
            checked = isChecked
        })
        if (checked) {
            Text("Checkbox is checked")
        } else {
            Text("Checkbox is not checked")
        }
    }

    Toast.makeText(
        context,
        "Checkbox Is Checked: $checked",
        Toast.LENGTH_SHORT
    ).show()
}

//Switch
@Composable
fun SwitchExample() {
    var checked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()) {
        Switch(checked = checked, onCheckedChange = {
            checked = it
        })
        if (checked) {
            Text("Switch is checked")
        } else {
            Text("Switch is not checked")
        }
    }

    Toast.makeText(
        context,
        "Switch Is Checked: $checked",
        Toast.LENGTH_SHORT
    ).show()
}

//Radio button
@Composable
fun RadioButtonExample() {
    var selectedOption by remember { mutableStateOf("Option 1") }
    Column(modifier = Modifier.padding(start = 15.dp)) {
        Text("Selected Option: $selectedOption")
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selectedOption == "Option 1"
            ,onClick = {
                selectedOption = "Option 1"
            })
            Text("Option 1")
        }

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selectedOption == "Option 2"
                ,onClick = {
                    selectedOption = "Option 2"
                })
            Text("Option 2")
        }

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selectedOption == "Option 3"
                ,onClick = {
                    selectedOption = "Option 3"
                })
            Text("Option 3")
        }
    }
}

//Radio button with Text
@Composable
fun RadioButtonRow(text: String, isSelected: Boolean, onSelect: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()) {
        RadioButton(selected = isSelected, onClick = onSelect)
        Text(text)
    }
}

@Composable
fun RadioButtonWithText() {
    var selectedOption by remember { mutableStateOf("Group 1") }
    Column(modifier = Modifier.padding(start = 15.dp)) {
        Text("Selected Group: $selectedOption")
        RadioButtonRow("Group 1", selectedOption == "Group 1") {
            selectedOption = "Group 1"
        }

        RadioButtonRow("Group 2", selectedOption == "Group 2") {
            selectedOption = "Group 2"
        }

        RadioButtonRow("Group 3", selectedOption == "Group 3") {
            selectedOption = "Group 3"
        }

    }
}

//Progress Indicator
//1. Circular Progress Indicator
@Composable
fun CircularProgressIndicatorExample() {
    CircularProgressIndicator(progress = 0.7f)
}
//2. Linear Progress Indicator
@Composable
fun LinearProgressIndicatorExample() {
    LinearProgressIndicator(progress = 0.7f,
        color = Color.Red)
}
//3. Determinate Progress Indicator


//Challenge 2
@Composable
fun ChallengeComposable2() {
    var progress by remember { mutableStateOf(0.0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        LinearProgressIndicator(progress = progress,
            color = Color.Green,
            trackColor = Color.Gray,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        FilledTonalButton(onClick = {progress += 0.1f}
        , colors = ButtonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Black,
                disabledContainerColor = Color.Gray,
                disabledContentColor= Color.Red
        )
        ) {
            val percent: Int = if (progress < 1) {
                (progress * 100).toInt()
            } else {
                100
            }
            Text("Increase Progress: $percent %")
        }
    }
}