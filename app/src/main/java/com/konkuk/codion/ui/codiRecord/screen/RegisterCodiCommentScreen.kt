package com.konkuk.codion.ui.codiRecord.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.codiRecord.component.EnterTodayCodiEmotion
import com.konkuk.codion.ui.common.TopAppBarComponent

@Composable
fun RegisterCodiCommentScreen(modifier: Modifier = Modifier) {
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
                    .padding(top = 24.dp)
            ) {
                EnterTodayCodiEmotion()
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun RegisterCodiCommentScreenPreview() {
    RegisterCodiCommentScreen()
}