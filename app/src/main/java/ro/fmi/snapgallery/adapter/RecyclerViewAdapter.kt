package ro.fmi.snapgallery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycleview_layout.view.*
import ro.fmi.snapgallery.R

class RecyclerViewAdapter(private val dataList: List<RecyclerViewData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.recycleview_layout,
            parent, false)
        return RecyclerViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
    }
    override fun getItemCount() = dataList.size

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
    }
}