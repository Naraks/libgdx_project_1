package ru.denko

import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import ru.denko.settings.Settings

class HeroInputProcessor(
    private val gameStateManager: GameStateManager,
    private val hero: Hero
) : InputAdapter() {

    private val prefs by lazy { PrefInitializer.getInstance() }

    override fun keyDown(keycode: Int): Boolean {
        when (keycode) {
            Input.Keys.ESCAPE -> {
                gameStateManager.setState(MenuState(gameStateManager))
                return true
            }

            prefs.settings[Settings.MOVE_UP.name] -> {
                hero.ySpeed = 5f
                return true
            }

            prefs.settings[Settings.MOVE_DOWN.name] -> {
                hero.ySpeed = -5f
                return true
            }

            prefs.settings[Settings.MOVE_LEFT.name] -> {
                hero.xSpeed = -5f
                return true
            }

            prefs.settings[Settings.MOVE_RIGHT.name] -> {
                hero.xSpeed = 5f
                return true
            }

            else -> {
                return false
            }
        }
    }

    override fun keyUp(keycode: Int): Boolean {
        when (keycode) {
            prefs.settings[Settings.MOVE_UP.name] -> {
                hero.ySpeed = 0f
                return true
            }

            prefs.settings[Settings.MOVE_DOWN.name] -> {
                hero.ySpeed = 0f
                return true
            }

            prefs.settings[Settings.MOVE_LEFT.name] -> {
                hero.xSpeed = 0f
                return true
            }

            prefs.settings[Settings.MOVE_RIGHT.name] -> {
                hero.xSpeed = 0f
                return true
            }

            else -> {
                return false
            }
        }
    }
}
