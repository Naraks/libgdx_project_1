package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import org.slf4j.LoggerFactory

class MenuState(gameStateManager: GameStateManager) : GameState(gameStateManager) {

    private val log = LoggerFactory.getLogger(javaClass)

    private val stage by lazy { Stage() }
    private val skin by lazy { Skin(Gdx.files.internal("ui/uiskin.json")) }

    init {
        startMenuButtons.forEach {
            val button = TextButton(it.text, skin)
            button.setPosition(it.x, it.y)
            button.width = it.width
            button.height = it.height
            button.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    log.debug("'${it.text}' clicked")
                    it.func.invoke(gameStateManager)
                }
            })
            stage.addActor(button)
        }

        gameStateManager.multiplexer.addProcessor(stage)
    }

    override fun update(dt: Float) {
        // переход в другое состояние
    }

    override fun render(batch: SpriteBatch) {
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }

    override fun dispose() {
        skin.dispose()
        stage.dispose()
    }

}
