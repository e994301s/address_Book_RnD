package DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBHelper extends SQLiteAssetHelper {

    private static final String DB_Name = "SaveBitmap.db";
    private static final int DB_VER = 1;

    private static final String TBL_Name = "Gallery";

    private static final String COL_Data = "Data";

    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_VER);
    }

    public void addBitmap(byte[] image) throws SQLiteException {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_Data, image);
        database.insert(TBL_Name, null, cv);
    }


}
