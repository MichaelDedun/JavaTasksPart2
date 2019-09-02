package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Wrong Firstname"),
    TRAINEE_WRONG_LASTNAME("Wrong Lastname"),
    TRAINEE_WRONG_RATING("Wrong rating"),
    GROUP_WRONG_NAME("Wrong name"),
    GROUP_WRONG_ROOM("Wrong room"),
    TRAINEE_NOT_FOUND("Trainee not found"),
    SCHOOL_WRONG_NAME("Wrong name"),
    DUPLICATE_GROUP_NAME("Duplicate group"),
    GROUP_NOT_FOUND("Not found"),
    DUPLICATE_TRAINEE("Duplicate trainee"),
    EMPTY_TRAINEE_QUEUE("Empty queue");


    private String errorCode;

    TrainingErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
