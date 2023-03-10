package com.example.instadmscreen.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class DM(
     val name: String,
     val message: String,
    @DrawableRes val imageId: Int
)

data class ImageAndText(
    val text: String,
    @DrawableRes val image: Int?,
    val icon: ImageVector?
)

data class Posts(
    @DrawableRes val post: Int
)