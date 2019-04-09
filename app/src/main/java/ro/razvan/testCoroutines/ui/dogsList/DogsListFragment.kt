package ro.razvan.testCoroutines.ui.dogsList

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ro.razvan.testCoroutines.R
import ro.razvan.testCoroutines.data.Dog
import ro.razvan.testCoroutines.databinding.FragmentDogsListBinding

class DogsListFragment : Fragment() {

    private val dogsListViewModel: DogsListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val dogsAdapter = DogsAdapter {
            AlertDialog.Builder(it.context)
                    .setTitle(R.string.delete)
                    .setMessage(R.string.delete_dog_confirmation)
                    .setPositiveButton(android.R.string.yes) { dialog, _ ->
                        dogsListViewModel.viewModelScope.launch {
                            val success = dogsListViewModel.deleteDog(it.tag as Dog)
                            Toast.makeText(it.context, if (success) R.string.dog_deleted_successfully else R.string.error_while_deleting, Toast.LENGTH_SHORT).show()
                        }
                        dialog.dismiss()
                    }
                    .setNeutralButton(android.R.string.cancel) { dialog, _ -> dialog.dismiss() }
                    .show()
        }

        return FragmentDogsListBinding.inflate(inflater, container, false).apply {

            setLifecycleOwner(viewLifecycleOwner)

            dogsListViewModel.dogs.observe(viewLifecycleOwner, Observer {
                hasElements = it.isNotEmpty()
            })

            addDogListener = View.OnClickListener {
                findNavController().navigate(DogsListFragmentDirections.actNewDog())
            }

            content.recycler.adapter = dogsAdapter
            content.recycler.layoutManager = LinearLayoutManager(content.recycler.context)

            subscribeDogs(dogsAdapter)

        }.root
    }

    private fun subscribeDogs(adapter: DogsAdapter) {
        dogsListViewModel.dogs.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}