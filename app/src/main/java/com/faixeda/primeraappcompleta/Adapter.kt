package com.faixeda.primeraappcompleta
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val itemsList: List<AlumneViewModel>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = itemsList[position]

        // sets the text to the textview from our itemHolder class
        holder.textViewNom.text = ItemsViewModel.nombre

        holder.textViewEdat.text = ItemsViewModel.edad.toString()
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return itemsList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewNom: TextView = itemView.findViewById(R.id.textViewNom)
        val textViewEdat: TextView = itemView.findViewById(R.id.textViewEdat)
    }
}