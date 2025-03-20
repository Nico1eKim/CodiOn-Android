package com.konkuk.codion.ui.common.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray300
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun BigButtonComponent(
    containerColor: Color,
    contentColor: Color,
    text: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .size(300.dp, 40.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
    ) {
        Text(
            text = text,
            style = CodiOnTypography.pretendard_600_16,
            color = contentColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BigButtonComponentPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp), verticalArrangement = Arrangement.Center
    ) {
        BigButtonComponent(
            containerColor = Gray900,
            contentColor = Gray100,
            text = stringResource(R.string.login)
        )
        Spacer(modifier = Modifier.height(16.dp))
        BigButtonComponent(
            containerColor = Gray300,
            contentColor = Gray700,
            text = stringResource(R.string.reanalyze)
        )
    }
}