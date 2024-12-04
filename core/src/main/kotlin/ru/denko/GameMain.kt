package ru.denko

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameMain : Game() {

    private val batch by lazy { SpriteBatch() }
    private val gameStateManager by lazy { GameStateManager(batch) }

    override fun create() {

    }

    override fun render() {
        gameStateManager.update(Gdx.graphics.deltaTime)
        gameStateManager.render()
    }

    override fun dispose() {
        batch.dispose()
    }
}
