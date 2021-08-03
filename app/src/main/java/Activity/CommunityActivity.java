package org.techtown.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

import adapter.CommunityAdapter;
import adapter.ListViewAdapter;
import adapter.SincheongListAdapter;
import control.CCommunity;
import dataBase.CommunityDatabase;
import dataBase.FinalDatabase;
import valueObject.VCommunity;
import valueObject.VGangjwa;

public class CommunityActivity extends AppCompatActivity{

    Button backMenu, write;
    ListView communityList;
    ArrayList<VCommunity> list;
    Vector<VCommunity> vCommunities;

    int count;
    private int click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        backMenu = findViewById(R.id.backMenu);
        write = findViewById(R.id.write);
        communityList = findViewById(R.id.communityList);


        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(intent);
            }
        });

        CCommunity cCommunity = new CCommunity();
        vCommunities = new Vector<VCommunity>();

        vCommunities = cCommunity.getData(getApplicationContext());

        list = new ArrayList<>();
        for (int i = 0; i < vCommunities.size(); i++) {
            list.add(vCommunities.get(i));
        }

        CommunityAdapter communityAdapter = new CommunityAdapter(getApplicationContext(), list, this, click);
        communityList.setAdapter(communityAdapter);

        communityList.setOnItemClickListener(listener);
        communityList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                count = communityAdapter.getCount();

                if(count > 0){
                    if (position > -1 && position < count) {
                        list.remove(position);
                        communityList.clearChoices();
                        communityAdapter.notifyDataSetChanged();

                        CommunityDatabase communityDatabase = new CommunityDatabase(getApplicationContext());
                        communityDatabase.delete(vCommunities.get(position).getTitle());
                        Toast.makeText(getApplicationContext(),"해당 게시물를 삭제했습니다." , Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });
    }



    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            click++;

            Intent intent = new Intent(getApplicationContext(), EssayActivity.class);
            intent.putExtra("title", vCommunities.get(position).getTitle());
            intent.putExtra("content", vCommunities.get(position).getContent());
            intent.putExtra("click", click);

            startActivity(intent);
        }
    };
}
