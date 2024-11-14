    package Service;


    import IRCTC.User;


    import java.util.* ;
    public class UserService{

        public static class Seats{
            private int seatNumber ;
            private boolean available  ;

            public Seats( int seatName,boolean isAvilable ) {
                this.seatNumber = seatName ;
                this.available = isAvilable ;
            }

            public int getSeatNumber() {
                return seatNumber;
            }

            public boolean isAvailable() {
                return available;
            }

            public void setAvailable(boolean available) {
                this.available = available;
            }
            @Override
            public String toString() {
                return "Seat " + seatNumber + " - " + (available ? "Available" : "Booked");
            }
        }

        public void Signup() {
            Scanner sn = new Scanner(System.in);

            System.out.print("Enter the Username: ");
            String NewUserName = sn.nextLine();

            Random random = new Random();
            int userId = random.nextInt(10000);

            System.out.println("Your ID is: " + userId);

            System.out.print("Enter your Password: ");
            String NewPassword = sn.nextLine();

            UserTrainInfo uif = new UserTrainInfo();
            uif.UserList.add(new User(NewUserName, userId, NewPassword));
            System.out.println("You succesfully Logged in as " + NewUserName);


        }


        public void Login(){
            Scanner scanner = new Scanner(System.in) ;
                    System.out.print("Enter your Username: ");
                    String ProvidedUserName = scanner.nextLine();

                    System.out.print("Enter your ID: ");
                    int ProvidedId = scanner.nextInt();

                    scanner.nextLine() ;

                    boolean isLogin = false ;
                    while(!isLogin){
                        System.out.print("Enter the Password: ");
                        String providedPassword = scanner.nextLine();

                        if(providedPassword.length() < 8){
                            System.out.println("the password must be more than 8 words Re-Enter it : ");

                        }else{
                            isLogin = true ;
                            UserTrainInfo userTrainInfo = new UserTrainInfo() ;
                            Optional<User> SearchUser = userTrainInfo.UserList.stream()
                                    .filter(t -> t.getName().equalsIgnoreCase(ProvidedUserName)
                                            && t.getId() == ProvidedId
                                            && t.getPassword().equalsIgnoreCase(providedPassword)).findFirst() ;

                            if(SearchUser.isPresent()){
                                System.out.println("Logged in Successfully as " + ProvidedUserName);
                            }
                            else {
                                System.out.println("You haven't created account :");

                            }
                        }
                    }

        }
        private List<Seats> seats = new ArrayList<>();
        public void DisplayUsers(){
            UserTrainInfo userTrainInfo = new UserTrainInfo() ;
            userTrainInfo.UserList.stream().forEach(System.out::println);
        }

        public void InitalizingSeats(){
            for(int i = 0 ; i < 31 ; i++){
                seats.add(new Seats(i , true)) ;
            }
        }

    }

