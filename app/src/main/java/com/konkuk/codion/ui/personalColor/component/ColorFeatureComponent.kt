package com.konkuk.codion.ui.personalColor.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.konkuk.codion.R
import com.konkuk.codion.ui.personalColor.dummy.ColorDummyData
import com.konkuk.codion.ui.theme.CodiOnTypography
import com.konkuk.codion.ui.theme.Gray700

// 이미지, 눈빛, 피부톤 text 3줄에 해당하는 컴포넌트
@Composable
fun ColorFeatureComponent(
    personalColorData: ColorDummyData
) {
    val spacing = with(LocalDensity.current) { 6.sp.toDp() }

    Column(
        verticalArrangement = Arrangement.spacedBy(spacing)
    ) {
        // 이미지
        ColorFeatureLineComponent(
            featureId = R.string.image,
            featureList = personalColorData.imageList
        )
        // 눈빛
        ColorFeatureLineComponent(
            featureId = R.string.eye,
            featureList = personalColorData.eyeList
        )
        // 피부톤
        ColorFeatureLineComponent(
            featureId = R.string.skin,
            featureList = personalColorData.skinList
        )
    }
}

// text 한 줄에 해당하는 컴포넌트
@Composable
fun ColorFeatureLineComponent(
    featureId: Int,
    featureList: List<String>
) {
    Row {
        Text(
            text = "・" + stringResource(featureId) + ": ",
            style = CodiOnTypography.pretendard_400_12,
            color = Gray700
        )
        Text(
            text = featureList.joinToString(", "),
            style = CodiOnTypography.pretendard_400_12,
            color = Gray700
        )
    }
}

@Preview
@Composable
fun ColorFeatureComponentPreview() {
    ColorFeatureComponent(ColorDummyData.autumnDummyData)
}