package id.meisha.financeapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import id.meisha.financeapp.adapter.FinanceAdapter
import id.meisha.financeapp.database.AppDatabase
import id.meisha.financeapp.databinding.ActivityHomeBinding
import id.meisha.financeapp.entity.Finance

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var database: AppDatabase
    private lateinit var financeAdapter: FinanceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, InputTransactionActivity::class.java))
        }

        database = AppDatabase.getInstance(applicationContext)

        val financeList = database.financeDao().getAllFinance()

        // Mendapatkan instance dari FinanceAdapter
        financeAdapter = FinanceAdapter(this, listfinancestory = financeList)

        // Mengatur adapter ke RecyclerView
        binding.rvHistoryTransaction.adapter = financeAdapter
        binding.rvHistoryTransaction.layoutManager = LinearLayoutManager(this)



        // Memuat data dari database dan mengatur ke adapter
//        loadAndSetData()
    }
//    private fun loadAndSetData() {
//        // Mengambil data dari database
//        val financeList = database.financeDao().getAllFinance()
//
//        // Mengatur data ke dalam adapter
//        financeAdapter.updateData(financeList)
//    }
}