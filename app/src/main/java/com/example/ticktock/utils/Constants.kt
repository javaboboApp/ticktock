package com.example.ticktock.utils

import com.example.ticktock.models.Player

object Constants {

    val ERROR_MSG_FINISHED = "The game is finished"
    val MOVE_NOT_ALLOWED_MSG ="This move is not allowed!!"
    val ROWS = 3
    val COLUMMS =3
    val MAX_MOVES_ALLOWED =9

    val PLAYER_1 =Player(1, "Player 1")
    val PLAYER_2 =Player(-1, "Player 2")
}