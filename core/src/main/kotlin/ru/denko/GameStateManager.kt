package ru.denko

import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameStateManager(
    private val batch: SpriteBatch
) {
    private var currentState: GameState = MenuState(this)

    fun update(dt: Float) {
        currentState.update(dt)
    }

    fun render() {
        currentState.render(batch)
    }

    fun setState(state: GameState) {
        currentState.dispose()
        currentState = state
    }

}
