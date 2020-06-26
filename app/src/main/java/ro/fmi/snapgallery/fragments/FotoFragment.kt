package ro.fmi.snapgallery.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_foto.*
import ro.fmi.snapgallery.R
import ro.fmi.snapgallery.adapter.RecyclerViewAdapter
import ro.fmi.snapgallery.adapter.RecyclerViewData
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FotoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val GET_IMG_CODE = 222
class FotoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            arguments?.let {
                param1 = it.getString(ARG_PARAM1)
                param2 = it.getString(ARG_PARAM2)
            }

            activity?.setTitle("GalleryPage");

        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_foto, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exampleList = generateDummyList(20)
        recycler_view.adapter = RecyclerViewAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<RecyclerViewData> {
        val list = ArrayList<RecyclerViewData>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_home
                else -> R.drawable.ic_photo_camera
            }
            val item = RecyclerViewData(drawable, "Item $i", "Line 2")
            list += item
        }
        //val item2 = FileProvider.getUriForFile(context!!, "ro.fmi.snapgallery.fileprovider",  File("/storage/emulated/0/Android/data/ro.fmi.snapgallery/files/Pictures/FOTO_2020.06.26_1513146314375381586.jpg"))

        return list
    }
}

