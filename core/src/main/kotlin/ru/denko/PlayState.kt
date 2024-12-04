package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils

class PlayState(gameStateManager: GameStateManager) : GameState(gameStateManager) {

    private val hero by lazy { Hero() }

    //private val buttonTexture = Texture(Gdx.files.internal("button.png"))
    //private val buttonBounds = Rectangle(100f, 100f, buttonTexture.width.toFloat(), buttonTexture.height.toFloat())

    init {
        Gdx.input.inputProcessor = HeroInputProcessor(hero)
    }

    override fun update(dt: Float) {

    }

    override fun render(batch: SpriteBatch) {
        hero.xPos += hero.xSpeed
        hero.yPos += hero.ySpeed

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f)
        batch.begin()
        //        batch.draw(buttonTexture, buttonBounds.x, buttonBounds.y, buttonBounds.width, buttonBounds.height)
        batch.draw(hero.image, hero.xPos, hero.yPos)
        batch.end()
    }

    override fun dispose() {
        hero.dispose()
    }
}
