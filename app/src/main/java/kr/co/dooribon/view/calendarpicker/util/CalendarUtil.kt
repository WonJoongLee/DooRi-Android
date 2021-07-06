package kr.co.dooribon.view.calendarpicker.util

import java.util.*
import java.util.Calendar.*


fun Calendar.toPrettyMonthString(
    style: Int = LONG,
    locale: Locale = Locale.getDefault()
): String {
    val month = getDisplayName(MONTH, style, locale)
    val year = get(YEAR).toString()
    return if (month == null) throw IllegalStateException("Cannot get pretty name")
    else "$month $year"
}

fun Calendar.toPrettyDateString(locale: Locale = Locale.getDefault()): String {
    val day = get(DAY_OF_MONTH).toString()
    return "$day ${this.toPrettyMonthString(SHORT, locale)}"
}

// 현재 날짜로 부터 날이 이미 지났는지
fun Calendar.isBefore(otherCalendar : Calendar) : Boolean {
    return get(YEAR) == otherCalendar.get(YEAR)
            && get(MONTH) == otherCalendar.get(MONTH)
            && get(DAY_OF_MONTH) < otherCalendar.get(DAY_OF_MONTH)
}

// 기본 1년으로 보여줄거니까 , 1년 후 지난 날들만 채워주면 된다.
fun Calendar.isAfter(otherCalendar: Calendar) : Boolean {
    return get(YEAR) == otherCalendar.get(YEAR)
            && get(MONTH) == otherCalendar.get(MONTH)
            && get(DAY_OF_MONTH) > otherCalendar.get(DAY_OF_MONTH)
}

fun Calendar.totalMonthDifference(startCalendar : Calendar) : Int {
    val yearDiff = get(YEAR) - startCalendar.get(YEAR)
    val monthDiff = get(MONTH) - startCalendar.get(MONTH)

    return monthDiff + (yearDiff * 12)
}