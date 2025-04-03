package com.konkuk.codion.ui.mypage.dummy

import com.konkuk.codion.R

data class ProfileDummyData(
    val email: String,  // 이메일
    val pwd: String,  // 비밀번호
    val img: Int = R.drawable.img_profile,  // 프로필 이미지
    val nickname: String,  // 별명
    val personal: String,  // 퍼스널컬러
    val monthCodi: Int  // 이번 달 완성한 코디 개수
) {
    companion object {
        val dummyData = ProfileDummyData(
            email = "honggildong@naver.com",
            pwd = "honggildong1!",
            nickname = "홍길동",
            personal = "가을 웜톤",
            monthCodi = 7
        )
    }
}
