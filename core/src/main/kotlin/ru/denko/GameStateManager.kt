package ru.denko

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance
import org.slf4j.LoggerFactory

class GameStateManager(
    override val di: DI
): DIAware {
    private val log = LoggerFactory.getLogger(javaClass)
    private val batch by di.instance<SpriteBatch>()

    private var currentState: GameState = MenuState(di)

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
