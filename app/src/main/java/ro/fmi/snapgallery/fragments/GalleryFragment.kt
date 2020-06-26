package ro.fmi.snapgallery.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_gallery.*
import ro.fmi.snapgallery.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GalleryFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        activity?.setTitle("GalleryFragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    //@RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //queryImageStorage()

        share_btn.setOnClickListener{
            imageView1.setImageResource(R.drawable.ic_android)
            imageView2.setImageResource(R.drawable.img2)
        }

//        val imageUris: ArrayList<Uri> = arrayListOf(
//            // Add your image URIs here
//            imageUri1,
//            imageUri2
//        )
//
//        val shareIntent = Intent().apply {
//            action = Intent.ACTION_SEND_MULTIPLE
//            putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris)
//            type = "image/*"
//        }
//        startActivity(Intent.createChooser(shareIntent, "Share images to.."))

    }
/*
    @RequiresApi(Build.VERSION_CODES.Q)
    private fun queryImageStorage() {

        val imageProjection = arrayOf(
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.DATE_TAKEN,
            MediaStore.Images.Media._ID
        )

        //val imageSortOrder = "${MediaStore.Images.Media.EXTERNAL_CONTENT_URI} DESC"
//        val imagePath = File(activity?.getFilesDir(), "/storage/emulated/0/Android/data/ro.fmi.snapgallery/files/Pictures")
//        val imagePath = "ro.fmi.snapgallery.fileprovider/images/"
//        val newFile = File(imagePath, "default_image.jpg")
//        val contentUri =  getUriForFile(context!!, "ro.fmi.snapgallery.fileprovider", newFile)
        val contextURI = FileProvider.getUriForFile(context!!, "ro.fmi.snapgallery.fileprovider",  File("/storage/emulated/0/Android/data/ro.fmi.snapgallery/files/Pictures/FOTO_2020.06.26_1513146314375381586.jpg"))
        File("/storage/emulated/0/Android/data/ro.fmi.snapgallery/files/Pictures/").walk().forEach {
            println(it.absoluteFile)
        }


        val cursor = activity?.contentResolver?.query(
            //MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//            //contextURI,
            MediaStore.Images.Media.getContentUri("/storage/emulated/0/Android/data/ro.fmi.snapgallery/files/Pictures/"),
            //"/storage/emulated/0/Android/data/ro.fmi.snapgallery/files/Pictures",
            imageProjection,
            null,
            null,
            null
        )

        cursor.use {
            it?.let {
                val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                val nameColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
                val sizeColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)
                val dateColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_TAKEN)

                while (it.moveToNext()) {
                    val id = it.getLong(idColumn)
                    val name = it.getString(nameColumn)
                    val size = it.getString(sizeColumn)
                    val date = it.getString(dateColumn)

                    val contentUri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        id
                    )
                    // add the URI to the list
                    // generate the thumbnail
                    val thumbnail = context?.contentResolver?.loadThumbnail(contentUri, Size(480, 480), null)

                }
            } ?: kotlin.run {
                Log.e("TAG", "Cursor is null!")
            }
        }
    }

 */

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
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}