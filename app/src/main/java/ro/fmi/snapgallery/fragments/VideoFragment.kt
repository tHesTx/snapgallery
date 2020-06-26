package ro.fmi.snapgallery.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_foto.*
import ro.fmi.snapgallery.R
import ro.fmi.snapgallery.adapter.RecyclerViewAdapter
import ro.fmi.snapgallery.adapter.RecyclerViewData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VideoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideoFragment : Fragment() {
    private val IMAGE_GALLERY_REQ_CODE: Int = 111

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preopenImageGallery()
    }

    private fun preopenImageGallery(){
        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
            type = "image/*"
            startActivityForResult(this, IMAGE_GALLERY_REQ_CODE)
        }
    }
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == IMAGE_GALLERY_REQ_CODE){
            if (data != null && data.data != null) {
                val image = data.data
                val source = ImageDecoder.createSource(activity!!.contentResolver, image!!)
                val bitmap = ImageDecoder.decodeBitmap(source)

                val list = ArrayList<RecyclerViewData>()
                for (i in 0 until 5) {
                    val drawable = when (i % 3) {
                        0 -> R.drawable.ic_android
                        1 -> R.drawable.ic_home
                        else -> R.drawable.ic_photo_camera
                    }
                    //val item = RecyclerViewData(bitmap, "Item $i", "Line 2")
                    //list += item
                }
                //recycler_view.adapter = RecyclerViewAdapter(bitmap)
                recycler_view.layoutManager = LinearLayoutManager(activity)
                recycler_view.setHasFixedSize(true)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VideoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}