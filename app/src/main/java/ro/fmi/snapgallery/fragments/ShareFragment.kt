package ro.fmi.snapgallery.fragments

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_share.*
import ro.fmi.snapgallery.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShareFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShareFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        activity?.setTitle("SharePage");
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView1.setImageResource(R.drawable.img1)
        imageView2.setImageResource(R.drawable.img2)

//        val res: Resources = resources
//        val drawable: Drawable = res.getDrawable(R.drawable.img1)
val img1 =Uri.parse("android.resource://ro.fmi.cnapgallery"+R.drawable.img1)
val img2 =Uri.parse("android.resource://ro.fmi.cnapgallery"+R.drawable.img2)

        shareBtn.setOnClickListener{
           // val imageUris: ArrayList<Uri> = arrayListOf(
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
            Toast.makeText(
                this.activity,
                "Nu am reusit implementarea...",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShareFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShareFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}