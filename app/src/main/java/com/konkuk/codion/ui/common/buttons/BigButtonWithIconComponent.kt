package com.konkuk.codion.ui.common.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray700

@Composable
fun BigButtonWithIconComponent(
    containerColor: Color = Gray100,
    contentColor: Color = Gray700,
    text: String,
    icon: Painter,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(300.dp, 40.dp)
            .border(width = 1.dp, color = Gray700, shape = RoundedCornerShape(6.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.padding(start = 20.dp),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                color = contentColor,
                style = CodiOnTypography.pretendard_600_14,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BigButtonWithIconComponentPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp), verticalArrangement = Arrangement.Center
    ) {

        BigButtonWithIconComponent(
            text = stringResource(id = R.string.camera_personal_color),
            icon = painterResource(id = R.drawable.ic_camera)
        )
        Spacer(modifier = Modifier.height(16.dp))
        BigButtonWithIconComponent(
            text = stringResource(id = R.string.enter_yourself),
            icon = painterResource(id = R.drawable.ic_write)
        )
    }
}