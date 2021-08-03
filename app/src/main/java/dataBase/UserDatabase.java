package dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import valueObject.VLogin;

public class UserDatabase {
    static final String DB_LOGIN = "Login.db";
    static final String TABLE_LOGIN = "Login";

    Context myContext = null;

    private static UserDatabase myDBManager = null;
    private SQLiteDatabase mydatabase = null;

    public UserDatabase(Context context) {
        myContext = context;
        mydatabase  = context.openOrCreateDatabase(DB_LOGIN, context.MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE if not exists " + TABLE_LOGIN +
                "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "userId TEXT," +
                "pw TEXT," +
                "number TEXT);");
    }

    public static UserDatabase getInstance(Context context) {
        if(myDBManager == null) {
            myDBManager = new UserDatabase(context);
        }
        return myDBManager;
    }

//    public long insert(ContentValues addRowValue) {
//        return mydatabase.insert(TABLE_LOGIN, null, addRowValue);
//    }

    public boolean getLogin(VLogin vLogin) {

        String sqlSelect = "SELECT * FROM "+TABLE_LOGIN;

        boolean select = false;
        Cursor cursor = null;

        cursor = mydatabase.rawQuery(sqlSelect, null);

        while (cursor.moveToNext()) {
            String dbname = cursor.getString(1);
            String dbuserId = cursor.getString(2);
            String dbpassword = cursor.getString(3);
            String dbnumber = cursor.getString(4);


            if (dbuserId.equals(vLogin.getUserId()) && dbpassword.equals(vLogin.getPassword())) {
                vLogin.setName(dbname);
                vLogin.setNumber(dbnumber);
                select=true;
            }
        }
        return select;
    }

    public boolean getCheckID(String userId) {
        String sqlSelect = "SELECT * FROM " + TABLE_LOGIN;

        boolean select = false;
        Cursor cursor = null;

        cursor = mydatabase.rawQuery(sqlSelect,null);

        while (cursor.moveToNext()){
            String checkid = cursor.getString(2);

            if(checkid.equals(userId)){
                select = true;
            }
        }
        return select;
    }

    public String foundID(String valueName, String valueNumber){
        String sqlSelect = "SELECT * FROM " + TABLE_LOGIN;

        Cursor cursor = null;
        String foundID = null;

        cursor = mydatabase.rawQuery(sqlSelect,null);

        while (cursor.moveToNext()){
            String foundName = cursor.getString(1);
            String foundNumber = cursor.getString(4);

            if(foundName.equals(valueName) && foundNumber.equals(valueNumber)) {
                foundID = cursor.getString(2);

            }
        }
        return foundID;
    }

    public String foundPW(String valueUserID, String valueNumber2){
        String sqlSelect = "SELECT * FROM " + TABLE_LOGIN;

        Cursor cursor = null;
        String foundPW = null;

        cursor = mydatabase.rawQuery(sqlSelect,null);

        while (cursor.moveToNext()){
            String foundUserID = cursor.getString(2);
            String foundNumber = cursor.getString(4);

            if(foundUserID.equals(valueUserID) && foundNumber.equals(valueNumber2)) {
                foundPW = cursor.getString(3);
            }
        }
        return foundPW;
    }

    public boolean delete(String id, String password) {

        String sqlSelect = "SELECT * FROM "+TABLE_LOGIN;

        boolean select = false;
        Cursor cursor = null;

        cursor = mydatabase.rawQuery(sqlSelect, null);

        while (cursor.moveToNext()) {

            String dbuserId = cursor.getString(2);
            String dbpassword = cursor.getString(3);

            if (dbuserId.equals(id) && dbpassword.equals(password)) {
                mydatabase.delete(TABLE_LOGIN, "userId=?", new String[] {id});
                select=true;
            }
        }
        return select;
    }

    public boolean changePW(String id_1, String nowpw_1, String changepw_1){

        String sqlSelect = "SELECT * FROM " + TABLE_LOGIN;

        Cursor cursor = null;
        boolean changePW = false;

        cursor = mydatabase.rawQuery(sqlSelect,null);

        while (cursor.moveToNext()){
            String foundid = cursor.getString(2);
            String foundpw = cursor.getString(3);

            if(foundpw.equals(nowpw_1) && foundid.equals(id_1)) {

                mydatabase.execSQL("UPDATE " + TABLE_LOGIN + " SET pw ="  + changepw_1 + " WHERE userId=" + id_1);
                changePW = true;
            }
        }
        return changePW;
    }

    public long insert(ContentValues addRowValue)
    {
        return mydatabase.insert(TABLE_LOGIN, null, addRowValue);
    }
}