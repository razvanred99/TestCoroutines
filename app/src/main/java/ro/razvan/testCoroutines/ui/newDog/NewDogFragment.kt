package ro.razvan.testCoroutines.ui.newDog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ro.razvan.testCoroutines.R
import ro.razvan.testCoroutines.databinding.FragmentNewDogBinding

class NewDogFragment : Fragment() {

    private val newDogViewModel: NewDogViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentNewDogBinding.inflate(inflater, container, false).apply {

            setLifecycleOwner(viewLifecycleOwner)

            viewModel = newDogViewModel

            saveClickListener = View.OnClickListener {

                newDogViewModel.viewModelScope.launch {

                    val saved = newDogViewModel.save()

                    it.findNavController().popBackStack()

                    Toast.makeText(it.context, getString(if (saved) R.string.dog_saved_successfully else R.string.error_while_saving), Toast.LENGTH_LONG).show()

                }

            }

        }.root
    }

}