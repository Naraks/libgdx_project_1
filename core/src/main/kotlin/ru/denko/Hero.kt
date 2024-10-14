package ru.denko

import com.badlogic.gdx.graphics.Texture

class Hero {

    val image by lazy { Texture("square_white.png") }

    var xPos = 0f
    var yPos = 0f
    var xSpeed = 0f
    var ySpeed = 0f
    var isMovingByX = false
    var isMovingByY = false

    fun dispose() {
        image.dispose()
    }

}
