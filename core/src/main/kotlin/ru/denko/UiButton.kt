package ru.denko

import com.badlogic.gdx.Gdx

class UiButton(
    val text: String,
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float,
    val func: (gameStateManager: GameStateManager) -> Unit
)

val startMenuButtons = listOf(
    UiButton("New Game", 100f, 200f, 100f, 25f) { gsm -> gsm.setState(PlayState(gsm)) },
    UiButton("Continue", 100f, 170f, 100f, 25f) { gsm -> },
    UiButton("Settings", 100f, 140f, 100f, 25f) { gsm -> },
    UiButton("Exit", 100f, 110f, 100f, 25f) { Gdx.app.exit() },
)
