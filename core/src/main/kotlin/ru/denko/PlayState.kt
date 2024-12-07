package ru.denko

import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class PlayState(
    override val di: DI
) : GameState, DIAware {
    private val multiplexer by di.instance<InputMultiplexer>()
    private val hero by lazy { Hero() }
    private val heroInputProcessor by lazy { HeroInputProcessor(hero, di) }

    override fun update(dt: Float) {

    }

    override fun render(batch: SpriteBatch) {
        hero.xPos += hero.xSpeed
        hero.yPos += hero.ySpeed

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f)

        batch.begin()
        batch.draw(hero.image, hero.xPos, hero.yPos)
        batch.end()
    }

    override fun dispose() {
        hero.dispose()
    }

    override fun addInputProcessor() {
        multiplexer.addProcessor(heroInputProcessor)
    }

    override fun removeInputProcessor() {
        multiplexer.removeProcessor(heroInputProcessor)
    }
}
