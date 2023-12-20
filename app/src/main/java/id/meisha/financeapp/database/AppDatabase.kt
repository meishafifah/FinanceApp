package id.meisha.financeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import id.meisha.financeapp.dao.FinanceDao
import id.meisha.financeapp.dao.UserDao
import id.meisha.financeapp.entity.Finance
import id.meisha.financeapp.entity.User


@Database(
    entities = [User::class, Finance::class],
    version = 2,
    exportSchema = true,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun financeDao(): FinanceDao

    companion object{
        private var instance: AppDatabase? = null

        // Tambahkan migrasi jika skema database berubah
        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Implementasikan migrasi sesuai kebutuhan
                // Misalnya, tambahkan kolom baru atau ubah tipe data
            }
        }


        fun getInstance(context: Context): AppDatabase{
            if(instance==null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "DatabaseUser")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}