import java.util.Scanner;

public class EmergencySystem {
    public static void menudisplay() {
        System.out.println("Connecting to 911..............."
                + "Welcome to 911 service! Please press 1 for Normal 911 and press 2 for Enhanced 911");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Phone # to dial");
        String Phone = in.next();
        menudisplay();
        int i = in.nextInt();
        if (i == 1) {
            in.hasNextLine();
            System.out.println("This is 911,Please report your issue");
            String issue = in.next();
            in.hasNextLine();
            System.out.println("Okay.. now please tell me your name");
            String name = in.next();
            in.hasNextLine();
            System.out.println("Umm ok.. now tell your exact location please");
            String loc = in.next();
            in.hasNextLine();

            N911 c1 = new N911(name, loc, Phone, issue);
            System.out.println(c1);

        } else if (i == 2) {
            System.out.println("This is 911,Please report your issue");
            String issue = in.next();
            in.hasNextLine();
            System.out.println("Umm ok.. now tell your exact location please");
            String loc = in.next();
            in.hasNextLine();
            Emergency c2 = new E911(loc, Phone, issue);
            System.out.println(c2);
        }

        if (in != null)
            in.close();
    }
}

class Emergency {
    String callername;
    String location;
    String phoneNumber;
    String problem;
    boolean police, ambulance, firefighters;

    public Emergency() {
    }

    public Emergency(String name, String location, String phoneNumber, String instr) {
        this.callername = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.problem = instr;

    }

    public void setName(String caller) {
        this.callername = caller;
    }

    public String getName() {
        return callername;
    }

    public void setPN(String PN) {
        this.phoneNumber = PN;
    }

    public String getPN() {
        return this.phoneNumber;
    }

    public void setProblem(String instruction) {
        this.problem = instruction;
    }

    public String getInst() {
        return this.problem;

    }

    public void Options() {
        System.out.println("The situation was not identified!");
        System.out.println("Press 1 for Ambulance.");
        System.out.println("Press 2 for Police.");
        System.out.println("Press 3 for Fire Fighters.");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        if (i == 1)
            System.out.println("We have dispached an ambulance for " + location
                    + ", please hold on. Help will be there in a moment.");
        if (i == 2)
            System.out.println("We have dispached the Police for " + location
                    + ", please hold on. Help will be there in a moment.");
        if (i == 3)
            System.out.println("We have dispached FireFighters for " + location
                    + ", please hold on. Help will be there in a moment.");

        in.close();
    }

    public void Situation1() {
        if (problem.contains("accident") || problem.contains("bleeding") || problem.contains("injured")) {
            System.out.println("Mr./Ms. " + callername + " called from: " + phoneNumber
                    + " and reported an Accident at " + location);
            System.out.println(
                    "We are sending you appropriate support. Please confirm that the Ambulance is the required service? (yes/no)");
            Scanner in = new Scanner(System.in);
            String option = in.next();
            if (option.equals("yes") || option.equals("Yes")) {
                System.out.println("We have dispached an ambulance for " + location
                        + ", please hold on. Help will be there in a moment.");
            } else if (option.equals("no") || option.equals("No")) {
                Options();
            }
            in.close();
        } else if (problem.contains("crime") || problem.contains("killing") || problem.contains("theft")
                || problem.contains("Robbery")) {
            System.out.println(
                    "Mr./Ms. " + callername + " called from: " + phoneNumber + " and reported a Crime at " + location);
            System.out.println(
                    "We are sending you appropriate support. Please confirm that the Police is the required service? (yes/no)");
            Scanner in = new Scanner(System.in);
            String option = in.next();
            if (option.equals("yes") || option.equals("Yes")) {
                System.out.println("We have dispached the Police for " + location
                        + ", please hold on. Help will be there in a moment.");
            } else if (option.equals("no") || option.equals("No")) {
                Options();
            }
            in.close();
        } else if (problem.contains("fire") || problem.contains("burn")) {
            System.out.println(
                    "Mr./Ms. " + callername + " called from: " + phoneNumber + " and reported a Fire at " + location);
            System.out.println(
                    "We are sending you appropriate support. Please confirm that the FireFighters is the required service? (yes/no)");
            Scanner in = new Scanner(System.in);
            String option = in.next();
            if (option.equals("yes") || option.equals("Yes")) {
                System.out.println("We have dispached FireFighters for " + location
                        + ", please hold on. Help will be there in a moment.");
            } else if (option.equals("no") || option.equals("No")) {
                Options();
            }
            in.close();
        } else
            Options();
    }

    // Situation 2 for Enhanced 911
    public void Situation2() {
        if (problem.contains("accident") || problem.contains("hh") || problem.contains("Accident")) {
            System.out.println("An Accident is being reported at " + location + ", by " + phoneNumber);
            System.out.println(
                    "We are sending you appropriate support. Please confirm that the Ambulance is the required service? (yes/no)");
            Scanner in = new Scanner(System.in);
            String option = in.next();
            if (option.equals("yes") || option.equals("Yes")) {
                System.out.println("We have dispached an ambulance for " + location
                        + ", please hold on. Help will be there in a moment.");
            } else if (option.equals("no") || option.equals("No")) {
                Options();
            }
            in.close();
        } else if (problem.contains("crime") || problem.contains("theft") || problem.contains("robbery")
                || problem.contains("stole") || problem.contains("killing")) {
            System.out.println("A Crime is being reported at " + location + ", by " + phoneNumber);
            System.out.println(
                    "We are sending you appropriate support. Please confirm that the Police is the required service? (yes/no)");
            Scanner in = new Scanner(System.in);
            String option = in.next();
            if (option.equals("yes") || option.equals("Yes")) {
                System.out.println("We have dispached the Police for " + location
                        + ", please wait. Help will be there in a moment.");
            } else if (option.equals("no") || option.equals("No")) {
                Options();
            }
            in.close();
        } else if (problem.contains("fire") || problem.contains("smoke") || problem.contains("burn")
                || problem.contains("flames")) {
            System.out.println("A Fire is being reported at " + location + ", by " + phoneNumber);
            System.out.println(
                    "We are sending you appropriate support. Please confirm that the FireFighters is the required service? (yes/no)");
            Scanner in = new Scanner(System.in);
            String option = in.next();
            if (option.equals("yes") || option.equals("Yes")) {
                System.out.println("We have dispached FireFighters for " + location
                        + ", please wait. Help will be there in a moment.");
            } else if (option.equals("no") || option.equals("No")) {
                Options();
            }

            in.close();
        } else
            Options();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Emergency{" + "name=" + callername + ", address=" + location + ", PhNum=" + phoneNumber + '}';
    }
}

class N911 extends Emergency {
    public N911() {

    }

    public N911(String caller, String location, String phone, String instr) {
        super(caller, location, phone, instr);
        super.Situation1();
    }
}

class E911 extends Emergency {

    public E911(String address, String PhNum, String emergency) {
        super.setLocation(address);
        super.setPN(PhNum);
        super.setProblem(emergency);
        super.Situation2();
    }

}