package com.freefire.boost.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.freefire.boost.R
import com.freefire.boost.data.model.GraphicsPreset

class PresetAdapter(
    private val presets: List<GraphicsPreset>,
    private val onPresetSelected: (GraphicsPreset) -> Unit
) : RecyclerView.Adapter<PresetAdapter.PresetViewHolder>() {

    inner class PresetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val presetName: TextView = itemView.findViewById(R.id.tv_preset_name)
        private val presetDescription: TextView = itemView.findViewById(R.id.tv_preset_description)
        private val presetDetails: TextView = itemView.findViewById(R.id.tv_preset_details)
        private val btnApplyPreset: Button = itemView.findViewById(R.id.btn_apply_preset)

        fun bind(preset: GraphicsPreset) {
            presetName.text = preset.name
            presetDescription.text = preset.description
            presetDetails.text = "B:${preset.brightness}% C:${preset.contrast}% S:${preset.saturation}% Sh:${preset.sharpness}%"

            btnApplyPreset.setOnClickListener {
                onPresetSelected(preset)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresetViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_preset, parent, false)
        return PresetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PresetViewHolder, position: Int) {
        holder.bind(presets[position])
    }

    override fun getItemCount(): Int = presets.size
}