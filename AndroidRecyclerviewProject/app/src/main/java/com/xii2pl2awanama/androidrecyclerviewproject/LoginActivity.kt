package com.xii2pl2awanama.androidrecyclerviewproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.xii2pl2awanama.androidrecyclerviewproject.databinding.ActivityLoginBinding
import com.xii2pl2awanama.androidrecyclerviewproject.splash.LoadingsplashActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding .inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth= FirebaseAuth.getInstance()
        binding.textView.setOnClickListener {
            val intent= Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }
        binding.btnlogin.setOnClickListener {
            val email= binding.emailSignUp.text.toString()
            val password= binding.passwordSignUp.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this, LoadingsplashActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this, "Baris tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }



//        val inputUsername: EditText = findViewById(R.id.emailSignUp)
//        val inputPassword: EditText = findViewById(R.id.passwordSignUp)
//        val btnLogin: Button = findViewById(R.id.btnlogin)
//        val toast = Toast.makeText(this, "Password atau Email anda salah", Toast.LENGTH_SHORT)
//
//        btnLogin.setOnClickListener {
//            var Username= inputUsername.text.toString()
//            var Password= inputPassword.text.toString()
//
//            if (Username == "galuh" && Password == "idk999") startActivity(Intent(this, MenuActivity::class.java))
//            else toast.show()
//        }

        val join: TextView = findViewById(R.id.join)
        join.setOnClickListener {
            val intent= Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null ){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
