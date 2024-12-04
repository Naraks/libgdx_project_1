package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.utils.ScreenUtils

class MenuState(gameStateManager: GameStateManager) : GameState(gameStateManager) {

    private val buttonTexture = Texture(Gdx.files.internal("button.png"))
    private val buttonBounds = Rectangle(100f, 100f, buttonTexture.width.toFloat(), buttonTexture.height.toFloat())

    override fun update(dt: Float) {
        // переход в другое состояние
    }

    override fun render(batch: SpriteBatch) {
        ScreenUtils.clear(0f, 0f, 0f, 1f)

        batch.begin()
        batch.draw(buttonTexture, buttonBounds.x, buttonBounds.y, buttonBounds.width, buttonBounds.height)
        batch.end()
    }

    override fun dispose() {
        buttonTexture.dispose()
    }

}
