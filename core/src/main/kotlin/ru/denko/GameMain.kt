package ru.denko

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameMain : Game() {

    private val batch by lazy { SpriteBatch() }
    private val multiplexer by lazy { InputMultiplexer() }
    private val gameStateManager by lazy { GameStateManager(batch, multiplexer) }

    override fun create() {
        multiplexer.addProcessor(UiInputProcessor(gameStateManager))
        Gdx.input.inputProcessor = multiplexer
    }

    override fun render() {
        gameStateManager.update(Gdx.graphics.deltaTime)
        gameStateManager.render()
    }

    override fun dispose() {
        batch.dispose()
    }
}
