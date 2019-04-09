package ro.razvan.testCoroutines.ui.dogsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ro.razvan.testCoroutines.data.Dog
import ro.razvan.testCoroutines.databinding.FragmentDogBinding

class DogsAdapter(private val callback: (View) -> Unit) : ListAdapter<Dog, DogsAdapter.ViewHolder>(DogDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FragmentDogBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), View.OnClickListener(callback))
    }

    inner class ViewHolder(private val binding: FragmentDogBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Dog, clickListener: View.OnClickListener) {
            with(binding) {
                this.item = item
                this.clickListener = clickListener
                executePendingBindings()
            }
        }

    }

}