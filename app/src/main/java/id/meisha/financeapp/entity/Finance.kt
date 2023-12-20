package id.meisha.financeapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Finance(
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null,

    @ColumnInfo("Saldo")
    var saldo: String? = null,

    @ColumnInfo("Date")
    var date: String? = null,

    @ColumnInfo("Transaction")
    var transaction: String? = null,

    @ColumnInfo("Status")
    var status: String? = null
)
