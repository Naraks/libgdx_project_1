package ru.denko

import com.badlogic.gdx.graphics.g2d.SpriteBatch

abstract class GameState(
    private val gameStateManager: GameStateManager
) {

    abstract fun update(dt: Float)

    abstract fun render(batch: SpriteBatch)

    abstract fun dispose()

}
