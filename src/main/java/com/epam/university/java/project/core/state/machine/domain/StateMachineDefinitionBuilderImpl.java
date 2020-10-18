package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

public class StateMachineDefinitionBuilderImpl implements
        StateMachineDefinitionBuilder<BookStatus, BookEvent> {
    private BookStatus from;
    private BookStatus to;
    private BookEvent on;
    private String methodToCall;
    private StateMachineDefinition<BookStatus, BookEvent> stateMachineDefinition =
            new StateMachineDefinitionImpl();

    @Override
    public StateMachineDefinition<BookStatus, BookEvent> build() {
        return stateMachineDefinition;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(
            BookStatus from, BookStatus to, BookEvent on, String method) {
        StateMachineState<BookStatus, BookEvent> state = new StateMachineStateImpl();
        state.setFrom(from);
        state.setTo(to);
        state.setOn(on);
        state.setMethodToCall(method);
        stateMachineDefinition.addState(state);
        return this;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(
            BookStatus from, BookStatus to, BookEvent on) {
        StateMachineState<BookStatus, BookEvent> state = new StateMachineStateImpl();
        state.setFrom(from);
        state.setTo(to);
        state.setOn(on);
        stateMachineDefinition.addState(state);
        return this;
    }
}
