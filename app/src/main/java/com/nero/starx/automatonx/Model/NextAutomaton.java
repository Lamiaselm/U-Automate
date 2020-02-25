package com.nero.starx.automatonx.Model;

public class NextAutomaton {
    private AutomatonState state;
    private String transition;

    public NextAutomaton(){}
    public NextAutomaton(AutomatonState state, String transition){
        this.state = state;
        this.transition = transition;
    }

    public AutomatonState getState() {
        return state;
    }

    public void setState(AutomatonState state) {
        this.state = state;
    }

    public String getTransition() {
        return transition;
    }

    public void setTransition(String transition) {
        this.transition = transition;
    }
}
