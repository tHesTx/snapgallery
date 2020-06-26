package ro.fmi.snapgallery.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_foto.*
import ro.fmi.snapgallery.R
import ro.fmi.snapgallery.R.drawable.*
import ro.fmi.snapgallery.adapter.MyRecycleAdapter
import ro.fmi.snapgallery.adapter.RecyclerViewAdapter
import ro.fmi.snapgallery.adapter.RecyclerViewData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FotoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FotoFragmentOld : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: MyRecycleAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private var gallery  =  arrayOf(
        ic_home,
    ic_photo_library,
    ic_photo_camera)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            arguments?.let {
                param1 = it.getString(ARG_PARAM1)
                param2 = it.getString(ARG_PARAM2)
            }

            activity?.setTitle("GalleryPage");



            activity?.setContentView(R.layout.fragment_foto)
            layoutManager = LinearLayoutManager(context)
            //viewAdapter = MyAdapter(myDataset)

//            recyclerView = activity?.findViewById<RecyclerView>(R.id.my_recyclerView)!!.apply {
//                // use this setting to improve performance if you know that changes
//                // in content do not change the layout size of the RecyclerView
//                setHasFixedSize(true)
//
//                // use a linear layout manager
//                layoutManager = layoutManager
//
//                // specify an viewAdapter (see also next example)
//                //adapter = viewAdapter
//
//            }

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
        activity?.setContentView(R.layout.activity_main)

        //recyclerView = my_recyclerView
        //layoutManager = GridLayoutManager(context, 2)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setHasFixedSize(true)
        recyclerAdapter  = MyRecycleAdapter(gallery)
        recyclerView.setAdapter(recyclerAdapter)
    }

        companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FotoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FotoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    }

