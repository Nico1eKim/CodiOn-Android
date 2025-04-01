package com.konkuk.codion.ui.codiRecord.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.codiRecord.component.EnterCodiRecordDetail
import com.konkuk.codion.ui.codiRecord.component.EnterTodayCodiEmotion
import com.konkuk.codion.ui.common.TopAppBarComponent
import com.konkuk.codion.ui.common.buttons.BigButtonComponent
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun RegisterCodiCommentScreen(modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = stringResource(R.string.add_comment),
                leftIcon = null,
                onLeftClicked = null,
                rightIcon = null,
                onRightClicked = null
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(top = 24.dp, bottom = 32.dp, start = 20.dp, end = 20.dp)
            ) {
                EnterTodayCodiEmotion()

                EnterCodiRecordDetail(
                    text = text,
                    onTextChange = { text = it },
                )

                Spacer(Modifier.weight(1f))

                BigButtonComponent(
                    containerColor = Gray900,
                    contentColor = Gray100,
                    text = stringResource(R.string.upload)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun RegisterCodiCommentScreenPreview() {
    RegisterCodiCommentScreen()
}