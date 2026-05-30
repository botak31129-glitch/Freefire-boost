package com.freefire.boost.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freefire.boost.R
import com.freefire.boost.data.local.PreferencesManager
import com.freefire.boost.data.model.PresetDefaults
import com.freefire.boost.ui.adapter.PresetAdapter

class PresetActivity : AppCompatActivity() {
    private lateinit var preferencesManager: PreferencesManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var presetAdapter: PresetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset)

        preferencesManager = PreferencesManager(this)

        recyclerView = findViewById(R.id.rv_presets)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val presets = PresetDefaults.getAllPresets()
        presetAdapter = PresetAdapter(presets) { selectedPreset ->
            preferencesManager.saveCurrentSettings(selectedPreset)
            Toast.makeText(this, "Applied: ${selectedPreset.name}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = presetAdapter
    }
}