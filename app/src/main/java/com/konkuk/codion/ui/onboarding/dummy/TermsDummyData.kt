package com.konkuk.codion.ui.onboarding.dummy

data class TermsDummyData(
    val isRequired: Boolean,  // 필수 여부
    val label: String,  // 항목 이름
    val detailTerms: String,  // 상세 약관 내용
    val isChecked: Boolean = false,  // 사용자가 체크했는지 여부
    val isAllAgreement: Boolean = false,  // 전체 동의 항목인지 여부
) {
    companion object {
        val dummyData = listOf(
            TermsDummyData(
                isRequired = true,
                label = "전체 동의하기",
                detailTerms = "",
                isAllAgreement = true
            ),
            TermsDummyData(
                isRequired = true,
                label = "개인정보 처리방침",
                detailTerms = ""
            ),
            TermsDummyData(
                isRequired = true,
                label = "서비스 이용약관",
                detailTerms = ""
            ),
            TermsDummyData(
                isRequired = true,
                label = "위치 기반 서비스 이용약관",
                detailTerms = ""
            ),
            TermsDummyData(
                isRequired = true,
                label = "신체적 특성 정보 활용 동의",
                detailTerms = ""
            ),
            TermsDummyData(
                isRequired = false,
                label = "마케팅 정보 수신 동의",
                detailTerms = ""
            )
        )
    }
}
