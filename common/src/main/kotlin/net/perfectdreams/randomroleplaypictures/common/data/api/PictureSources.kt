package net.perfectdreams.randomroleplaypictures.common.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class PictureSource

@Serializable
@SerialName("anime")
data class AnimeSource(val name: String) : PictureSource()