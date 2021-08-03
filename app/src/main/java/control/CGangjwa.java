package control;

import android.content.Context;

import DataAccessObject.DataAccessObject_Sugang;
import model.MGangjwa;
import valueObject.VGangjwa;

import java.util.Vector;

public class CGangjwa {

    public Vector<VGangjwa> getData(Context context, String fileName) {
        DataAccessObject_Sugang dataAccessObject_sugang = new DataAccessObject_Sugang();
        Vector<MGangjwa> mGangjwas = dataAccessObject_sugang.getGangjwa(context, fileName);

        Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
        for (MGangjwa mGangjwa: mGangjwas) {
            VGangjwa vGangjwa = new VGangjwa(
                    mGangjwa.getId(),
                    mGangjwa.getName(),
                    mGangjwa.getLecturer(),
                    mGangjwa.getCredit(),
                    mGangjwa.getTime()
            );
            vGangjwas.add(vGangjwa);
        }
        return vGangjwas;
    }

    public Vector<VGangjwa> getDataSugangSincheong(Context context, String userId) {

        DataAccessObject_Sugang dataAccessObject_sugang = new DataAccessObject_Sugang();
        Vector<MGangjwa> mGangjwas = dataAccessObject_sugang.getDataSugangSincheong(context, userId);

        Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
        for (MGangjwa mGangjwa: mGangjwas) {
            VGangjwa vGangjwa = new VGangjwa(
                    mGangjwa.getId(),
                    mGangjwa.getName(),
                    mGangjwa.getLecturer(),
                    mGangjwa.getCredit(),
                    mGangjwa.getTime()
            );
            vGangjwas.add(vGangjwa);
        }
        return  vGangjwas;
    }

    public Vector<VGangjwa> getDataMiridamgi(Context context, String userId) {

        DataAccessObject_Sugang dataAccessObject_sugang = new DataAccessObject_Sugang();
        Vector<MGangjwa> mGangjwas = dataAccessObject_sugang.getDataMiridamgi(context, userId);

        Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
        for (MGangjwa mGangjwa: mGangjwas) {
            VGangjwa vGangjwa = new VGangjwa(
                    mGangjwa.getId(),
                    mGangjwa.getName(),
                    mGangjwa.getLecturer(),
                    mGangjwa.getCredit(),
                    mGangjwa.getTime()
            );
            vGangjwas.add(vGangjwa);
        }
        return  vGangjwas;
    }
}
