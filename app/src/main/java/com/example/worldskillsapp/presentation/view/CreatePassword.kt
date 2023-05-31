package com.example.worldskillsapp.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapp.R
import com.example.worldskillsapp.presentation.events.InputUserDataEvents
import com.example.worldskillsapp.presentation.state.UserDataState
import com.example.worldskillsapp.ui.theme.SkipTextButtonColor
import com.example.worldskillsapp.ui.theme.WorldSkillsAppTheme
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun EnterPassword(
    state: UserDataState,
    onEvent: (InputUserDataEvents) -> Unit,
    skipOnClick: () -> Unit
) {
    EnterPasswordContent(
        password = state.password,
        onPasswordChange = { onEvent(InputUserDataEvents.OnPasswordChange(it)) }
    )
}

@Composable
fun EnterPasswordContent(
    password: String,
    onPasswordChange: (String) -> Unit
) {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Пропустить",
                fontSize = 15.sp,
                fontWeight = FontWeight.W400,
                color = SkipTextButtonColor
            )
        }
        Text(
            modifier = Modifier.padding(top = 128.dp),
            text = "Создайте пароль",
            fontSize = 24.sp,
            fontWeight = FontWeight.W700,
            color = Color.Black
        )
        Text(
            modifier = Modifier.padding(16.dp, 8.dp),
            text = "Для защиты ваших персональных данных",
            fontSize = 15.sp,
            fontWeight = FontWeight.W400,
            color = Color.Gray
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp), horizontalArrangement = Arrangement.Center
        ) {
            repeat(4) { index ->
                Image(
                    modifier = Modifier.padding(2.dp),
                    painter = painterResource(id = if (index < password.length) R.drawable.selected_circle else R.drawable.unselected_circle),
                    contentDescription = ""
                )
            }
        }
        CustomKeyboard(password = "", onPasswordChange = {})

    }
}


@Composable
fun CustomKeyboard(
    password: String,
    onPasswordChange: (String) -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(50.dp, 64.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ButtonKeyBoard(title = "1", onClick = {})
            ButtonKeyBoard(title = "2", onClick = {})
            ButtonKeyBoard(title = "3", onClick = {})
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ButtonKeyBoard(title = "4", onClick = {})
            ButtonKeyBoard(title = "5", onClick = {})
            ButtonKeyBoard(title = "6", onClick = {})
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ButtonKeyBoard(title = "7", onClick = {})
            ButtonKeyBoard(title = "8", onClick = {})
            ButtonKeyBoard(title = "9", onClick = {})
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp), horizontalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.wrapContentSize()){
                ButtonKeyBoard(title = "0", onClick = {}, modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun ButtonKeyBoard(
    modifier: Modifier = Modifier,
    title: String,
    onClick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .clickable { onClick(title) },
        shape = CircleShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray.copy(0.4f),
            contentColor = Color.Black
        )
    ) {
        Box(modifier = Modifier.size(80.dp), contentAlignment = Alignment.Center) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.W600
            )
        }
    }
}

@Preview
@Composable
fun CreatePasswordPreview() {
    WorldSkillsAppTheme {
        Surface {
            EnterPassword(
                state = UserDataState(password = "1234"),
                onEvent = {

                },
                skipOnClick = {

                }
            )
        }
    }
}