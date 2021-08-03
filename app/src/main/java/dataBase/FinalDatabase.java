package dataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import model.MGangjwa;
import valueObject.VGangjwa;

import java.util.Vector;


public class FinalDatabase {

    static final String Final_SUGANG = "sincheong.db";
    public String TableName = "sincheong_table";

    Context myContext = null;

    private static FinalDatabase myDBManager = null;
    private SQLiteDatabase mydatabase = null;

    public static FinalDatabase getInstance(Context context, Integer number) {
        if (myDBManager == null && context != null) {
            myDBManager = new FinalDatabase(context, number);
        }
        return myDBManager;
    }


    public FinalDatabase(Context context, Integer number) {


        if (number == 2) {
            TableName = "miriDamgi_table";
        }

        if(context != null){
            myContext = context;

            mydatabase = context.openOrCreateDatabase(Final_SUGANG, context.MODE_PRIVATE, null);

            mydatabase.execSQL("CREATE TABLE if not exists " + TableName +
                    "(" + "userId String," +
                    "ID TEXT," +
                    "name TEXT," +
                    "lecturer TEXT," +
                    "credit TEXT," +
                    "time TEXT)");
        }

    }

    public void plusSincheong(VGangjwa vGangjwa, String userId) {
        String id = vGangjwa.getId();
        String name = vGangjwa.getName();
        String lecturer = vGangjwa.getLecturer();
        String credit = vGangjwa.getCredit();
        String time = vGangjwa.getTime();

        String sql = "SELECT * FROM sincheong_table WHERE userID='"
                + userId + "' AND ID= '" + id + "' AND name= '" + name + "'";

        Cursor cursor;

        cursor = mydatabase.rawQuery(sql, null);

        if(cursor.getCount() == 0 ){
            mydatabase.execSQL("INSERT INTO sincheong_table VALUES " +
                    "('" + userId + "', '" + id + "', '" + name +"', '" +
                    lecturer + "', '" + credit +"', '" + time +"');");
            Toast.makeText(myContext, "해당강좌 신청 완료했습니다" ,Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(myContext, "이미 신청된 강좌입니다." ,Toast.LENGTH_SHORT).show();
        }
    }

    public void plusMiridamgi(VGangjwa vGangjwa, String userId) {
        String id = vGangjwa.getId();
        String name = vGangjwa.getName();
        String lecturer = vGangjwa.getLecturer();
        String credit = vGangjwa.getCredit();
        String time = vGangjwa.getTime();

        String sql = "SELECT * FROM miriDamgi_table WHERE userID='"
                + userId + "' AND id= '" + id + "' AND name= '" + name + "'";

        Cursor cursor;

        cursor = mydatabase.rawQuery(sql, null);

        if(cursor.getCount() == 0 ){
            mydatabase.execSQL("INSERT INTO miriDamgi_table VALUES " +
                    "('" + userId + "', '" + id + "', '" + name +"', '" +
                    lecturer + "', '" + credit +"', '" + time +"');");
            Toast.makeText(myContext, "해당강좌 미리담기 완료했습니다" ,Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(myContext, "이미 장바구니에 담긴 강좌입니다." ,Toast.LENGTH_SHORT).show();
        }
    }
    public Vector<MGangjwa> getDataSugangSincheong(String userId){
        Vector<MGangjwa> sVector = new Vector<MGangjwa>();

        String sql = "SELECT ID, name, lecturer, credit, time " + "FROM sincheong_table " + "WHERE userID='" + userId + "'";

        Cursor cursor = null;
        cursor = mydatabase.rawQuery(sql, null);

        while(cursor.moveToNext()){
            String a = cursor.getString(0);
            String b = cursor.getString(1);
            String c = cursor.getString(2);
            String d = cursor.getString(3);
            String e = cursor.getString(4);

            MGangjwa mGangjwa = new MGangjwa(a,b,c,d,e);
            sVector.add(mGangjwa);
        }
        return sVector;
    }

    public Vector<MGangjwa> getDatMiridamgi(String userId) {
        Vector<MGangjwa> mVector = new Vector<MGangjwa>();

        String sql = "SELECT ID, name, lecturer, credit, time " + "FROM miriDamgi_table " + "WHERE userID='" + userId + "'";

        Cursor cursor = null;
        cursor = mydatabase.rawQuery(sql, null);

        while(cursor.moveToNext()){
            String a = cursor.getString(0);
            String b = cursor.getString(1);
            String c = cursor.getString(2);
            String d = cursor.getString(3);
            String e = cursor.getString(4);

            MGangjwa mGangjwa = new MGangjwa(a,b,c,d,e);
            mVector.add(mGangjwa);
        }
        return mVector;
    }

    public void deleteSugangSincheong(VGangjwa vGangjwa, String userId){

        String id = vGangjwa.getId();
        String name = vGangjwa.getName();

        mydatabase.execSQL("DELETE FROM sincheong_table " +
                "WHERE userId='" + userId + "' AND id ='" +id+"' AND name ='" + name + "'");

    }

    public void deleteMiridamgi(VGangjwa vGangjwa, String userId){

        String id = vGangjwa.getId();
        String name = vGangjwa.getName();

        mydatabase.execSQL("DELETE FROM miriDamgi_table " +
                "WHERE userId='" + userId + "' AND id ='" +id+"' AND name ='" + name + "'");
    }
}

