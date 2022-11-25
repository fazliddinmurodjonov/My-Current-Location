package com.programmsoft.mycurrentlocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import com.programmsoft.mycurrentlocation.databinding.ActivityMapsBinding
import com.programmsoft.room.database.LocationDB

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnPolylineClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    val db = LocationDB.getInstance(App.instance)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))


        // Add polylines to the map.
        // Polylines are useful to show a route or some other connection between points.
        var locationList = ArrayList<LatLng>()
        val allLocationsList = db.locationDao().getAllLocations()
        for (location in allLocationsList) {
            locationList.add(LatLng(location.latitude!!, location.longitude!!))
        }
//        var l1 = LatLng(-35.016, 143.321)
//        var l2 = LatLng(-34.747, 145.592)
//        var l3 = LatLng(-34.364, 147.891)
//        var l4 = LatLng(-33.501, 150.217)
//        var l5 = LatLng(-32.306, 149.248)
//        var l6 = LatLng(-32.491, 147.309)
//        list.add(l1)
//        list.add(l2)
//        list.add(l3)
//        list.add(l4)
//        list.add(l5)
//        list.add(l6)
        val polyline1 = googleMap.addPolyline(PolylineOptions()
            .clickable(true)
            .addAll(locationList))
        // Position the map's camera near Alice Springs in the center of Australia,
        // and set the zoom factor so most of Australia shows on the screen.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(41.311197, 69.279819), 12f))
        // Set listeners for click events.
        googleMap.setOnPolylineClickListener(this)

    }

    override fun onPolylineClick(p0: Polyline) {

    }
}