package dataBase;


import java.util.Vector;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import model.MDirectory;
import model.MGangjwa;

public class SugangDatabase  {

    static final String DB_SUGANG = "SugangDatabase.db";
    Context myContext = null;

    private static SugangDatabase myDBManager = null;
    private SQLiteDatabase mydatabase = null;

    public SugangDatabase(Context context) {

        myContext = context;
        mydatabase  = context.openOrCreateDatabase(DB_SUGANG, context.MODE_PRIVATE,null);
    }

    public static SugangDatabase getInstance(Context context) {
        if(myDBManager == null) {
            myDBManager = new SugangDatabase(context);
        }
        return myDBManager;
    }

    public Vector<MDirectory> getDirectory(String fileName){

        String sql ="SELECT * FROM " + fileName;
        Vector<MDirectory> mDirectories = new Vector<MDirectory>();

        Cursor mCur = mydatabase.rawQuery(sql,null);
        if(mCur != null){
            while(mCur.moveToNext()){
                String name = mCur.getString(1);
                String SelectedfileName = mCur.getString(2);

                MDirectory mDirectory = new MDirectory(name, SelectedfileName);
                mDirectories.add(mDirectory);
            }
        }
        return mDirectories;
    }

    public Vector<MGangjwa> getGangjwa(String fileName){

        String sqlGangjwa ="SELECT * FROM " + fileName;
        Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();

        Cursor mCur = mydatabase.rawQuery(sqlGangjwa,null);
        if(mCur != null){
            while(mCur.moveToNext()){
                 String id= mCur.getString(0);
                 String name_1= mCur.getString(1);
                 String lecturer= mCur.getString(2);
                 String credit= mCur.getString(3);
                 String time= mCur.getString(4);

                MGangjwa mGangjwa = new MGangjwa(id,name_1,lecturer,credit,time);
                mGangjwas.add(mGangjwa);
            }
        }
        return mGangjwas;
    }
}
