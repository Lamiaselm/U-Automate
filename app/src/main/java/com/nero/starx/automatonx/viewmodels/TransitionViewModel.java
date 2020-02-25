package com.nero.starx.automatonx.viewmodels;

import android.content.SharedPreferences;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.Gson;
import com.nero.starx.automatonx.Model.AutomatonState;
import com.nero.starx.automatonx.Model.NextAutomaton;

import java.util.ArrayList;

public class TransitionViewModel extends BaseObservable {
    private ArrayList<AutomatonState> states = new ArrayList<>();
    ArrayList<AutomatonState> resultStates = new ArrayList<>();
    static AutomatonState state1;
    String[][] TransitionMatrix = new String[3][3];
    Gson gson = new Gson();

    public TransitionViewModel(SharedPreferences prefs){
        for(int i = 0; i < 3 ; i++){
            String data = prefs.getString("FIRST_STEP_STATE" + i, "");
            states.add(gson.fromJson(data , AutomatonState.class));
        }
    }

    public ArrayList<AutomatonState> getStates() {
        return states;
    }

    public void setStates(ArrayList<AutomatonState> states) {
        this.states = states;
    }


    //Matrix elements are the automaton transitions
    //11
   @Bindable
    public String getTransition11(){
        return this.TransitionMatrix[0][0];
   }

   public void setTransition11(String name){
        this.TransitionMatrix[0][0] = name;
        notifyPropertyChanged(BR.transition11);
   }

   //12
    @Bindable
    public String getTransition12(){
        return this.TransitionMatrix[0][1];
    }

    public void setTransition12(String name){
        this.TransitionMatrix[0][1] = name;
        notifyPropertyChanged(BR.transition12);
    }

    //13
    @Bindable
    public String getTransition13(){
        return this.TransitionMatrix[0][2];
    }

    public void setTransition13(String name){
        this.TransitionMatrix[0][2] = name;
        notifyPropertyChanged(BR.transition13);
    }

    //21
    @Bindable
    public String getTransition21(){
        return this.TransitionMatrix[1][0];
    }

    public void setTransition21(String name){
        this.TransitionMatrix[1][0] = name;
        notifyPropertyChanged(BR.transition21);
    }

    //22
    @Bindable
    public String getTransition22(){
        return this.TransitionMatrix[1][1];
    }

    public void setTransition22(String name){
        this.TransitionMatrix[1][1] = name;
        notifyPropertyChanged(BR.transition22);
    }

    //23
    @Bindable
    public String getTransition23(){
        return this.TransitionMatrix[1][2];
    }

    public void setTransition23(String name){
        this.TransitionMatrix[1][2] = name;
        notifyPropertyChanged(BR.transition23);
    }

    //31
    @Bindable
    public String getTransition31(){
        return this.TransitionMatrix[2][0];
    }

    public void setTransition31(String name){
        this.TransitionMatrix[2][0] = name;
        notifyPropertyChanged(BR.transition31);
    }

    //32
    @Bindable
    public String getTransition32(){
        return this.TransitionMatrix[2][1];
    }

    public void setTransition32(String name){
        this.TransitionMatrix[2][1] = name;
        notifyPropertyChanged(BR.transition32);
    }

    //33
    @Bindable
    public String getTransition33(){
        return this.TransitionMatrix[2][2];
    }

    public void setTransition33(String name){
        this.TransitionMatrix[2][2] = name;
        notifyPropertyChanged(BR.transition33);
    }

    public void emergeData(SharedPreferences prefs){

        for(int i = 0; i < states.size() ; i++){
            ArrayList<NextAutomaton> autoNext = new ArrayList<>();
            for(int j = 0; j < states.size() ; j++){
                if(TransitionMatrix[i][j] != null){
                    if(TransitionMatrix[i][j].length() > 1){
                        for(int x = 0 ; x < TransitionMatrix[i][j].length(); x++){
                            autoNext.add(new NextAutomaton(states.get(j) , TransitionMatrix[i][j].substring(x , x+1)));
                        }
                    }else{
                        autoNext.add(new NextAutomaton(states.get(j) , TransitionMatrix[i][j]));
                    }
                }
            }
            states.get(i).setNextStates(autoNext);
        }
        saveData(prefs);
    }

    public void saveData(SharedPreferences prefs){
        state1 = states.get(0);
    }

}
