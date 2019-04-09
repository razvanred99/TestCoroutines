package ro.razvan.testCoroutines.ui.dogsList

import androidx.recyclerview.widget.DiffUtil
import ro.razvan.testCoroutines.data.Dog

class DogDiffCallback : DiffUtil.ItemCallback<Dog>() {

    override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem.id == newItem.id
    }

}