package com.example.google_maps


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latitude  = -7.7526739
        val longitude =110.3540882
        val latKkmac = -7.7523438
        val longKkmac = 110.347322
        val latmd  = -7.7484135
        val longmd = 110.3572248
        val zoomlevel =15f
        val overlaySize =110f

        val uty = LatLng(latitude,longitude )
        mMap.addMarker(MarkerOptions()
            .position(uty).title("Universitas Teknologi Yogyakarta").snippet("-7.7526739,110.3540882").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uty,zoomlevel))

        val kkmac = LatLng(latKkmac,longKkmac)
        mMap.addMarker(MarkerOptions().position(kkmac).title("kupu kupu malam auto costum").snippet("-7.7523438/110.347322").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val md = LatLng(latmd,longmd)
        mMap.addMarker(MarkerOptions().position(md).title("McDonald jombor").snippet("-7.7484135/110.3572248").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val googleOverlay= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.uteye)).position(uty,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

        val googleOverlay2= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.kupumalamcostum)).position(kkmac,overlaySize)
        mMap.addGroundOverlay(googleOverlay2)

        val googleOverlay3= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.md)).position(md,overlaySize)
        mMap.addGroundOverlay(googleOverlay3)



    }

}
