package ru.denko

import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class UiInputProcessor(
    override val di: DI
) : InputAdapter(), DIAware {
    private val gameStateManager by di.instance<GameStateManager>()

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
