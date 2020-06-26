package ro.fmi.snapgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ro.fmi.snapgallery.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val fotoFragment = FotoFragment()
        // val cameraFragment = CameraFragment()
        //val videoFragment = VideoFragment()
        //val galleryFragment = GalleryFragment()
        val shareFragment = ShareFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_photo -> makeCurrentFragment(fotoFragment)
                R.id.ic_share -> makeCurrentFragment(shareFragment)
                //R.id.ic_video -> makeCurrentFragment(videoFragment)
                //R.id.ic_camera -> makeCurrentFragment(cameraFragment)
              // R.id.ic_gallery -> makeCurrentFragment(galleryFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}