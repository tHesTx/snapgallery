package ro.fmi.snapgallery.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.fragment_home.*
import ro.fmi.snapgallery.R
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private const val REQUEST_TAKE_PHOTO = 111

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var currentPhotoPath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        this.activity?.setTitle("HomePage");
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    /*
        Once you decide the directory for the file, you need to create a collision-resistant file name.
        You may wish also to save the path in a member variable for later use.
        Here's an example solution in a method that returns a unique file name for a new photo using a date-time stamp:
        * */
    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyy.MM.dd").format(Date())
        val storageDir: File? = this.activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "FOTO_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }
    //    With this method available to create a file for the photo, you can now create and invoke the Intent like this:
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_snap.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                // Ensure that there's a camera activity to handle the intent
                this.activity?.packageManager?.let { it1 ->
                    if ((takePictureIntent.resolveActivity(it1) == null) || (takePictureIntent.resolveActivity(it1) != null)) {//altfel nu merge pe emulator, nu are cine trata intentu-ul
                        //takePictureIntent.resolveActivity(it1)?.also {// codul corect care functioneaza pe telefon
                        // Create the File where the photo should go
                        val photoFile: File? = try {
                            createImageFile()
                        } catch (ex: IOException) {
                            // Error occurred while creating the File
                            Toast.makeText(
                                this.activity,
                                "Error occurred while creating the File",
                                Toast.LENGTH_SHORT
                            ).show()
                            null
                        }
                        // Continue only if the File was successfully created
                        photoFile?.also {
                            val photoURI: Uri? = this.context?.let { it2 ->
                                FileProvider.getUriForFile(
                                    it2,
                                    "ro.fmi.snapgallery.fileprovider",
                                    it
                                )
                            }
                            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                        }
                    }
                }
            }
        }
    }
    override fun onActivityResult(requestCode:Int, resultCode: Int, data: Intent?){
        if(requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK){
//            show on preview pannel
            val takenImage = BitmapFactory.decodeFile(currentPhotoPath)
            img_prev.setImageBitmap(takenImage)
//
//            Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).also { mediaScanIntent ->
//                val f = File(currentPhotoPath)
//                mediaScanIntent.data = Uri.fromFile(f)
//                this.activity?.sendBroadcast(mediaScanIntent)
//            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data)
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
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}