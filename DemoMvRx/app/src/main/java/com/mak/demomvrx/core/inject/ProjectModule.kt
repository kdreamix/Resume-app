package com.mak.demomvrx.core.inject

import androidx.room.Room
import com.mak.demomvrx.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val projectModeule = module {
    single { Room.databaseBuilder(
        androidContext(),
        AppDatabase::class.java,
        "projectDb")
//        .addCallback(object: RoomDatabase.Callback() {
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                Executors.newSingleThreadScheduledExecutor()
//                    .execute({populateDatabase() })
//            }
//        } )
        .build().apply {

    }}

    single { (get() as AppDatabase).projectDao() }
}