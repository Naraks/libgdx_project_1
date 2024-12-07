package ru.denko

import com.badlogic.gdx.graphics.g2d.SpriteBatch

interface GameState {

    fun update(dt: Float)

    fun render(batch: SpriteBatch)

    fun dispose()

    fun addInputProcessor()

    fun removeInputProcessor()

}
