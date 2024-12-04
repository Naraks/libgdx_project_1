package ru.denko

import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter

class UiInputProcessor(
    private val gameStateManager: GameStateManager
) : InputAdapter() {

    override fun keyDown(keycode: Int): Boolean {
        when (keycode) {
            Input.Keys.ESCAPE -> {
                gameStateManager.setPreviousState()
                return true
            }

            else -> {
                return false
            }
        }
    }

}
