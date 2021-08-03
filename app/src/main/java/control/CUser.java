package control;

import android.content.Context;

import DataAccessObject.DataAccessObject;
import model.MUser;
import valueObject.VUser;

public class CUser {

    public VUser getUser(String name, String userId, String password, String number, Context context) {
        DataAccessObject dataAccessObject = new DataAccessObject();
        MUser mUser = dataAccessObject.getUser(name, userId, password,number,context);

        if (mUser != null) {
            VUser vUser = new VUser(mUser.getName(), mUser.getUserId(), mUser.getPassword(), mUser.getNumber());
            return vUser;
        }
        return null;
    }

    public boolean getCheckID(String userId, Context context){
        DataAccessObject dataAccessObject = new DataAccessObject();
        boolean a = dataAccessObject.getCheckID(userId,context);
        return a;
    }

    public boolean delete(String id, String password, Context context){
        DataAccessObject dataAccessObject = new DataAccessObject();
        boolean b = dataAccessObject.delete(id,password,context);
        return b;
    }

    public boolean changePW(String id_1, String nowpw_1, String changepw_1, Context context){
        DataAccessObject dataAccessObject = new DataAccessObject();
        boolean changePW = dataAccessObject.changePW(id_1, nowpw_1,changepw_1,context);
        return changePW;
    }
}
