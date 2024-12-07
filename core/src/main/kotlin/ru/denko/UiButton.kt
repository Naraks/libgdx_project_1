package ru.denko

import com.badlogic.gdx.Gdx
import org.kodein.di.DI
import org.kodein.di.instance

class UiButton(
    val text: String, val x: Float, val y: Float, val width: Float, val height: Float, val func: (di: DI) -> Unit
)

val startMenuButtons = listOf(
    UiButton("New Game", 100f, 200f, 100f, 25f) { di ->
        run {
            val gameStateManager by di.instance<GameStateManager>()
            gameStateManager.setState(PlayState(di))
        }
    },
    UiButton("Continue", 100f, 170f, 100f, 25f) { di -> },
    UiButton("Settings", 100f, 140f, 100f, 25f) { di ->
        run {
            val gameStateManager by di.instance<GameStateManager>()
            gameStateManager.setState(SettingsState(di))
        }
    },
    UiButton("Exit", 100f, 110f, 100f, 25f) { Gdx.app.exit() },
)

val settingsButtons = listOf(
    UiButton("Back", 210f, 40f, 100f, 25f) { di ->
        run {
            val gameStateManager by di.instance<GameStateManager>()
            gameStateManager.setState(MenuState(di))
        }
    },
    UiButton("Save", 340f, 40f, 100f, 25f) { di ->
        run {
            val gameStateManager by di.instance<GameStateManager>()
            gameStateManager.setState(MenuState(di))
        }
    }
)
