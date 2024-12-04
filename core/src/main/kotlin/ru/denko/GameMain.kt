package ru.denko

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ru.denko.screens.ScreenManager
import ru.denko.screens.ScreenType

class GameMain : Game() {

    private val batch by lazy { SpriteBatch() }
    private val hero by lazy { Hero() }

    private lateinit var screenManager: ScreenManager

    override fun create() {
        screenManager = ScreenManager(this)
        screenManager.showScreen(ScreenType.START_MENU)
        //Gdx.input.inputProcessor = HeroInputProcessor(hero)
    }

    override fun render() {
        //hero.xPos += hero.xSpeed
        //hero.yPos += hero.ySpeed

        screenManager.render(Gdx.graphics.deltaTime)
        //ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f)
        //batch.begin()
        //batch.draw(hero.image, hero.xPos, hero.yPos)
        //batch.end()
    }

    override fun dispose() {
        screenManager.dispose()
        batch.dispose()
        hero.dispose()
    }
}
