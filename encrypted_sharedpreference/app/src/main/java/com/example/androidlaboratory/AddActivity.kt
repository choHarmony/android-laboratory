package com.example.androidlaboratory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.androidlaboratory.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val masterKeyAlias = MasterKey
            .Builder(applicationContext, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        val pref = EncryptedSharedPreferences.create(
            this,
            "encrypted_memo_file",
            masterKeyAlias,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        binding.btnAddComplete.setOnClickListener {
            val title = binding.editKey.text.toString()
            val content = binding.editContent.text.toString()
            pref.edit().putString(title, content).apply()

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("title", title)
                putExtra("content", content)
            }
            Toast.makeText(this, pref.getString(title, "").toString(), Toast.LENGTH_SHORT).show()
            setResult(RESULT_OK, intent)
            if(!isFinishing) finish()
        }

    }
}