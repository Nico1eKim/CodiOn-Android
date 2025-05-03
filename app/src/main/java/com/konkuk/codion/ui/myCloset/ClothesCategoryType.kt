package com.konkuk.codion.ui.myCloset

enum class ClothesCategoryType(
    val label: String,
    val parent: ClothesCategoryType? = null
) {
    // ✅ 대분류 (parent = null)
    ALL("전체"),
    TOP("상의"),
    OUTER("아우터"),
    BOTTOM("바지"),
    DRESS("원피스/스커트"),

    // ✅ 소분류
    SHORT_SLEEVE("반팔", TOP),
    LONG_SLEEVE("긴팔", TOP),

    WINDBREAKER("바람막이", OUTER),
    CARDIGAN("가디건", OUTER),
    JACKET("재킷", OUTER),
    PADDING("패딩", OUTER),

    SHORTS("반바지", BOTTOM),
    LONG_PANTS("긴바지", BOTTOM),

    MINI("미니 기장", DRESS),
    MIDI("미디 기장", DRESS),
    LONG("롱 기장", DRESS);

    companion object {
        fun getChildrenOf(parent: ClothesCategoryType): List<ClothesCategoryType> {
            return entries.filter { it.parent == parent }
        }

        fun getTopLevelCategories(): List<ClothesCategoryType> {
            return entries.filter { it.parent == null }
        }
    }
}