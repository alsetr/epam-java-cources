package com.epam.university.java.core.task042;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Task042Impl implements Task042 {
    @Override
    public BookingResponse checkAvailability(List<String> schedule, String currentTime) {
        if (schedule == null || currentTime == null) {
            throw new IllegalArgumentException();
        }
        LocalTime current = LocalTime.parse(currentTime, DateTimeFormatter.ofPattern("H:mm"));
        if (current.isAfter(LocalTime.of(17, 59))) {
            return new BusyResponse();
        }
        if (schedule.size() == 0) {
            if (current.isAfter(LocalTime.of(8, 59))
                    && current.isBefore(LocalTime.of(18, 0))) {
                return new AvailableResponse();
            } else {
                if (current.isBefore(LocalTime.of(9, 0))) {
                    current = LocalTime.of(9, 0);
                    String proposal = current.toString();
                    TimeProposalResponse tpr = new TimeProposalResponse();
                    tpr.setProposedTime(proposal);
                    return tpr;
                }
            }
        }
        List<Activity> activities = new ArrayList<>();
        String start;
        String finish;
        for (int i = 0; i < schedule.size(); i++) {
            start = schedule.get(i).substring(0, 5);
            finish = schedule.get(i).substring(6);
            activities.add(new Activity(LocalTime.parse(start, DateTimeFormatter.ofPattern("H:mm")),
                    LocalTime.parse(finish, DateTimeFormatter.ofPattern("H:mm"))));
        }
        Activity currAct;
        for (int i = 0; i < activities.size(); i++) {
            currAct = activities.get(i);
            if (current.isBefore(currAct.getStart())) {
                if (current.isBefore(LocalTime.of(9, 0))) {
                    current = LocalTime.of(9, 0);
                    String proposal = current.toString();
                    TimeProposalResponse tpr = new TimeProposalResponse();
                    tpr.setProposedTime(proposal);
                    return tpr;
                }
                return new AvailableResponse();
            }
            if ((current.isAfter(currAct.getStart()) || current.equals(currAct.getStart()))
                    && current.isBefore(currAct.getFinish())) {
                if (i < activities.size() - 1) {
                    if (!currAct.getFinish().equals(activities.get(i + 1).getStart())) {
                        TimeProposalResponse tpr = new TimeProposalResponse();
                        tpr.setProposedTime(currAct.getFinish().toString());
                        return tpr;
                    } else {
                        current = currAct.getFinish();
                    }
                } else {
                    if (currAct.getFinish().isAfter(LocalTime.of(17, 59))) {
                        return new BusyResponse();
                    } else {
                        TimeProposalResponse tpr = new TimeProposalResponse();
                        tpr.setProposedTime(currAct.getFinish().toString());
                        return tpr;
                    }
                }
            }
        }
        return new AvailableResponse();
    }

    private class Activity {
        private final LocalTime start;
        private final LocalTime finish;

        public Activity(LocalTime start, LocalTime finish) {
            this.start = start;
            this.finish = finish;
        }

        public LocalTime getStart() {
            return start;
        }

        public LocalTime getFinish() {
            return finish;
        }
    }
}
