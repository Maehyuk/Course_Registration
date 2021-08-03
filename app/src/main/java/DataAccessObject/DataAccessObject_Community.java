package DataAccessObject;

import android.content.Context;

import java.util.Vector;

import dataBase.CommunityDatabase;
import model.MCommunity;

public class DataAccessObject_Community {

    public Vector<MCommunity> getCommunity(Context context){

        CommunityDatabase communityDatabase = CommunityDatabase.getInstance(context);
        Vector<MCommunity> comVector = new Vector<MCommunity>();
        comVector = communityDatabase.getCommunity();

        return comVector;
    }
}
