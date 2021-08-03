package DataAccessObject;

import android.content.Context;

import dataBase.UserDatabase;
import model.MLogin;
import model.MUser;
import valueObject.VLogin;

public class DataAccessObject{

    public MUser getUser(String name, String userId, String password, String number, Context context) {
        MUser mUser = new MUser(name, userId, password, number);
        boolean found = mUser.read(context);
        if(found){
            return mUser;
        }
        return null;
    }

    public boolean getCheckID(String userId,Context context){
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        boolean a = userDatabase.getCheckID(userId);
        return a;
    }

    public MLogin getLogin(VLogin vLogin, Context context) {
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        boolean found = userDatabase.getLogin(vLogin);
        MLogin mLogin = new MLogin(vLogin);
        if(found){
            return mLogin;
        }
        return null;
    }

    public String foundID(String valueName, String valueNumber, Context context) {
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        String foundID = userDatabase.foundID(valueName,valueNumber);
        if( foundID != null){
            return foundID;
        }
        return null;
    }

    public String foundPW(String valueUserID, String valueNumber2, Context context) {
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        String foundPW = userDatabase.foundPW(valueUserID,valueNumber2);
        if( foundPW != null){
            return foundPW;
        }
        return null;
    }

    public boolean delete(String id, String password, Context context){
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        boolean delete = userDatabase.delete(id,password);
        return delete;
    }

    public boolean changePW(String id_1, String nowpw_1, String changepw_1, Context context){
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        boolean changePW = userDatabase.changePW(id_1, nowpw_1, changepw_1);
        return changePW;
    }
}







