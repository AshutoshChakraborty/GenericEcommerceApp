package com.example.authentication

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.authentication.theme.appRed
import com.example.authentication.theme.appRedWithAlpha
import com.example.authentication.theme.metropolis
import com.example.authentication.theme.textGrey

@Composable
fun SignupScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Title(R.string.sign_up)
            TransparentTextField(
                "", "Name", Modifier
                    .padding(start = 16.dp, top = 73.dp, end = 16.dp)
                    .height(64.dp)
                    .fillMaxWidth()

            )
            TransparentTextField(
                "", "Email", Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    .height(64.dp)
                    .fillMaxWidth()
            )
            TransparentTextField(
                "", "Password", Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    .height(64.dp)
                    .fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.End, modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
            ) {
                BodyText(
                    text = R.string.already_have_an_account,
                    modifier = Modifier.padding(start = 14.dp, top = 16.dp, end = 4.dp)
                )
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.round_arrow_right_alt_24px),
                        contentDescription = "Forget password"
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 28.dp)
                    .colorFullShadow(
                        appRedWithAlpha,
                        offsetY = 12.dp,
                        borderRadius = 25.dp,
                        spread = 3.dp,
                        blurRadius = 5.dp
                    )
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(50))
                    .background(color = appRed),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(id = R.string.sign_up).uppercase(),
                    fontSize = 14.sp,
                    fontFamily = metropolis,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )

            }
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)) {
            BodyText(
                text = R.string.sign_up_with_social_media, modifier = Modifier
                    .wrapContentSize()
                    .padding(bottom = 12.dp,)
                    .align(CenterHorizontally)
            )
            Row(
                Modifier
                    .wrapContentWidth()
                    .align(CenterHorizontally)) {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = "Google"
                    )
                }
                Spacer(modifier = Modifier.width(32.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook_icon),
                        contentDescription = "Facebook"
                    )
                }
            }
        }

    }

}

@Composable
private fun Title(text: Int) {
    Text(
        stringResource(text),
        fontFamily = metropolis,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        modifier = Modifier.padding(start = 14.dp, top = 18.dp)
    )
}

@Composable
private fun BodyText(text: Int, modifier: Modifier) {
    Text(
        stringResource(text),
        fontFamily = metropolis,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        modifier = modifier
    )
}

@Composable
private fun TransparentTextField(textValue: String, lable: String, modifier: Modifier) {
    TextField(
        value = textValue,
        onValueChange = {

        },
        label = {
            Text(
                text = lable,
                fontSize = 14.sp,
                color = textGrey,
                fontFamily = metropolis,
                fontWeight = FontWeight.Normal
            )
        },
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            disabledContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

fun Modifier.colorFullShadow(
    color: Color = Color.Black,
    borderRadius: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0f.dp,
    modifier: Modifier = Modifier
) = this.then(
    modifier.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val spreadPixel = spread.toPx()
            val leftPixel = (0f - spreadPixel) + offsetX.toPx()
            val topPixel = (0f - spreadPixel) + offsetY.toPx()
            val rightPixel = (this.size.width + spreadPixel)
            val bottomPixel = (this.size.height + spreadPixel)

            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }

            frameworkPaint.color = color.toArgb()
            it.drawRoundRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint
            )
        }
    }
)


@Preview(
    showSystemUi = true, showBackground = true, backgroundColor = 0xFFFFFFFF,
    device = "id:pixel_4a", apiLevel = 33
)
@Composable
fun LoginScreenPreview() {
    SignupScreen(rememberNavController())
}