package model;

import android.content.ContentValues;
import android.content.Context;

import dataBase.UserDatabase;


public class MUser{

    private String name;
    private String userId;
    private String password;
    private String number;



    public MUser(String name, String userId, String password, String number) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getNumber() {
        return number;
    }

    public boolean read(Context context) {

        try{
            UserDatabase userDatabase = UserDatabase.getInstance(context);
            ContentValues addRowValue = new ContentValues();

            addRowValue.put("name", name);
            addRowValue.put("userId", userId);
            addRowValue.put("pw", password);
            addRowValue.put("number", number);

            userDatabase.insert(addRowValue);

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}

