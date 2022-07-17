package org.profamilia.hc.toolbox.statemachine;

public interface IStateMachineOperator<T> {

    public T getNextState(T previousState, String transition);
    
}
