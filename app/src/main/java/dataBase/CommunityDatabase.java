package dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Vector;
import model.MCommunity;


public class CommunityDatabase {
    static final String DB_COMMUNITY = "Community.db";
    static final String TABLE_COMMUNITY = "Community";

    Context myContext = null;

    private static CommunityDatabase myDBManager = null;
    private SQLiteDatabase mydatabase = null;

    public CommunityDatabase(Context context) {
        myContext = context;
        mydatabase  = context.openOrCreateDatabase(DB_COMMUNITY, context.MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE if not exists " + TABLE_COMMUNITY +
                "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "title TEXT," +
                "content TEXT);");
    }

    public static CommunityDatabase getInstance(Context context) {
        if(myDBManager == null) {
            myDBManager = new CommunityDatabase(context);
        }
        return myDBManager;
    }

    public void insert(ContentValues addRowValue)
    {
        mydatabase.insert(TABLE_COMMUNITY, null, addRowValue);
    }

    public Vector<MCommunity> getCommunity() {

        String sqlSelect = "SELECT * FROM "+TABLE_COMMUNITY;

        boolean select = false;
        Cursor cursor = null;


        Vector<MCommunity> comVector = new Vector<MCommunity>();

        cursor = mydatabase.rawQuery(sqlSelect, null);

        while (cursor.moveToNext()) {

            String dbname = cursor.getString(1);
            String dbtitle = cursor.getString(2);
            String dbcontent = cursor.getString(3);

            MCommunity mCommunity = new MCommunity(dbname,dbtitle,dbcontent);

            comVector.add(mCommunity);
        }
        return comVector;
    }

    public void delete(String title){

        String sqlSelect = "SELECT * FROM "+ TABLE_COMMUNITY;

        boolean select = false;
        Cursor cursor = null;

        cursor = mydatabase.rawQuery(sqlSelect, null);

        while (cursor.moveToNext()) {

            String dbtitle = cursor.getString(2);

            if(dbtitle.equals(title)){
                mydatabase.delete(TABLE_COMMUNITY, "title=?", new String[] {title});
            }
        }

    }
}
