package id.meisha.financeapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import id.meisha.financeapp.entity.Finance
import id.meisha.financeapp.entity.User

@Dao
interface FinanceDao {
    @Query("SELECT * FROM finance")
    fun getAllFinance(): List<Finance>

    @Insert
    fun addFinance(finance: Finance)

    @Delete
    fun deleteFinance(finances: Finance)

    @Update
    fun updateFinance(finances: Finance)

    @Query("SELECT * FROM finance WHERE uid = :uid")
    fun get(uid: String) : Finance
}