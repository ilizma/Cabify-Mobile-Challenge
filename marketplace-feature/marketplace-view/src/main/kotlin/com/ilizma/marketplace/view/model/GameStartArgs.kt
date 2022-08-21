package com.ilizma.game.view.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameStartArgs(
    val player1Name: String,
    val player2Name: String,
) : Parcelable