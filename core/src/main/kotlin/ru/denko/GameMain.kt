package ru.denko

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import java.time.ZoneId

class GameMain : ApplicationAdapter() {

    private val batch by lazy { SpriteBatch() }
    private val hero by lazy { Hero() }

    override fun create() {




        Gdx.input.inputProcessor = HeroInputProcessor(hero)
    }

    override fun render() {
        hero.xPos += hero.xSpeed
        hero.yPos += hero.ySpeed

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f)
        batch.begin()
        batch.draw(hero.image, hero.xPos, hero.yPos)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        hero.dispose()
    }
}
