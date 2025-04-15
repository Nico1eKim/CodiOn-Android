package com.konkuk.codion.ui.codiRecord.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.konkuk.codion.R
import com.konkuk.codion.ui.common.buttons.SmallButtonComponent
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray100
import com.konkuk.codion.ui.theme.Gray400
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.theme.Gray900

@Composable
fun CodiRecordEmpty() {
    Column(Modifier.padding(horizontal = 20.dp)) {
        Text(
            text = stringResource(R.string.wore_clothes_empty_title),
            style = CodiOnTypography.pretendard_700_16,
            color = Gray700,
        )

        Text(
            text = stringResource(R.string.wore_clothes_empty),
            style = CodiOnTypography.pretendard_600_12.copy(
                textDecoration = TextDecoration.Underline
            ),
            color = Gray400,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(8.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SmallButtonComponent(
                modifier = Modifier.width(200.dp),
                containerColor = Gray900,
                contentColor = Gray100,
                text = stringResource(R.string.record_codi)
            )
        }
    }
}