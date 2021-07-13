package kr.co.dooribon.domain.entity

import com.google.gson.annotations.SerializedName

data class Travel(
    val id: String,
    val travelStartDate: String,
    val travelEndDate: String,
    val travelTitle: String,
    val travelThumbnailUrl: String,
    val travelDestination: String,
    val travelMembers: List<String>
)