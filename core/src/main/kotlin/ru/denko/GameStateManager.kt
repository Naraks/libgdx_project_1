package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance
import org.slf4j.LoggerFactory

class GameStateManager(
    override val di: DI
) : DIAware {
    private val cursorTexture = Texture(Gdx.files.internal("cursor.png"))
    private val cursorInputProcessor = CursorInputProcessor(0f, 0f)

    private val stateProcessorIndex = 2

    private val log = LoggerFactory.getLogger(javaClass)
    private val batch by di.instance<SpriteBatch>()
    private val multiplexer by di.instance<InputMultiplexer>()

    private var currentState: GameState = MenuState(di)

    private var previousState: GameState? = null

    init {
        multiplexer.addProcessor(cursorInputProcessor)
        currentState.addInputProcessor()
    }

    fun update(dt: Float) {
        currentState.update(dt)
    }

    fun render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f)
        batch.begin()
        batch.draw(
            cursorTexture,
            cursorInputProcessor.cursorPosition.x,
            Gdx.graphics.height - cursorInputProcessor.cursorPosition.y
        )
        batch.end()
        currentState.render(batch)
    }

    fun setState(state: GameState) {
        multiplexer.removeProcessor(stateProcessorIndex)
        previousState?.dispose()
        previousState = currentState
        currentState = state
        currentState.addInputProcessor()

        log.debug("Old state: {}", previousState)
        log.debug("New state: {}", currentState)
    }

    fun setPreviousState() {
        if (previousState != null) {
            multiplexer.removeProcessor(stateProcessorIndex)
            val bufferState = currentState
            currentState = previousState!!
            previousState = bufferState
            currentState.addInputProcessor()

            log.debug("Old state: {}", previousState)
            log.debug("New state: {}", currentState)
        }
    }

}
