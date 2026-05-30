package com.freefire.boost.data.local

import android.content.Context
import android.content.SharedPreferences
import com.freefire.boost.data.model.GraphicsPreset
import com.freefire.boost.data.model.PresetDefaults

class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("freefire_boost_prefs", Context.MODE_PRIVATE)

    fun savePreset(preset: GraphicsPreset) {
        sharedPreferences.edit().apply {
            putString("preset_${preset.id}_name", preset.name)
            putInt("preset_${preset.id}_brightness", preset.brightness)
            putInt("preset_${preset.id}_contrast", preset.contrast)
            putInt("preset_${preset.id}_saturation", preset.saturation)
            putInt("preset_${preset.id}_sharpness", preset.sharpness)
            putString("preset_${preset.id}_description", preset.description)
            putBoolean("preset_${preset.id}_custom", preset.isCustom)
            apply()
        }
    }

    fun loadPreset(presetId: String): GraphicsPreset? {
        val name = sharedPreferences.getString("preset_${presetId}_name", null) ?: return null
        return GraphicsPreset(
            id = presetId,
            name = name,
            brightness = sharedPreferences.getInt("preset_${presetId}_brightness", 50),
            contrast = sharedPreferences.getInt("preset_${presetId}_contrast", 50),
            saturation = sharedPreferences.getInt("preset_${presetId}_saturation", 50),
            sharpness = sharedPreferences.getInt("preset_${presetId}_sharpness", 50),
            description = sharedPreferences.getString("preset_${presetId}_description", "") ?: "",
            isCustom = sharedPreferences.getBoolean("preset_${presetId}_custom", false)
        )
    }

    fun saveCurrentSettings(preset: GraphicsPreset) {
        sharedPreferences.edit().apply {
            putInt("current_brightness", preset.brightness)
            putInt("current_contrast", preset.contrast)
            putInt("current_saturation", preset.saturation)
            putInt("current_sharpness", preset.sharpness)
            putString("current_preset_id", preset.id)
            apply()
        }
    }

    fun getCurrentSettings(): GraphicsPreset {
        return GraphicsPreset(
            id = sharedPreferences.getString("current_preset_id", "default") ?: "default",
            name = "Current",
            brightness = sharedPreferences.getInt("current_brightness", 50),
            contrast = sharedPreferences.getInt("current_contrast", 50),
            saturation = sharedPreferences.getInt("current_saturation", 50),
            sharpness = sharedPreferences.getInt("current_sharpness", 50),
            description = "Current active settings"
        )
    }

    fun deletePreset(presetId: String) {
        sharedPreferences.edit().apply {
            remove("preset_${presetId}_name")
            remove("preset_${presetId}_brightness")
            remove("preset_${presetId}_contrast")
            remove("preset_${presetId}_saturation")
            remove("preset_${presetId}_sharpness")
            remove("preset_${presetId}_description")
            remove("preset_${presetId}_custom")
            apply()
        }
    }

    fun getAllSavedPresets(): List<GraphicsPreset> {
        val presets = mutableListOf<GraphicsPreset>()
        PresetDefaults.getAllPresets().forEach { preset ->
            loadPreset(preset.id)?.let { presets.add(it) }
        }
        return presets
    }
}