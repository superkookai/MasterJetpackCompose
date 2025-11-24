package com.superkookai.masterjetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        observeNetworkState(this,this)
        setContent {
            MasterJetpackComposeTheme {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 100.dp)
                ) {
                    ChallengeComposable2()
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
                }
            }
        }
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