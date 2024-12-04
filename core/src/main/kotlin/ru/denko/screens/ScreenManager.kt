package ru.denko.screens

import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen
import ru.denko.StartMenuScreen

class ScreenManager(
    private val game: Game
) {
    private var currentScreen: Screen? = null

    fun showScreen(screenType: ScreenType) {
        currentScreen?.dispose()

        when (screenType) {
            ScreenType.START_MENU -> currentScreen = StartMenuScreen(this)
        }

        game.screen = currentScreen
    }

    fun render(delta: Float) {
        currentScreen?.render(delta)
    }

    fun dispose() {
        currentScreen?.dispose()
    }

}
