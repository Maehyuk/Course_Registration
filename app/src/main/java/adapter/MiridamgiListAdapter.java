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
import org.techtown.finalexam.MiridamgiList;
import org.techtown.finalexam.SugangActivity;
import valueObject.VGangjwa;

import java.util.ArrayList;

public class MiridamgiListAdapter extends BaseAdapter {

    Context context;
    ArrayList<VGangjwa> list;
    private MiridamgiList parent;

    public MiridamgiListAdapter(Context context, ArrayList<VGangjwa> list, MiridamgiList miridamgiList){
        this.context =context;
        this.list = list;
        this.parent = miridamgiList;
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
        View v = View.inflate(context, R.layout.item_list3, null);

        TextView id_xml = (TextView) v.findViewById(R.id.id_list2);
        TextView name_xml = (TextView) v.findViewById(R.id.name_list2);
        TextView lecturer_xml = (TextView) v.findViewById(R.id.lecturer_list2);
        TextView credit_xml = (TextView) v.findViewById(R.id.credit_list2);
        TextView time_xml = (TextView) v.findViewById(R.id.time_list2);

        Button deleteButton = (Button)v.findViewById(R.id.deleteButton2);
        Button mmm = (Button)v.findViewById(R.id.mmm);

        id_xml.setText(list.get(position).getId());
        name_xml.setText(list.get(position).getName());
        lecturer_xml.setText(list.get(position).getLecturer());
        credit_xml.setText(list.get(position).getCredit());
        time_xml.setText(list.get(position).getTime());



        v.setTag(list.get(position).getId());


        mmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userId = SugangActivity.userId;
                String id = list.get(position).getId();
                String name = list.get(position).getName();
                String lecturer = list.get(position).getLecturer();
                String credit = list.get(position).getCredit();
                String time = list.get(position).getTime();

                VGangjwa vGangjwa = new VGangjwa(userId,id,name,lecturer,credit,time);

                FinalDatabase finalDatabase = FinalDatabase.getInstance(context, 1);
                finalDatabase.plusSincheong(vGangjwa,userId);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = SugangActivity.userId;
                VGangjwa sub_list = list.get(position);

                list.remove(position);
                MiridamgiListAdapter.this.notifyDataSetChanged();

                FinalDatabase finalDatabase = new FinalDatabase(context, 1);
                finalDatabase.deleteMiridamgi(sub_list,userId);
                Toast.makeText(context,"해당 강좌를 삭제했습니다." , Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
