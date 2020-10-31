package com.mbds.newsletter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mbds.newsletter.MainActivity
import com.mbds.newsletter.changeFragment
import com.mbds.newsletter.databinding.FragmentAcceuilBinding
import com.mbds.newsletter.fragments.categories.CategoriesFragment
import com.mbds.newsletter.fragments.categories.CountryFragment
import com.mbds.newsletter.fragments.categories.EditorFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AcceuilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AcceuilFragment(private val activityRoot: MainActivity): Fragment() {

    lateinit var binding: FragmentAcceuilBinding

    var sampleImages = arrayOf(
        "https://www.instinct-voyageur.fr/wp-content/uploads/2015/07/pays-du-monde.jpg",
        "https://www.alain-bensoussan.com/wp-content/uploads/2017/07/28168347.jpg",
        "https://les-petits-curieux.fr/wp-content/uploads/2020/01/HEADER-700x140px_Plan-de-travail-1-copie-2.jpeg"
    )


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAcceuilBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_acceuil, container, false)
       binding.openCategory.setOnClickListener {
           activityRoot.changeFragment(
               CategoriesFragment(
                   activityRoot
               )
           )
       }
        //bouton country
        binding.openByCountry.setOnClickListener {
            activityRoot.changeFragment(
                CountryFragment(
                    activityRoot
                )
            )
        }
        //bouton editor
        binding.openByEditor.setOnClickListener {
            activityRoot.changeFragment(
                EditorFragment(
                    activityRoot
                )
            )
        }
        return binding.root
    }



}