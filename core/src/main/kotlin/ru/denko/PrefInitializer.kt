package ru.denko

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import ru.denko.settings.Settings

class PrefInitializer private constructor() {

    companion object {

        @Volatile
        private var instance: PrefInitializer? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: PrefInitializer().also { instance = it; instance!!.initialize() }
        }
    }

    val settings = HashMap<String, Int>()

    private fun initialize() {
        val prefs = Gdx.app.getPreferences("settings")

        settings[Settings.MOVE_UP.name] = prefs.getInteger(Settings.MOVE_UP.name, Input.Keys.W)
        settings[Settings.MOVE_DOWN.name] = prefs.getInteger(Settings.MOVE_DOWN.name, Input.Keys.S)
        settings[Settings.MOVE_RIGHT.name] = prefs.getInteger(Settings.MOVE_RIGHT.name, Input.Keys.D)
        settings[Settings.MOVE_LEFT.name] = prefs.getInteger(Settings.MOVE_LEFT.name, Input.Keys.A)
    }

}
