package control;

import android.content.Context;
import DataAccessObject.DataAccessObject;
import model.MLogin;
import valueObject.VLogin;

public class CLogin {

    public boolean getLogin(VLogin vLogin, Context context){
        boolean bResult = false;

        DataAccessObject dataAccessObject = new DataAccessObject();
        MLogin mLogin = dataAccessObject.getLogin(vLogin, context);

        if(mLogin !=null){
            bResult = true;
        }
        return bResult;
    }

    public String foundID(String valueName, String valueNumber, Context context){

        DataAccessObject dataAccessObject = new DataAccessObject();
        String foundID = dataAccessObject.foundID(valueName,valueNumber,context);
        return foundID;
    }



    public String foundPW(String valueUserID, String valueNumber2, Context context){

        DataAccessObject dataAccessObject = new DataAccessObject();
        String foundID = dataAccessObject.foundPW(valueUserID,valueNumber2,context);
        return foundID;
    }
}
