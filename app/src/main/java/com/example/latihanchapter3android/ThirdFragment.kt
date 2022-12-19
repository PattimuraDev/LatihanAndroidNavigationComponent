package com.example.latihanchapter3android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.latihanchapter3android.model.Person
import kotlinx.android.synthetic.main.fragment_third.*

/**
 * Kelas untuk menghandle fragment dengan nama ThirdFragment
 * @author Dwi Satria Patra
 */
class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments?.containsKey("PERSON")!!){
            val person = arguments?.getParcelable<Person>("PERSON")
            val nama = person?.nama
            val usia = person?.usia
            val alamat = person?.alamat
            val pekerjaan = person?.pekerjaan
            val ganjilGenap = if(usia?.toInt()!!.rem(2) == 0){
                "Genap"
            }else{
                "Ganjil"
            }
            val result = "$nama\n" +
                    "$usia, $ganjilGenap\n" +
                    "$alamat\n" +
                    "$pekerjaan"
            output.text = result
        }else{
            val nama = arguments?.getString("NAMA")
            output.text = nama
        }

        go_to_screen_4.setOnClickListener {
            val nama = if(arguments?.containsKey("PERSON")!!){
                arguments?.getParcelable<Person>("PERSON")?.nama
            }else{
                arguments?.getString("NAMA")
            }
            val bundleNama = bundleOf("NAMA" to nama)
            Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_fourthFragment, bundleNama)
        }
    }
}