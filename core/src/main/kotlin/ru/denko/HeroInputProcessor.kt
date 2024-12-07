package ru.denko

import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance
import ru.denko.settings.Settings

class HeroInputProcessor(
    private val hero: Hero,
    override val di: DI
) : InputAdapter(), DIAware {
    private val gameStateManager by di.instance<GameStateManager>()
    private val prefs by di.instance<PrefInitializer>()

    override fun keyDown(keycode: Int): Boolean {
        when (keycode) {
            Input.Keys.ESCAPE -> {
                gameStateManager.setState(MenuState(di))
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
