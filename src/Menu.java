import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Menu {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int inp;
            inp = 0;
            int numberOfTicket;
            numberOfTicket = 0;
            double currentIncome;
            currentIncome = 0;
            double ticketPercentage;
            ticketPercentage = 0;
            int availableSeats;
            availableSeats = 0;
            int numberOfSeats;
            numberOfSeats=0;
            int numberOfAvailableSeats;
            numberOfAvailableSeats = 0;

            //set the numbers of seat row and column
            System.out.println("Enter number of rows ");
            int ofRows = in.nextInt();
            System.out.println("Enter number of columns ");
            int ofColumns = in.nextInt();


            //Set Total Income value
            double totalIncome;
            totalIncome = ofRows * ofColumns * 10;

            //Total number of seats
            numberOfSeats = ofRows * ofRows;

                    //Create Array of seats from ofRows and ofColumns input
            String[][] seats = new String[ofRows][ofColumns];
            for (int i = 0; i < ofRows; i++) {
                for (int j = 0; j < ofColumns; j++) {
                    seats[i][j] = " S ";
                }
            }

            //Create ticket variable
            int numOfRows = 0;
            int numOfColumns = 0;

            //Create Menu options
            do {
                System.out.println("1) Show the seats \n2) Buy a ticket \n3) Statistics \n0) Exit");
                System.out.print("Selection: ");
                inp = in.nextInt();
                switch (inp) {
                    case 1 -> {
                        // Print seats array
                        for (int i = 0; i < ofRows; i++) {
                            for (int j = 0; j < ofColumns; j++) {
                                System.out.print((seats[i][j]));
                            }
                            System.out.println();
                        }

                    }
                    case 2 -> {
                        //Buy ticket and set seat number
                        try{
                            System.out.println("Enter number of rows ");
                            numOfRows = in.nextInt();
                            System.out.println("Enter number of columns ");
                            numOfColumns = in.nextInt();

                            if (seats[numOfRows - 1][numOfColumns - 1] != " B ") {
                                seats[numOfRows - 1][numOfColumns - 1] = " B ";
                                System.out.println("Succesful");
                                numberOfTicket++;
                                currentIncome = numberOfTicket * 10;
                                ticketPercentage = (currentIncome / totalIncome) * 100;


                            } else {
                                System.out.println("That ticket has already been purchased!");
                            }

                        }catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("Wrong input! ");
                        }

                    }
                    case 3 -> {
                        System.out.println("Total number of ticket = " + numberOfTicket);
                        System.out.println("price of ticket = " + "$" + currentIncome);
                        System.out.println("Total income: " + "$"+ totalIncome);
                        DecimalFormat df = new DecimalFormat("###.##");
                        System.out.println("Percentage of seats occupied (DecimalFormat): " + df.format(ticketPercentage) + "%");
                        System.out.println("Total number of seats:" + numberOfSeats);
                        System.out.println("The number of available seats " + (numberOfSeats-numberOfTicket));

                    }
                    case 0 -> System.out.println("Exit");
                    default -> {
                        System.out.println("Please, try again.");
                    }
                }

            } while (inp != 0);
        }catch (InputMismatchException e){

            System.out.println("Invalid Input");
            String[] argss = new String[10];

            main(argss);
        }

    }
}
