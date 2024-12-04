package ru.denko

import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import org.slf4j.LoggerFactory

class GameStateManager(
    private val batch: SpriteBatch,
    val multiplexer: InputMultiplexer
) {
    private val log = LoggerFactory.getLogger(javaClass)

    private var currentState: GameState = MenuState(this)

    private var previousState: GameState? = null

    fun update(dt: Float) {
        currentState.update(dt)
    }

    fun render() {
        currentState.render(batch)
    }

    fun setState(state: GameState) {
        previousState?.dispose()
        previousState = currentState
        currentState = state

        log.debug("Old state: {}", previousState)
        log.debug("New state: {}", currentState)
    }

    fun setPreviousState() {
        if (previousState != null) {
            val bufferState = currentState
            currentState = previousState!!
            previousState = bufferState

            log.debug("Old state: {}", previousState)
            log.debug("New state: {}", currentState)
        }
    }

}
