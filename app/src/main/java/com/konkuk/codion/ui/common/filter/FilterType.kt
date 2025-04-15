package com.konkuk.codion.ui.common.filter

enum class FilterType(val label: String) {
    CATEGORY("카테고리"),
    PERSONAL_COLOR("퍼스널컬러"),
    COLOR("색상"),
    SITUATION("상황"),
    BOOKMARKED("즐겨찾기 여부");

    companion object {
        fun fromLabel(label: String): FilterType? =
            entries.find { it.label == label }
    }
}