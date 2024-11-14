package Service;

import IRCTC.Train;
import java.util.ArrayList ;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TrainService extends UserService{

    private static List<UserService.Seats> seats = new ArrayList<>();

    public static void initializeSeats() {
        for (int i = 0; i < 31; i++) {
            seats.add(new UserService.Seats(i, true));
        }
    }

    public void displayTrains() {
        UserTrainInfo userTrainInfo = new UserTrainInfo();
        userTrainInfo.TrainList.forEach(System.out::println);
    }

    public  void seatBooking() {
        initializeSeats();
        Scanner scanner = new Scanner(System.in);
        boolean isValidSelection = false;

        while (!isValidSelection) {
            System.out.println("Enter your Block (Front / Middle / Back):");
            String blockSelection = scanner.nextLine();

            try {
                if (blockSelection.equalsIgnoreCase("Front")) {
                    displayWindowAndNonWindowSeats(1, 10, "Front");
                    isValidSelection = true;
                } else if (blockSelection.equalsIgnoreCase("Middle")) {
                    displayWindowAndNonWindowSeats(11, 20, "Middle");
                    isValidSelection = true;
                } else if (blockSelection.equalsIgnoreCase("Back")) {
                    displayWindowAndNonWindowSeats(21 , 30 , "Back") ;
                    isValidSelection = true;
                } else {
                    System.out.println("Invalid block selection. Please enter Front, Middle, or Back.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
            }
            System.out.println("Enter the Seat Number to Book it : ");
            int BookSeat = scanner.nextInt() ;
            scanner.nextLine() ;
            Optional<Seats> FindMatching = seats.stream().filter(t -> t.getSeatNumber() == BookSeat).findFirst();
            if(FindMatching.isPresent()){
                System.out.println("The Seat " + BookSeat + "is Booked Succesfully");
                FindMatching.get().setAvailable(false);
                displayWindowAndNonWindowSeats(1, 10, "Front");
            }

        }
    }

    private static void displayWindowAndNonWindowSeats(int start, int end, String blockName) {
        System.out.println(blockName + " Block - Window Seats:");
        seats.stream()
                .filter(seat -> seat.getSeatNumber() >= start && seat.getSeatNumber() <= end)
                .filter(seat -> seat.getSeatNumber() % 2 != 0)
                .forEach(seat -> System.out.println("Window Seat: " + seat));

        System.out.println(blockName + " Block - Non-Window Seats:");
        seats.stream()
                .filter(seat -> seat.getSeatNumber() >= start && seat.getSeatNumber() <= end)
                .filter(seat -> seat.getSeatNumber() % 2 == 0)
                .forEach(seat -> System.out.println("Non-Window Seat: " + seat));
    }


}