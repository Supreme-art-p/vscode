package Service;

import IRCTC.Train;
import IRCTC.User;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class UserTrainInfo {
    ArrayList<User> UserList = new ArrayList<>(List.of(
            new User("John Doe", 101, "12345678"),
            new User("Jane Smith", 102, "password456"),
            new User("Robert Brown", 103, "password789")
    )) ;

    ArrayList<Train> TrainList = new ArrayList<>(List.of(
            new Train("Express Train", 101, LocalDateTime.of(2024, 11, 11, 15, 30)),
            new Train("Superfast Train", 102, LocalDateTime.of(2024 , 12 , 1 ,12,32)),
            new Train("Local Train", 103, LocalDateTime.of(2024, 11, 11, 18, 45)),
            new Train("Night Express", 104, LocalDateTime.of(2024, 11, 11, 22, 00))
    )) ;
}
