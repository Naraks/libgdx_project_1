package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.ScreenUtils
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance
import org.slf4j.LoggerFactory
import ru.denko.settings.Settings

class SettingsState(
    override val di: DI
) : GameState, DIAware {
    private val multiplexer by di.instance<InputMultiplexer>()
    private val prefs by di.instance<PrefInitializer>()
    private val log = LoggerFactory.getLogger(javaClass)

    private val stage by lazy { Stage() }
    private val skin by lazy { Skin(Gdx.files.internal("ui/uiskin.json")) }
    private val table by lazy { Table() }

    init {
        table.x = 100f
        table.y = 100f
        val upLabel = Label("Up: ", skin)
        val upValue = Label(Input.Keys.toString(prefs.settings[Settings.MOVE_UP.name]!!), skin)
        table.add(upLabel).width(upLabel.width).height(upLabel.height)
        table.add(upValue).width(upValue.width).height(upValue.height)

        stage.addActor(table)

        settingsButtons.forEach {
            val button = TextButton(it.text, skin)
            button.setPosition(it.x, it.y)
            button.width = it.width
            button.height = it.height
            button.addListener(object : ClickListener() {
                override fun clicked(event: InputEvent, x: Float, y: Float) {
                    log.debug("'${it.text}' clicked")
                    it.func.invoke(di)
                }
            })
            stage.addActor(button)
        }
    }

    override fun update(dt: Float) {
        // переход в другое состояние
    }

    override fun render(batch: SpriteBatch) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f)
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }

    override fun dispose() {
        skin.dispose()
        stage.dispose()
    }

    override fun addInputProcessor() {
        multiplexer.addProcessor(stage)

        multiplexer.processors.forEach {
            log.debug("InputProcessor: {}", it)
        }
    }

    override fun removeInputProcessor() {
        multiplexer.removeProcessor(stage)
    }

}
