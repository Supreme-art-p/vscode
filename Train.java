package IRCTC;

import java.time.*;
import java.util.*;

public class Train {
    private String TrainName;
    private int TrainId;
    private LocalDateTime TrainTimes;


    public Train(String trainName, int trainId, LocalDateTime trainTimes) {
        this.TrainName = trainName;
        this.TrainId = trainId;
        this.TrainTimes = trainTimes;
    }

    public String getTrainName() {
        return TrainName;
    }

    public void setTrainName(String trainName) {
        this.TrainName = trainName;
    }

    public int getTrainId() {
        return TrainId;
    }

    public void setTrainId(int trainId) {
        this.TrainId = trainId;
    }

    public LocalDateTime getTrainTimes() {
        return TrainTimes;
    }

    public void setTrainTimes(LocalDateTime trainTimes) {
        this.TrainTimes = trainTimes;
    }
}
