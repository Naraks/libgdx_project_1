package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener

class MenuState(gameStateManager: GameStateManager) : GameState(gameStateManager) {

    private val stage by lazy { Stage() }
    private val skin by lazy { Skin(Gdx.files.internal("ui/uiskin.json")) }

    private val startButton by lazy { TextButton("New Game", skin) }

    init {
        startButton.setPosition(100f, 100f)
        startButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                println("New Game")
                gameStateManager.setState(PlayState(gameStateManager))
            }
        })

        stage.addActor(startButton)
        Gdx.input.inputProcessor = stage
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
