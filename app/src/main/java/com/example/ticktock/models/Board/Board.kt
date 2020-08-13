package com.example.ticktock.models.Board

import android.text.BoringLayout
import android.util.Log
import com.example.ticktock.models.Player
import com.example.ticktock.utils.Constants.COLUMMS
import com.example.ticktock.utils.Constants.ROWS
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

interface IBoard {
    fun move(x: Int, y: Int, player: Player) : Boolean
}

private const val TAG = "Board"
class Board() : IBoard {
    private val matrix: Array<Array<Cell>> =
        Array(ROWS) { Array(COLUMMS) {  Cell() } }
     enum class Status {
         WIN_PLAYER1,DRAW,LOSS
     }
    override fun move(x: Int, y: Int, player: Player): Boolean {
        require(x in 0..ROWS-1) {
            throw IllegalArgumentException("x must be between 0 and ${ROWS-1}")
        }
        require(y in 0..COLUMMS-1) {
            throw IllegalArgumentException("x must be between 0 and ${ROWS-1}")
        }
        require(matrix[x][y].player_id == 0) {
            throw IllegalStateException("This move is not allowed!!")
        }

        matrix[x][y].player_id = player.id



       return checkGameStatus();

    }

    private fun checkGameStatus(): Boolean {
       //TODO WE KNOWS THAT IS A 3X3 BOARD
        return (matrix[0][0] == matrix [0][1] && matrix[0][0] == matrix [0][2]) ||
                (matrix[0][0] == matrix [1][1] && matrix[0][0] == matrix [2][2]) ||
                (matrix[0][0] == matrix [1][0] && matrix[0][0] == matrix [2][0]) ||
                (matrix[2][0] == matrix [2][1] && matrix[2][0] == matrix [2][2]) ||
                (matrix[2][0] == matrix [1][1] && matrix[0][0] == matrix [0][2]) ||
                (matrix[0][2] == matrix [1][2] && matrix[0][2] == matrix [2][2]) ||
                (matrix[0][1] == matrix [1][1] && matrix[0][1] == matrix [2][1]) ||
                (matrix[1][0] == matrix [1][1] && matrix[1][0] == matrix [1][2])
    }


}
