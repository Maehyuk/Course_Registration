package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import dataBase.FinalDatabase;
import org.techtown.finalexam.R;
import org.techtown.finalexam.SincheongList;
import org.techtown.finalexam.SugangActivity;
import valueObject.VGangjwa;

import java.util.ArrayList;

public class SincheongListAdapter extends BaseAdapter {

    Context context;
    ArrayList<VGangjwa> list;
    private SincheongList parent;
    private int hakjum;

    public SincheongListAdapter(Context context, ArrayList<VGangjwa> list, SincheongList sincheongList, int hakjum){
        this.context =context;
        this.list = list;
        this.parent = sincheongList;
        this.hakjum = hakjum;

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
        View v = View.inflate(context, R.layout.item_list2, null);

        TextView id_xml = (TextView) v.findViewById(R.id.id_list);
        TextView name_xml = (TextView) v.findViewById(R.id.name_list);
        TextView lecturer_xml = (TextView) v.findViewById(R.id.lecturer_list);
        TextView credit_xml = (TextView) v.findViewById(R.id.credit_list);
        TextView time_xml = (TextView) v.findViewById(R.id.time_list);

        Button deleteButton = (Button)v.findViewById(R.id.deleteButton);

        id_xml.setText(list.get(position).getId());
        name_xml.setText(list.get(position).getName());
        lecturer_xml.setText(list.get(position).getLecturer());
        credit_xml.setText(list.get(position).getCredit());
        time_xml.setText(list.get(position).getTime());

        v.setTag(list.get(position).getId());

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = SugangActivity.userId;
                VGangjwa sub_list = list.get(position);

                list.remove(position);
                SincheongListAdapter.this.notifyDataSetChanged();


                FinalDatabase finalDatabase = new FinalDatabase(context, 2);
                finalDatabase.deleteSugangSincheong(sub_list,userId);
                Toast.makeText(context,"해당 강좌를 삭제했습니다." , Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
