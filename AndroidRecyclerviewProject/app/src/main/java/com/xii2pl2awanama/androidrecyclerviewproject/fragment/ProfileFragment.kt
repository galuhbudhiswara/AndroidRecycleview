package com.xii2pl2awanama.androidrecyclerviewproject.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.xii2pl2awanama.androidrecyclerviewproject.LoginActivity
import com.xii2pl2awanama.androidrecyclerviewproject.R
import com.xii2pl2awanama.androidrecyclerviewproject.databinding.FragmentMenuBinding
import com.xii2pl2awanama.androidrecyclerviewproject.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnlogout.setOnClickListener{
            firebaseAuth.signOut()
            val intent = Intent(activity, LoginActivity::class.java)
            activity?.startActivity(intent)
        }

    }
}