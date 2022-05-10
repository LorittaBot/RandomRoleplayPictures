package net.perfectdreams.randomroleplaypictures.common.data.api

import kotlinx.serialization.Serializable

@Serializable
data class PictureResponse(
    val path: String,
    val source: PictureSource?
)