package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.view.ActionMode;

import org.techtown.finalexam.CommunityActivity;
import org.techtown.finalexam.MainActivity;
import org.techtown.finalexam.R;

import java.util.ArrayList;

import valueObject.VCommunity;

public class CommunityAdapter extends BaseAdapter {

    Context context;
    ArrayList<VCommunity> list;
    private CommunityActivity parent;
    private int click;

    public CommunityAdapter(Context context, ArrayList<VCommunity> list, CommunityActivity parent, int click) {
        this.context =context;
        this.list = list;
        this.parent= parent;
        this.click= click;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, R.layout.item_community, null);

        TextView namename = (TextView) v.findViewById(R.id.namename);
        TextView titletitle = (TextView) v.findViewById(R.id.titletitle);

        namename.setText(list.get(position).getName());
        titletitle.setText(list.get(position).getTitle());

        v.setTag(list.get(position).getName());
        return v;
    }

}


