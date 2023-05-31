package com.example.worldskillsapp.presentation.view

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapp.R
import com.example.worldskillsapp.domain.models.ScreenPagerModel
import com.example.worldskillsapp.ui.theme.SkipTextButtonColor
import com.example.worldskillsapp.ui.theme.WorldSkillsAppTheme
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalFoundationApi::class)
@Destination
@Composable
fun OnBoardScreen(
    confirmOnClick: () -> Unit,
    skipOnClick: () -> Unit,
) {
    val pagerState = rememberPagerState()
    HorizontalPager(pageCount = ScreenPagerModel.values().size, state = pagerState) { index ->
        OnBoardScreenContent(
            page = ScreenPagerModel.values()[index],
            skipOnClick = skipOnClick,
            confirmOnClick = confirmOnClick
        )
    }
}

@Composable
fun OnBoardScreenContent(
    page: ScreenPagerModel, skipOnClick: () -> Unit, confirmOnClick: () -> Unit
) {
    Box(Modifier.fillMaxSize()) {
        TopContentOnBoard(
            page = page, skipOnClick = skipOnClick, confirmOnClick = confirmOnClick
        )

    }
}

@Composable
fun TopContentOnBoard(
    page: ScreenPagerModel, skipOnClick: () -> Unit, confirmOnClick: () -> Unit
) {
    Row(
        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        when (page) {
            ScreenPagerModel.FirstPage -> {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(),
                            onClick = skipOnClick
                        ),
                    text = "Пропустить",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = SkipTextButtonColor
                )
            }
            ScreenPagerModel.SecondPage -> {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(),
                            onClick = skipOnClick
                        ),
                    text = "Пропустить",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = SkipTextButtonColor
                )
            }

            ScreenPagerModel.ThirdPage -> {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(),
                            onClick = confirmOnClick
                        ),
                    text = "Завершить",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = SkipTextButtonColor
                )
            }
        }
        Image(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(168.dp, 163.dp),
            painter = painterResource(id = R.drawable.transparent_medic_box),
            contentDescription = null
        )
    }
}

@Composable
fun TitleAndDescription(
    index: Int,
    title: String,
    description: String
) {

}

@Preview
@Composable
fun OnBoardScreenPreview() {
    WorldSkillsAppTheme {
        Surface {
            OnBoardScreen(confirmOnClick = {}, skipOnClick = {})
        }
    }
}