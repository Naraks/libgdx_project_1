package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import ru.denko.screens.ScreenManager

class StartMenuScreen(
    val screenManager: ScreenManager
) : Screen {

    private val stage by lazy { Stage() }
    private lateinit var button: TextButton

    override fun show() {
        val skin = Skin(Gdx.files.internal("ui/uiskin.json"))
        button = TextButton("Start", skin)
        button.setPosition(Gdx.graphics.width / 2 - button.width / 2, Gdx.graphics.height / 2 - button.height / 2)
        stage.addActor(button)

        Gdx.input.inputProcessor = stage
    }

    override fun render(delta: Float) {
        stage.draw()
    }

    override fun resize(p0: Int, p1: Int) {

    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun hide() {

    }

    override fun dispose() {
        stage.dispose()
    }
}
