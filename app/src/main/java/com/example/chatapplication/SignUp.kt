package com.example.chatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    private lateinit var edtname: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassworld: EditText
    private lateinit var btnSignUp: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        edtname = findViewById(R.id.edt_name)
        edtEmail = findViewById(R.id.edt_email)
        edtPassworld = findViewById(R.id.edt_passworld)
        btnSignUp = findViewById(R.id.btnSignUp)


        btnSignUp.setOnClickListener {
            val name = edtname.text.toString()
            val email = edtEmail.text.toString()
            val passworld = edtPassworld.text.toString()

            signUp(name,email,passworld)
        }
    }
    private fun signUp(name:String,email:String,passworld:String) {
        //loging for creting user
        mAuth.createUserWithEmailAndPassword(email, passworld)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //code for jumping to home
                    addUserToDataBase(name,email,mAuth.currentUser?.uid!!)
                    val intent = Intent(this@SignUp,MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUp,"Some Error occurred", Toast.LENGTH_SHORT).show()

                }
            }
    }
    private fun addUserToDataBase(name: String,email: String,uid:String) {
        mDbRef = FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(User(name,email,uid))

    }
}