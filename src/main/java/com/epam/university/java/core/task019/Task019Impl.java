package com.epam.university.java.core.task019;

public class Task019Impl implements Task019 {
    @Override
    public void invokeAction(Robot robot, RobotCommand command) {
        if (robot == null || command == null) {
            throw new IllegalArgumentException();
        }
        robot.invokeAction(command);
    }

    @Override
    public boolean isOnStartPosition(Robot robot) {
        if (robot == null) {
            throw new IllegalArgumentException();
        }
        RobotPosition position = robot.getPosition();
        int posX = position.getX();
        int posY = position.getY();
        return (posX == 0 && posY == 0);
    }
}
