package ru.denko

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameMain : Game() {

//    private val batch by lazy { SpriteBatch() }
//    private val hero by lazy { Hero() }

    private val batch by lazy { SpriteBatch() }
    private val gameStateManager by lazy { GameStateManager(batch) }

    override fun create() {
        //Gdx.input.inputProcessor = HeroInputProcessor(hero)
    }

    override fun render() {
        //hero.xPos += hero.xSpeed
        //hero.yPos += hero.ySpeed

        gameStateManager.update(Gdx.graphics.deltaTime)
        gameStateManager.render()
        //ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f)
        //batch.begin()
        //batch.draw(hero.image, hero.xPos, hero.yPos)
        //batch.end()
    }

    override fun dispose() {
        batch.dispose()
        //hero.dispose()
    }
}
