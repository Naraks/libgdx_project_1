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

    private val startButton by lazy { TextButton("New Game", skin) }
    private val continueButton by lazy { TextButton("Continue", skin) }
    private val settingsButton by lazy { TextButton("Settings", skin) }
    private val exitButton by lazy { TextButton("Exit", skin) }

    init {
        startButton.setPosition(100f, 200f)
        startButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                log.debug("'New Game' clicked")
                gameStateManager.setState(PlayState(gameStateManager))
            }
        })
        stage.addActor(startButton)

        continueButton.setPosition(100f, 170f)
        continueButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                log.debug("'Continue' clicked")
                //gameStateManager.setState(PlayState(gameStateManager))
            }
        })
        stage.addActor(continueButton)

        settingsButton.setPosition(100f, 140f)
        settingsButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                log.debug("'Settings' clicked")
                //gameStateManager.setState(SettingsState(gameStateManager))
            }
        })
        stage.addActor(settingsButton)

        exitButton.setPosition(100f, 110f)
        exitButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent, x: Float, y: Float) {
                log.debug("'Exit' clicked")
                Gdx.app.exit()
            }
        })
        stage.addActor(exitButton)

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
