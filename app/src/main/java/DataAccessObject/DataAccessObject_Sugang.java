package DataAccessObject;

import android.content.Context;

import dataBase.FinalDatabase;
import dataBase.SugangDatabase;
import model.MDirectory;
import model.MGangjwa;

import java.util.Vector;

public class DataAccessObject_Sugang {

    public Vector<MDirectory> getDirectory(Context context, String fileName){

        SugangDatabase sugangDatabase = SugangDatabase.getInstance(context);
        Vector<MDirectory> mDirectories = new Vector<MDirectory>();
        mDirectories = sugangDatabase.getDirectory(fileName);

        return mDirectories;
    }

    public Vector<MGangjwa> getGangjwa(Context context, String fileName) {

        SugangDatabase sugangDatabase = SugangDatabase.getInstance(context);
        Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();
        mGangjwas = sugangDatabase.getGangjwa(fileName);
        return  mGangjwas;
    }

    public Vector<MGangjwa> getDataSugangSincheong(Context context, String userId) {

        FinalDatabase finalDatabase = FinalDatabase.getInstance(context, 1);
        Vector<MGangjwa> sVector = new Vector<MGangjwa>();
        sVector = finalDatabase.getDataSugangSincheong(userId);
        return  sVector;
    }

    public Vector<MGangjwa> getDataMiridamgi(Context context, String userId) {

        FinalDatabase finalDatabase = FinalDatabase.getInstance(context, 2);
        Vector<MGangjwa> mVector = new Vector<MGangjwa>();
        mVector = finalDatabase.getDatMiridamgi(userId);
        return  mVector;
    }
}
