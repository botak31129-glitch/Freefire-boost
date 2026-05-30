package com.freefire.boost.data.model

data class GraphicsPreset(
    val id: String,
    val name: String,
    val brightness: Int,      // 0-100
    val contrast: Int,        // 0-100
    val saturation: Int,      // 0-100
    val sharpness: Int,       // 0-100
    val description: String,
    val isCustom: Boolean = false
)

// Preset defaults untuk berbagai device
object PresetDefaults {
    val OPPO_A18_LOW = GraphicsPreset(
        id = "oppo_a18_low",
        name = "Oppo A18 - Low",
        brightness = 60,
        contrast = 50,
        saturation = 70,
        sharpness = 40,
        description = "Low performance mode untuk Oppo A18"
    )

    val OPPO_A18_MEDIUM = GraphicsPreset(
        id = "oppo_a18_medium",
        name = "Oppo A18 - Medium",
        brightness = 75,
        contrast = 60,
        saturation = 85,
        sharpness = 60,
        description = "Medium balance mode untuk Oppo A18"
    )

    val OPPO_A18_HIGH = GraphicsPreset(
        id = "oppo_a18_high",
        name = "Oppo A18 - High",
        brightness = 85,
        contrast = 70,
        saturation = 95,
        sharpness = 75,
        description = "High quality mode untuk Oppo A18"
    )

    val OPPO_A18_ULTRA = GraphicsPreset(
        id = "oppo_a18_ultra",
        name = "Oppo A18 - Ultra",
        brightness = 95,
        contrast = 80,
        saturation = 100,
        sharpness = 90,
        description = "Ultra performance mode untuk Oppo A18"
    )

    val DEFAULT = GraphicsPreset(
        id = "default",
        name = "Default",
        brightness = 50,
        contrast = 50,
        saturation = 50,
        sharpness = 50,
        description = "Default graphics settings"
    )

    fun getAllPresets() = listOf(
        OPPO_A18_LOW,
        OPPO_A18_MEDIUM,
        OPPO_A18_HIGH,
        OPPO_A18_ULTRA,
        DEFAULT
    )
}