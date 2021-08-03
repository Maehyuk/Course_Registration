package control;

import android.content.Context;

import DataAccessObject.DataAccessObject_Sugang;
import model.MDirectory;
import valueObject.VDirectory;

import java.util.Vector;

public class CDirectory {

    public CDirectory() {
    }

    public Vector<VDirectory> getData(Context context, String fileName) {
        DataAccessObject_Sugang dataAccessObject_Sugang = new DataAccessObject_Sugang();
        Vector<MDirectory> mDirectories = dataAccessObject_Sugang.getDirectory(context, fileName);

        Vector<VDirectory> vDirectories = new Vector<VDirectory>();
        for(MDirectory mDirectory: mDirectories){
            VDirectory vDirectory = new VDirectory(
            mDirectory.getName(),
            mDirectory.getFileName()
            );
            vDirectories.add(vDirectory);
        }
        return vDirectories;
    }
}
