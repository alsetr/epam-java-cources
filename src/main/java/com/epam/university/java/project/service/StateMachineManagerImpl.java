package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StateMachineManagerImpl implements StateMachineManager {
    StateMachineDefinition<BookStatus, BookEvent> stateMachineDefinition;
    BookStateMachineHandler handler = new BookStateMachineHandler();

    @Override
    public StateMachineDefinition<BookStatus, BookEvent> loadDefinition(Resource resource) {
        File file = resource.getFile();
        StateMachineDefinitionImpl definition = null;
        try {
            JAXBContext context = JAXBContext.newInstance(StateMachineDefinitionImpl.class);
            definition = (StateMachineDefinitionImpl) context
                    .createUnmarshaller().unmarshal(new FileReader(file));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        stateMachineDefinition = definition;
        return definition;
    }

    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity,
                                                        StateMachineDefinition<S, E> definition) {
        entity.setStateMachineDefinition(definition);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        Book book = (Book) entity;
        switch ((BookEvent) event) {
            case ACCEPT:
                handler.onAccept(book);
                break;
            case ISSUE:
                handler.onIssue(book);
                break;
            case RETURN:
                handler.onReturn(book);
                break;
            case CREATE:
                handler.create(book);
                break;
            default:
                System.out.println("Event not found.");
                break;
        }
        return (StatefulEntity<S, E>) book;
    }
}
