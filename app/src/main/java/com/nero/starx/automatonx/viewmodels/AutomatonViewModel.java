package com.nero.starx.automatonx.viewmodels;

import android.content.SharedPreferences;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.Gson;
import com.nero.starx.automatonx.Model.AutomatonState;

import java.util.ArrayList;

public class AutomatonViewModel extends BaseObservable {
    Gson gson = new Gson();
    ArrayList<AutomatonState> states = new ArrayList<>();

    public AutomatonViewModel(){
        for (int i = 0; i < 3 ; i++){
            states.add(new AutomatonState());
        }
    }

    @Bindable
    public String getState1Name(){
        return states.get(0).getName();
    }

    @Bindable
    public String getState2Name(){
        return states.get(1).getName();
    }

    @Bindable
    public String getState3Name(){
        return states.get(2).getName();
    }

    @Bindable
    public boolean getIsFinal1(){
        return states.get(0).isFinal();
    }

    @Bindable
    public boolean getIsFinal2(){
        return states.get(1).isFinal();
    }

    @Bindable
    public boolean getIsFinal3(){
        return states.get(2).isFinal();
    }

    public void setState1Name(String name){
        states.get(0).setName(name);
        notifyPropertyChanged(BR.state1Name);
    }

    public void setState2Name(String name){
        states.get(1).setName(name);
        notifyPropertyChanged(BR.state2Name);
    }

    public void setState3Name(String name){
        states.get(2).setName(name);
        notifyPropertyChanged(BR.state3Name);
    }

    public void setIsFinal1(boolean isFinal){
        states.get(0).setFinal(isFinal);
        notifyPropertyChanged(BR.isFinal1);
    }

    public void setIsFinal2(boolean isFinal){
        states.get(1).setFinal(isFinal);
        notifyPropertyChanged(BR.isFinal2);
    }

    public void setIsFinal3(boolean isFinal){
        states.get(2).setFinal(isFinal);
        notifyPropertyChanged(BR.isFinal3);
    }

    public void storeData(SharedPreferences preferences){
        for(int i = 0; i < 3; i++){
            String data = gson.toJson(this.states.get(i));
            preferences.edit().putString("FIRST_STEP_STATE"+ i , data).apply();
        }


    }

}
