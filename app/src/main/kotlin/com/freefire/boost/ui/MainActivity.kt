package com.freefire.boost.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.freefire.boost.R
import com.freefire.boost.data.local.PreferencesManager
import com.freefire.boost.data.model.PresetDefaults

class MainActivity : AppCompatActivity() {
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferencesManager = PreferencesManager(this)

        setupButtons()
    }

    private fun setupButtons() {
        val btnGraphicsAdjustment: Button = findViewById(R.id.btn_graphics_adjustment)
        val btnPresets: Button = findViewById(R.id.btn_presets)
        val btnSaveProfile: Button = findViewById(R.id.btn_save_profile)
        val btnLoadProfile: Button = findViewById(R.id.btn_load_profile)

        btnGraphicsAdjustment.setOnClickListener {
            startActivity(Intent(this, GraphicsAdjustmentActivity::class.java))
        }

        btnPresets.setOnClickListener {
            startActivity(Intent(this, PresetActivity::class.java))
        }

        btnSaveProfile.setOnClickListener {
            val currentSettings = preferencesManager.getCurrentSettings()
            preferencesManager.savePreset(currentSettings.copy(isCustom = true))
            showToast("Profile saved!")
        }

        btnLoadProfile.setOnClickListener {
            val defaultPreset = PresetDefaults.OPPO_A18_MEDIUM
            preferencesManager.saveCurrentSettings(defaultPreset)
            showToast("Profile loaded!")
        }
    }

    private fun showToast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }
}