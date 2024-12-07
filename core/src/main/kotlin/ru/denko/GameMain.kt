package ru.denko

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

class GameMain : Game() {

    private val di = DI {
        bindSingleton<SpriteBatch> { SpriteBatch() }
        bindSingleton<InputMultiplexer> { InputMultiplexer() }
        bindSingleton<GameStateManager> { GameStateManager(di) }
        bindSingleton<UiInputProcessor> { UiInputProcessor(di) }
        bindSingleton<PrefInitializer> { PrefInitializer(di) }
    }

    private val batch by di.instance<SpriteBatch>()
    private val multiplexer by di.instance<InputMultiplexer>()
    private val gameStateManager by di.instance<GameStateManager>()
    private val uiInputProcessor by di.instance<UiInputProcessor>()

    override fun create() {
        multiplexer.addProcessor(uiInputProcessor)
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
