package com.konkuk.codion.ui.common.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.konkuk.codion.ui.theme.Gray500
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun SmallButtonComponent(
    modifier: Modifier = Modifier,
    containerColor: Color,
    contentColor: Color,
    text: String,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        contentPadding = contentPadding
    ) {
        Text(
            text = text,
            style = CodiOnTypography.pretendard_400_14,
            color = contentColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SmallButtonComponentPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp), verticalArrangement = Arrangement.Center
    ) {
        SmallButtonComponent(
            modifier = Modifier.width(90.dp),
            containerColor = Gray900,
            contentColor = Gray100,
            contentPadding = PaddingValues(0.dp),
            text = stringResource(R.string.send_authentication_number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        SmallButtonComponent(
            modifier = Modifier.width(144.dp).border(1.dp, Gray500, RoundedCornerShape(6.dp)),
            containerColor = Gray100,
            contentColor = Gray700,
            text = stringResource(R.string.can_wear)
        )
        Spacer(modifier = Modifier.height(16.dp))
        SmallButtonComponent(
            modifier = Modifier.width(200.dp),
            containerColor = Gray900,
            contentColor = Gray100,
            text = stringResource(R.string.enter_personal_color)
        )
    }
}