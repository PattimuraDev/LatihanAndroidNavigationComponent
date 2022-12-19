package com.example.latihanchapter3android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.latihanchapter3android.model.Person
import kotlinx.android.synthetic.main.fragment_fourth.*

/**
 * Kelas untuk menghandle fragment dengan nama FourthFragment
 * @author Dwi Satria Patra
 */
class FourthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back_to_screen_3.setOnClickListener {
            if (screen_4_input_usia.text.isNotEmpty() &&
                screen_4_input_alamat.text.isNotEmpty() &&
                screen_4_input_pekerjaan.text.isNotEmpty()
            ) {
                val nama = arguments?.getString("NAMA")
                val usia = screen_4_input_usia.text.toString()
                val alamat = screen_4_input_alamat.text.toString()
                val pekerjaan = screen_4_input_pekerjaan.text.toString()

                val person = Person(nama, usia, alamat, pekerjaan)
                val personBundle = bundleOf("PERSON" to person)
                Navigation.findNavController(view).navigate(R.id.action_fourthFragment_to_thirdFragment, personBundle)
            }else{
                Toast.makeText(back_to_screen_3.context, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            }
        }


    }
}