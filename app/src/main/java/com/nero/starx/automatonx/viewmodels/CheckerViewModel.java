package com.nero.starx.automatonx.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.nero.starx.automatonx.Model.AutomatonState;
import com.nero.starx.automatonx.Model.NextAutomaton;

import java.util.ArrayList;

public class CheckerViewModel extends BaseObservable {
    ArrayList<AutomatonState> states = new ArrayList<>();
    String word = "";
    private boolean isEncluded = false;


    public CheckerViewModel(){
        states.add(TransitionViewModel.state1);
    }

    @Bindable
    public String getWord(){
        return this.word;
    }

    public void setWord(String word){
        this.word = word;
        notifyPropertyChanged(BR.word);
    }

    public void StartOperation(){
        CheckWord(this.word , states.get(0));
    }

    public boolean isEncluded() {
        return isEncluded;
    }

    public void setEncluded(boolean encluded) {
        isEncluded = encluded;
    }

    public ArrayList<AutomatonState> GetNext(String transition , AutomatonState state){
        ArrayList<AutomatonState> Temp = new ArrayList<>();
        if(state.getNextStates() != null) {
            for (int x = 0; x < state.getNextStates().size(); x++) {
                if (state.getNextStates().get(x).getTransition().equals(transition)){
                    Temp.add(state.getNextStates().get(x).getState());
                }
            }
        }
        return Temp;
    }

    public boolean verifyAlphabetExistence(String alphabet , AutomatonState state){
        ArrayList<NextAutomaton> nextList = state.getNextStates();
        boolean Temp = false;
        for (NextAutomaton auto: nextList) {
            if(auto.getTransition().equals(alphabet)){
                Temp = true;
                break;
            }
        }
        return Temp;
    }

    public void CheckWord(String word , AutomatonState state){
        if(word != null && word.length() > 0){
            if(verifyAlphabetExistence( word.substring(0 , 1) , state)){
                ArrayList<AutomatonState> StatesList;
                StatesList = GetNext(word.substring(0 , 1) , state);
                word = word.substring(1);
                for (AutomatonState TransitionStat: StatesList) {
                    if(!isEncluded){
                        CheckWord(word , TransitionStat );
                    }else{
                        break;
                    }
                }
            }
        }else{
            if(state.isFinal()){
                isEncluded = true;
            }
        }
    }
}
