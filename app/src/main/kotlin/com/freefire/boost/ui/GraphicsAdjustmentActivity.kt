package com.freefire.boost.ui

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.freefire.boost.R
import com.freefire.boost.data.local.PreferencesManager
import com.freefire.boost.data.model.GraphicsPreset

class GraphicsAdjustmentActivity : AppCompatActivity() {
    private lateinit var preferencesManager: PreferencesManager
    private var currentPreset: GraphicsPreset? = null

    private lateinit var brightnessSlider: SeekBar
    private lateinit var contrastSlider: SeekBar
    private lateinit var saturationSlider: SeekBar
    private lateinit var sharpnessSlider: SeekBar

    private lateinit var brightnessValue: TextView
    private lateinit var contrastValue: TextView
    private lateinit var saturationValue: TextView
    private lateinit var sharpnessValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graphics_adjustment)

        preferencesManager = PreferencesManager(this)
        currentPreset = preferencesManager.getCurrentSettings()

        initializeViews()
        setupSliders()
        setupButtons()
        loadCurrentSettings()
    }

    private fun initializeViews() {
        brightnessSlider = findViewById(R.id.slider_brightness)
        contrastSlider = findViewById(R.id.slider_contrast)
        saturationSlider = findViewById(R.id.slider_saturation)
        sharpnessSlider = findViewById(R.id.slider_sharpness)

        brightnessValue = findViewById(R.id.tv_brightness_value)
        contrastValue = findViewById(R.id.tv_contrast_value)
        saturationValue = findViewById(R.id.tv_saturation_value)
        sharpnessValue = findViewById(R.id.tv_sharpness_value)
    }

    private fun setupSliders() {
        brightnessSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                brightnessValue.text = "$progress%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        contrastSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                contrastValue.text = "$progress%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        saturationSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                saturationValue.text = "$progress%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        sharpnessSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                sharpnessValue.text = "$progress%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun setupButtons() {
        val btnApply: Button = findViewById(R.id.btn_apply)
        val btnReset: Button = findViewById(R.id.btn_reset)

        btnApply.setOnClickListener {
            val newPreset = GraphicsPreset(
                id = currentPreset?.id ?: "current",
                name = "Current Settings",
                brightness = brightnessSlider.progress,
                contrast = contrastSlider.progress,
                saturation = saturationSlider.progress,
                sharpness = sharpnessSlider.progress,
                description = "Custom adjusted settings"
            )
            preferencesManager.saveCurrentSettings(newPreset)
            Toast.makeText(this, "Settings applied!", Toast.LENGTH_SHORT).show()
        }

        btnReset.setOnClickListener {
            loadCurrentSettings()
            Toast.makeText(this, "Settings reset!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadCurrentSettings() {
        currentPreset?.let {
            brightnessSlider.progress = it.brightness
            contrastSlider.progress = it.contrast
            saturationSlider.progress = it.saturation
            sharpnessSlider.progress = it.sharpness

            brightnessValue.text = "${it.brightness}%"
            contrastValue.text = "${it.contrast}%"
            saturationValue.text = "${it.saturation}%"
            sharpnessValue.text = "${it.sharpness}%"
        }
    }
}