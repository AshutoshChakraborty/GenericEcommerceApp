package com.example.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.core.modifier.colorFullShadow
import com.example.core.theme.appRed
import com.example.core.theme.appRedWithAlpha
import com.example.core.theme.textGrey
import com.example.core.ui.BodyText
import com.example.core.ui.SubmitButton
import com.example.core.ui.ThemedIconButton
import com.example.core.ui.TitleView
import com.example.core.ui.TransparentTextField

@Composable
fun SignupScreen(navController: NavHostController,alreadyHaveAccountButtonClick:()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            TitleView(R.string.sign_up)
            TransparentTextField(
                "", "Name", Modifier
                    .padding(start = 16.dp, top = 73.dp, end = 16.dp)
                    .height(64.dp)
                    .fillMaxWidth(), textGrey

            )
            TransparentTextField(
                "", "Email", Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    .height(64.dp)
                    .fillMaxWidth(), textGrey
            )
            TransparentTextField(
                "", "Password", Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    .height(64.dp)
                    .fillMaxWidth(), textGrey
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
                ThemedIconButton(
                    R.drawable.round_arrow_right_alt_24px,
                    "Already have an Account ?"
                ) {
                    alreadyHaveAccountButtonClick.invoke()
                }
            }
            SubmitButton(
                Modifier
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
                stringResource(id = R.string.sign_up).uppercase()
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            BodyText(
                text = R.string.sign_up_with_social_media, modifier = Modifier
                    .wrapContentSize()
                    .padding(bottom = 12.dp)
                    .align(CenterHorizontally)
            )
            Row(
                Modifier
                    .wrapContentWidth()
                    .align(CenterHorizontally)
            ) {
                ThemedIconButton(imageResource = R.drawable.group, contentDescription = "Google") {

                }

                Spacer(modifier = Modifier.width(32.dp))
                ThemedIconButton(
                    imageResource = R.drawable.facebook_icon,
                    contentDescription = "Facebook"
                ) {

                }
            }
        }

    }

}


@Preview(
    showSystemUi = true, showBackground = true, backgroundColor = 0xFFFFFFFF,
    device = "id:pixel_4a", apiLevel = 33
)
@Composable
fun SignupScreenPreview() {
    SignupScreen(rememberNavController()){}
}