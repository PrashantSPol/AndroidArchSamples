package com.polstech.library.androidarchsamples.data.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by prashant.pol on 4/15/2018.
 */

@Entity(tableName = "tab_quote")
public class Quote {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "quote_message")
    public String quoteMessage;
}
