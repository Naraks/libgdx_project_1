package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.math.Vector2
import org.slf4j.LoggerFactory

class CursorInputProcessor(
    cursorX: Float, cursorY: Float
) : InputProcessor {
    private val log = LoggerFactory.getLogger(javaClass)
    var cursorPosition = Vector2(cursorX, cursorY)

    override fun keyDown(keycode: Int): Boolean {
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchCancelled(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        log.info(
            "mouseMoved: $screenX, ${
                Gdx.graphics.height - screenY
            }"
        )
        cursorPosition.set(screenX.toFloat(), screenY.toFloat())
        return false
    }

    override fun scrolled(amountX: Float, amountY: Float): Boolean {
        return false
    }


}
