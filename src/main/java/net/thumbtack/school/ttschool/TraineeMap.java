package net.thumbtack.school.ttschool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeMap {

    Map<Trainee,String> map;
    public TraineeMap() {
        this.map = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (map.containsKey(trainee))
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        map.put(trainee,institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (!map.containsKey(trainee))
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        map.replace(trainee,institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (!map.containsKey(trainee))
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        map.remove(trainee);
    }

    public int getTraineesCount() {
        return map.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (!map.containsKey(trainee))
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        return map.get(trainee);
    }

    public Set<Trainee> getAllTrainees() {
        return map.keySet();
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(map.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return map.containsValue(institute);
    }


}
