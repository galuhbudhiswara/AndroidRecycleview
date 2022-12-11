package com.xii2pl2awanama.androidrecyclerviewproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.xii2pl2awanama.androidrecyclerviewproject.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var  binding: ActivitySignupBinding
    private  lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.txtgoback.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnsignup.setOnClickListener{
            val email= binding.emailSignUp.text.toString()
            val password= binding.passwordSignUp.text.toString()
            val confrimPass= binding.confrimpassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confrimPass.isNotEmpty()){
                if (password == confrimPass){

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Baris tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
