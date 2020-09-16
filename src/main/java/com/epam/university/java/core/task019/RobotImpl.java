package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    private RobotPosition position = new RobotPositionImpl();
    // directionInd give a direction of robot. If 0 - Up, 1 - right, 2 - down, 3 - left.
    private int directionInd = 0;


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
        if (command == RobotCommand.TURN_LEFT) {
            directionInd -= 1;
            if (directionInd < 0) {
                directionInd = 3;
            }
        } else if (command == RobotCommand.TURN_RIGHT) {
            directionInd += 1;
            if (directionInd > 3) {
                directionInd = 0;
            }
        } else {
            switch (directionInd) {
                case 0:
                    position.setY(position.getY() + 1);
                    break;
                case 1:
                    position.setX(position.getX() + 1);
                    break;
                case 2:
                    position.setY(position.getY() - 1);
                    break;
                case 3:
                    position.setX(position.getX() - 1);
                    break;
                default:
                    break;
            }
        }
    }
}

