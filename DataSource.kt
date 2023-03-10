package com.example.instadmscreen.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import com.example.instadmscreen.R

class DataSource {
    fun loadDmList(): List<DM> {
        return listOf(
            DM("Hulk", "What's up?!", R.drawable.hulk),
            DM("CaptainMarvel", "Meeting at 10", R.drawable.cmarvel),
            DM("Spider", "Hey captain", R.drawable.spider),
            DM("IronMan", "Hahaha", R.drawable.ironman),
            DM("Doctor", "Magic", R.drawable.doctor)
        )
    }

    fun loadHighlight(): List<ImageAndText>{
        return listOf(
            ImageAndText("Cars",image = R.drawable.c1,icon = null),
            ImageAndText("Watches",image = R.drawable.w1,icon = null)
        )
    }

    fun differentTabs(): List<ImageAndText>{
        return listOf(
            ImageAndText(
                icon = null,
                image = R.drawable.baseline_grid_on_24,
                text = "Posts"
            ),
            ImageAndText(
                icon = null,
                image = R.drawable.ic_reels,
                text = "Reels"
            ),
            ImageAndText(
                icon = null,
                image = R.drawable.ic_igtv,
                text = "IGTV"
            )
        )
    }

    fun posts(): List<Posts>{
        return listOf(
            Posts(R.drawable.c1),
            Posts(R.drawable.c2),
            Posts(R.drawable.c3),
            Posts(R.drawable.c4),
            Posts(R.drawable.w1),
            Posts(R.drawable.w2),
            Posts(R.drawable.w3)
        )
    }

    fun mainScreenTabs(): List<ImageAndText>{
        return listOf(
            ImageAndText(
                icon = Icons.Outlined.Home,
                image = null,
                text = "Home"
            ),
            ImageAndText(
                icon = Icons.Outlined.Search,
                image = null,
                text = "Search"
            ),
            ImageAndText(
                icon = Icons.Outlined.AddBox,
                image = null,
                text = "Add"
            ),
            ImageAndText(
                icon = null,
                image = R.drawable.ic_reels,
                text = "Reels"
            ),
            ImageAndText(
                icon = Icons.Outlined.Person,
                image = null,
                text = "Person"
            )
        )
    }

}