package net.thumbtack.school.ttschool;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Group {

    private String name, room;
    List<Trainee> list = new ArrayList<>();

    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (StringUtils.isBlank(name))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (StringUtils.isBlank(room))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return list;
    }

    public void addTrainee(Trainee trainee) {
        list.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!list.contains(trainee))
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        list.remove(trainee);
    }

    public void removeTrainee(int index) throws TrainingException {
        if (index > list.size() - 1)
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        list.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for (Trainee trainee : list) {
            if (trainee.getFirstName().equals(firstName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for (Trainee trainee : list) {
            if (trainee.getFullName().equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        list.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        list.sort(Comparator.comparing(Trainee::getRating));
        Collections.reverse(list);
    }

    public void reverseTraineeList() {
        Collections.reverse(list);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(list, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        int max = list.stream()
                .max(Comparator.comparing(Trainee::getRating))
                .orElseThrow(() -> new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND))
                .getRating();
        return list.stream().filter(trainee -> trainee.getRating() == max)
                .collect(Collectors.toList());
    }

    public boolean hasDuplicates() {
        Set unique = new HashSet();
        for (Trainee trainee: list) {
            if (!unique.add(trainee)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(list, group.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, list);
    }
}
