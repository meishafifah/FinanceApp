package id.meisha.financeapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.Observer
import id.meisha.financeapp.R
import id.meisha.financeapp.database.AppDatabase
import id.meisha.financeapp.databinding.ActivityInputTransactionBinding
import id.meisha.financeapp.databinding.ActivityLoginBinding
import id.meisha.financeapp.entity.Finance

class InputTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputTransactionBinding
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = AppDatabase.getInstance(applicationContext)

        binding.btnSaldo.setOnClickListener {
            val date = binding.etDate.text.toString().trim()
            val transaction = binding.etSaldo.text.toString().trim()
            val status = binding.etStatus.text.toString().trim()
            database.financeDao().addFinance(Finance(
                null,transaction,date,status
            ))

            // Berpindah ke halaman HomeActivity
            val intent = Intent(this@InputTransactionActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}