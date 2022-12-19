package com.example.latihanchapter3android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * Kelas untuk menghandle fragment dengan nama SecondFragment
 * @author Dwi Satria Patra
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        go_to_screen_3.setOnClickListener {
            if(screen_2_input_nama.text.isNotEmpty()){
                val bundleNama = bundleOf("NAMA" to screen_2_input_nama.text.toString())
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment, bundleNama)
            }else{
                Toast.makeText(go_to_screen_3.context, "Field nama harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}