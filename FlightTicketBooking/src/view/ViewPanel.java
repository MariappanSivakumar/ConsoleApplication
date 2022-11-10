package view;

public class ViewPanel {

    public int userView() {
        System.out.println("Enter the Option");
        System.out.println("1. Show Flight             :");
        System.out.println("2. Book Ticket             :");
        System.out.println("3. Show Tickets            :");
        System.out.println("4. Cancel Ticket           :");
        System.out.println("5. List the Flight Rourte  :");
        System.out.println("6. Exit                    :");

        System.out.println("Select any one option...:");
        int userOption = Integer.parseInt(new GetInformation().getString());
        return userOption;
    }

    public int adminView() {
        System.out.println("Enter the Option");
        System.out.println("1. Search Passenger");
        System.out.println("2. Add Flight");
        System.out.println("3. Exit");
        System.out.println("Select any one option...:");
        int adminOption = Integer.parseInt(new GetInformation().getString());
        return adminOption;
    }

    public int callAgainLogin() {
        System.out.println("Enter 1->userLogin 2->exit");
        return Integer.parseInt(new GetInformation().getString());
    }
}
