package com.rahdeva.bencanaapp.presentation.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.rahdeva.bencanaapp.R
import com.rahdeva.bencanaapp.domain.model.DisasterItems
import com.rahdeva.bencanaapp.databinding.ItemDisasterBinding
import com.rahdeva.bencanaapp.utils.DisasterUtils
import com.rahdeva.bencanaapp.utils.TimeAndDateUtils
import com.rahdeva.bencanaapp.utils.extension.loadImage

class DisasterAdapter(
    private val listDisasterItems: ArrayList<DisasterItems>,
    private val mapFragment: SupportMapFragment,
    private val bottomBehavior: BottomSheetBehavior<LinearLayout>,
    context: Context
) : RecyclerView.Adapter<DisasterAdapter.ListViewHolder>() {

    private val disasterUtils = DisasterUtils(context)

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemDisasterBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_disaster, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val disaster = listDisasterItems[position]
        val disasterRegion = disasterUtils.getRegionString(disaster.disasterProperty?.tags?.instanceRegionCode ?: "")
        val disasterType = disasterUtils.getDisasterType(disaster.disasterProperty?.disasterType)

        val subtitle = TimeAndDateUtils.convertTimeStamp(disaster.disasterProperty?.createdAt ?: "")

        with(holder) {
            binding.apply {
                tvDisasterTitle.text = disasterType
                tvDisasterRegion.text = disasterRegion
                tvDisasterSubtitle.text = subtitle
                ivDisasterImage.loadImage(disasterUtils.getDisasterDefaultImg(disaster.disasterProperty?.disasterType))

                itemDisaster.setOnClickListener {
                    mapFragment.getMapAsync {
                        it.animateCamera(CameraUpdateFactory.zoomOut())
                        it.animateCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    disaster.coordinates?.get(1) ?: 0.0,
                                    disaster.coordinates?.get(0) ?: 0.0
                                ), 10f)
                        )
                        bottomBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    }
                }
            }
        }
    }


    override fun getItemCount(): Int = listDisasterItems.size
}

