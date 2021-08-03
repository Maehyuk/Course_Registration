package control;

import android.content.Context;
import java.util.Vector;
import DataAccessObject.DataAccessObject_Community;
import model.MCommunity;
import valueObject.VCommunity;


public class CCommunity {

    public Vector<VCommunity> getData(Context context) {
        DataAccessObject_Community dataAccessObject_community = new DataAccessObject_Community();
        Vector<MCommunity> comVector = dataAccessObject_community.getCommunity(context);

        Vector<VCommunity> vCommunities = new Vector<VCommunity>();
        for(MCommunity mCommunity: comVector){
            VCommunity vCommunity = new VCommunity(
                    mCommunity.getName(),
                    mCommunity.getTitle(),
                    mCommunity.getContent()
            );
            vCommunities.add(vCommunity);
        }
        return vCommunities;
    }
}
