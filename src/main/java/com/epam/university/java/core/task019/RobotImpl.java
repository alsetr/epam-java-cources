package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    private RobotPosition position;
    
    @Override
    public RobotPosition getPosition() {
        return position;
    }

    @Override
    public void setPosition(RobotPosition position) {
        this.position = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
    }
}

