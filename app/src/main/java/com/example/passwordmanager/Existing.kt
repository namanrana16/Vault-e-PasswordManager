package com.example.passwordmanager

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.passwordmanager.Data.User
import com.example.passwordmanager.Data.UserDao
import com.example.passwordmanager.Data.UserDatabase
import com.example.passwordmanager.Data.UserViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.logging.Handler

class Existing : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel




  //  var website=""
  //  var username =""
  //  var password = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_existing)






    }


    fun toInfo(view: View) {

        val website = findViewById<EditText>(R.id.editTextWebsite).text.toString()
        val username = findViewById<EditText>(R.id.editTextUsername).text.toString()
        val password  = findViewById<EditText>(R.id.editTextPassword).text.toString()

        // mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        var pass:String?=""

        GlobalScope.launch {
            val db = Room.databaseBuilder(
                applicationContext,
                UserDatabase::class.java, "user_database"
            ).build()
            db.userDao().insert(User(0,website,username,password))
        }

        Toast.makeText(this, "Account Added",Toast.LENGTH_LONG).show()



        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}