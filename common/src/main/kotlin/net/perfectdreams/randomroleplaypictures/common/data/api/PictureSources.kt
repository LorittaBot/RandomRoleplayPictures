package net.perfectdreams.randomroleplaypictures.common.data.api

import kotlinx.serialization.Serializable

@Serializable
sealed class PictureSource

@Serializable
data class AnimeSource(val name: String) : PictureSource()