package com.RaceGardens.Home;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        Scanner sc = new Scanner(System.in);
        List<Integer> choiceList = new ArrayList();
        choiceList.add(1);
        choiceList.add(2);
        choiceList.add(3);
        choiceList.add(4);
        choiceList.add(5);
        choiceList.add(6);
        int choice = 0;
        String sus;
        String cont;
        do {
            System.out.println("Enter your choice based on the options :");
            System.out.println("1. Register yourself");
            System.out.println("2. Book a room");
            System.out.println("3. Check booking status of rooms");
            System.out.println("4. Change/Update your e-mail");
            System.out.println("5. Choose an interval and see all the bookings in that window");
            System.out.println("6. See all registered customer details");
            System.out.println("7. Exit...");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Do you want to continue with this operation ?");
                System.out.println("Press Y or N based on your choice for Yes or No -- ");
                cont = sc.next();
                if (cont.equals("Y")){
                    Register register = new Register();
                    register.register_user();
                }else continue;
                System.out.println("Press enter to continue...");
                try{System.in.read();}catch (Exception e){}
                break;
            case 2:
                System.out.println("Do you want to continue with this operation ?");
                System.out.println("Press Y or N based on your choice for Yes or No -- ");
                cont = sc.next();
                if (cont.equals("Y")){
                    BookRoom bookRoom = new BookRoom();
                    bookRoom.doneBooking();
                }else continue;
                System.out.println("Press enter to continue...");
                try{System.in.read();}catch (Exception e){}
                break;
            case 3:
                System.out.println("Do you want to continue with this operation ?");
                System.out.println("Press Y or N based on your choice for Yes or No -- ");
                cont = sc.next();
                if (cont.equals("Y")){
                    CheckBookingStatus checkBookings = new CheckBookingStatus();
                    checkBookings.check();
                }else continue;
                System.out.println("Press enter to continue...");
                try{System.in.read();}catch (Exception e){}
                break;
            case 4:
                System.out.println("Do you want to continue with this operation ?");
                System.out.println("Press Y or N based on your choice for Yes or No -- ");
                cont = sc.next();
                if (cont.equals("Y")){
                    ChangeEmail changeEmail = new ChangeEmail();
                    changeEmail.changeEmail();
                }else continue;
                System.out.println("Press enter to continue...");
                try{System.in.read();}catch (Exception e){}
                break;
            case 5:
                System.out.println("Do you want to continue with this operation ?");
                System.out.println("Press Y or N based on your choice for Yes or No -- ");
                cont = sc.next();
                if (cont.equals("Y")){
                    CheckBookings checkBookings = new CheckBookings();
                    checkBookings.check();
                }else continue;
                System.out.println("Press enter to continue...");
                try{System.in.read();}catch (Exception e){}
                break;
            case 6:
                System.out.println("Do you want to continue with this operation ?");
                System.out.println("Press Y or N based on your choice for Yes or No -- ");
                cont = sc.next();
                if (cont.equals("Y")){
                    SeeCustomerDetails seeCustomerDetails = new SeeCustomerDetails();
                    seeCustomerDetails.databaseView();
                }else continue;
                System.out.println("Press enter to continue...");
                try{System.in.read();}catch (Exception e){}
                break;
            default:
                System.out.println("Not a valid choice...");
                break;
            }
        }while (choiceList.contains(choice));
    }
}
