package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dataBase.FinalDatabase;
import org.techtown.finalexam.R;
import org.techtown.finalexam.SugangActivity;
import valueObject.VGangjwa;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {


    Context context;
    ArrayList<VGangjwa> list;
    private SugangActivity parent;

    public ListViewAdapter(Context context, ArrayList<VGangjwa> list, SugangActivity pDirectory) {
        this.context =context;
        this.list = list;
        this.parent= pDirectory;
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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        convertView = inflater.inflate(R.layout.item_list, null);

        View v = View.inflate(context, R.layout.item_list, null);

        TextView id_xml = (TextView) v.findViewById(R.id.id_list);
        TextView name_xml = (TextView) v.findViewById(R.id.name_list);
        TextView lecturer_xml = (TextView) v.findViewById(R.id.lecturer_list);
        TextView credit_xml = (TextView) v.findViewById(R.id.credit_list);
        TextView time_xml = (TextView) v.findViewById(R.id.time_list);


        Button sincheong = (Button) v.findViewById(R.id.Sincheong);
        Button miridamgi = (Button) v.findViewById(R.id.deleteButton);

        id_xml.setText(list.get(position).getId());
        name_xml.setText(list.get(position).getName());
        lecturer_xml.setText(list.get(position).getLecturer());
        credit_xml.setText(list.get(position).getCredit());
        time_xml.setText(list.get(position).getTime());

        v.setTag(list.get(position).getId());

        sincheong.setOnClickListener(new View.OnClickListener() {
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


        miridamgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userId = SugangActivity.userId;
                String id = list.get(position).getId();
                String name = list.get(position).getName();
                String lecturer = list.get(position).getLecturer();
                String credit = list.get(position).getCredit();
                String time = list.get(position).getTime();

                VGangjwa vGangjwa = new VGangjwa(userId,id,name,lecturer,credit,time);
                FinalDatabase finalDatabase = FinalDatabase.getInstance(context, 2);
                finalDatabase.plusMiridamgi(vGangjwa,userId);
            }
        });

        return v;
    }
}
