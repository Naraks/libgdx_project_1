package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import org.kodein.di.DI
import org.kodein.di.DIAware
import ru.denko.settings.Settings

class PrefInitializer(
    override val di: DI
) : DIAware {

    val settings = HashMap<String, Int>()

    init {
        val prefs = Gdx.app.getPreferences("settings")

        settings[Settings.MOVE_UP.name] = prefs.getInteger(Settings.MOVE_UP.name, Input.Keys.W)
        settings[Settings.MOVE_DOWN.name] = prefs.getInteger(Settings.MOVE_DOWN.name, Input.Keys.S)
        settings[Settings.MOVE_RIGHT.name] = prefs.getInteger(Settings.MOVE_RIGHT.name, Input.Keys.D)
        settings[Settings.MOVE_LEFT.name] = prefs.getInteger(Settings.MOVE_LEFT.name, Input.Keys.A)
    }

}
