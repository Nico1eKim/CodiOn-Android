package com.konkuk.codion.ui.codiRecord.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konkuk.codion.R
import com.konkuk.codion.ui.codiRecord.dummy.CodiRecordDummyData
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray200
import com.konkuk.codion.ui.theme.Gray400
import com.konkuk.codion.ui.theme.Gray700
import com.konkuk.codion.ui.util.getEmotionIcon

@Composable
fun MyComment(record: CodiRecordDummyData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(R.string.my_comment),
            style = CodiOnTypography.pretendard_700_16,
            color = Gray700,
        )
        Text(
            text = stringResource(R.string.edit),
            style = CodiOnTypography.pretendard_600_12.copy(
                textDecoration = TextDecoration.Underline
            ),
            color = Gray400,
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(color = Gray200)
            .border(shape = RoundedCornerShape(12.dp), width = 1.dp, color = Gray200)
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.my_comment_today),
                style = CodiOnTypography.pretendard_700_16,
                color = Gray700,
            )

            Icon(
                painter = painterResource(id = getEmotionIcon(record.emotion)),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp)
            )
        }

        Text(
            text = record.content,
            style = CodiOnTypography.pretendard_400_14.copy(
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.None
                ),
                lineHeight = 24.sp
            ),
            color = Gray700,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}
