package com.nero.starx.automatonx.Model;

import java.util.ArrayList;

public class AutomatonState {
    private String name;
    private ArrayList<NextAutomaton> nextStates = null;
    private boolean isFinal ;

    public AutomatonState(){
        this.name = "";
        this.nextStates = new ArrayList<>();
        this.isFinal = false;
    }

    public AutomatonState(String name ,ArrayList<NextAutomaton> nextStates ,boolean isFinal){
        this.name = name;
        this.nextStates = nextStates;
        this.isFinal = isFinal;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<NextAutomaton> getNextStates() {
        return this.nextStates;
    }

    public void setNextStates(ArrayList<NextAutomaton> nextStates) {
        this.nextStates = nextStates;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }
}
