package id.meisha.financeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import id.meisha.financeapp.R
import id.meisha.financeapp.entity.Finance

class FinanceAdapter(private val context: Context, private var listfinancestory: List<Finance>) : RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>(){

    inner class FinanceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date = view.findViewById<TextView>(R.id.tvDate)
        val transaction = view.findViewById<TextView>(R.id.tvTransaction)
        val image = view.findViewById<TextView>(R.id.ivStatus)
    }

    interface FinanceItemClickInterface {
        fun onDelete(position: Int)
        fun onUpdate(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return FinanceViewHolder(view)
    }

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        holder.date.text = listfinancestory[position].date
        holder.transaction.text = listfinancestory[position].transaction

        val status = listfinancestory[position].status

        val arrowUp = ContextCompat.getDrawable(holder.itemView.context, R.drawable.baseline_arrow_upward_24)
        val arrowDown = ContextCompat.getDrawable(holder.itemView.context, R.drawable.baseline_arrow_downward_24)

        if (status == "Pemasukan" || status == "pemasukan" || status == "PEMASUKAN") {
            holder.image.background = arrowUp
        } else if (status == "Pengeluaran" || status == "pengeluaran" || status == "PENGELUARAN") {
            holder.image.background = arrowDown
        } else {
            Toast.makeText(context, "Masukkan status dengan benar", Toast.LENGTH_LONG).show()
        }


//        holder.hapus.setOnClickListener {
//            bookItemClickInterface.onDelete(position)
//        }
//
//        holder.edit.setOnClickListener {
//            bookItemClickInterface.onUpdate(position)
//        }
    }

    override fun getItemCount(): Int {
        return listfinancestory.size
    }
}