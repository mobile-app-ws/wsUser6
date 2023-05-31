@file:OptIn(ExperimentalFoundationApi::class)

package com.example.worldskillsapp.presentation.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskillsapp.R
import com.example.worldskillsapp.domain.models.ScreenPagerModel
import com.example.worldskillsapp.ui.theme.PagerCircleColor
import com.example.worldskillsapp.ui.theme.SkipTextButtonColor
import com.example.worldskillsapp.ui.theme.StartScreenDescriptionColor
import com.example.worldskillsapp.ui.theme.StartScreenTitleTextColor
import com.example.worldskillsapp.ui.theme.WorldSkillsAppTheme
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch

@Destination
@Composable
fun StartScreen(

) {
    val selectedPage = remember { mutableStateOf(0) }
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    HorizontalPager(
        pageCount = ScreenPagerModel.values().size, state = pagerState
    ) { index ->
        StartScreenContent(
            index = ScreenPagerModel.values()[index].index,
            onIndexChange = { page ->
                selectedPage.value = page
            },
            page = ScreenPagerModel.values()[index],
            numberOfPages = ScreenPagerModel.values().size,
            pagerState = pagerState,
            skipOnClick = {
                scope.launch {
                    pagerState.scrollToPage(pagerState.currentPage.inc())
                }
            },
            stopOnClick = {

            }
        )
    }
}

@Composable
fun StartScreenContent(
    index: Int,
    onIndexChange: (Int) -> Unit,
    page: ScreenPagerModel,
    numberOfPages: Int,
    pagerState: PagerState,
    skipOnClick: () -> Unit,
    stopOnClick: () -> Unit
) {
    LaunchedEffect(Unit) {
        onIndexChange(index)
    }
    Box(Modifier.fillMaxSize()) {
        RowTopContent(page = page, skipOnClick = skipOnClick, stopOnClick = stopOnClick)
        TitleDescription(
            modifier = Modifier.align(Alignment.Center),
            title = page.title,
            description = page.description,
            numberOfPages = numberOfPages,
            pagerState = pagerState
        )
        ContentImage(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            image = page.image
        )
    }
}

@Composable
fun RowTopContent(
    page: ScreenPagerModel,
    skipOnClick: () -> Unit,
    stopOnClick: () -> Unit,
) {
    Box(Modifier.fillMaxWidth()) {
        when (page) {
            ScreenPagerModel.FirstPage -> {
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(),
                            onClick = skipOnClick
                        ),
                    text = "Пропустить", color = SkipTextButtonColor
                )
            }

            ScreenPagerModel.SecondPage -> {
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(),
                            onClick = skipOnClick
                        ), text = "Пропустить",
                    color = SkipTextButtonColor
                )
            }

            ScreenPagerModel.ThirdPage -> {
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(),
                            onClick = stopOnClick
                        ), text = "Завершить", color = SkipTextButtonColor
                )
            }
        }
        Image(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.transparent_medic_box),
            contentDescription = null
        )
    }
}

@Composable
fun TitleDescription(
    modifier: Modifier,
    title: String,
    description: String,
    numberOfPages: Int,
    pagerState: PagerState
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = StartScreenTitleTextColor
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 64.dp, end = 64.dp, top = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = description,
                fontSize = 14.sp,
                color = StartScreenDescriptionColor
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(numberOfPages) { index ->
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .padding(4.dp, 0.dp),
                    painter = painterResource(id = if (index == pagerState.currentPage) R.drawable.selected_page else R.drawable.unselected_page),
                    contentDescription = null,
                    tint = PagerCircleColor
                )
            }
        }
    }
}

@Composable
fun ContentImage(
    modifier: Modifier,
    image: Int
) {
    Image(
        modifier = modifier
            .padding(bottom = 64.dp)
            .size(180.dp),
        painter = painterResource(id = image),
        contentDescription = null
    )
}

@Preview
@Composable
fun StartScreenPreview() {
    WorldSkillsAppTheme {
        Surface {
            StartScreen()
        }
    }
}