import java.util.Scanner;

    public class Main {
    public static void main(String[] args) {

        String runAgain = "y";
        Scanner scan = new Scanner(System.in);
        Database database = new Database();

        System.out.println("-----Velkommen til superhelte databasen-----");

        while (runAgain.equalsIgnoreCase("y")) {

            System.out.println("---Start menu---");
            System.out.println( "Tryk 1: Opret ny superhelt\n" +
                                "Tryk 2: Vis superhelte liste\n" +
                                "Tryk 3: Søg efter superhelt\n" +
                                "Tryk 9: Afslut programmet");

            int startInput = scan.nextInt();

            if (startInput == (1)) {

                System.out.print("Indtast navn på superhelten: ");
                String nameSuperheroxd = scan.nextLine(); //  Scanner bug. Virker når jeg har en overflødig scanner.
                String nameSuperhero = scan.nextLine();

                System.out.print("Indtast superheltens rigtige navn: ");
                String realNameSuperhero = scan.nextLine();

                System.out.print("Indtast superheltens superkraft: ");
                String superpowerSuperhero = scan.nextLine();

                System.out.print("Indtast superheltens alder: ");
                int ageSuperhero = scan.nextInt();

                System.out.print("Indtast superheltens styrkeniveau 1-9999: ");
                int strengthSuperhero = scan.nextInt();

                System.out.print("Er superhelten et menneske? [y/n] ");

                String userInput = scan.next();
                boolean isHumanSuperhero = false; /* Lokale variabler skal have en værdi, derfor gives
                                                  "false" som default */
                if (userInput.equalsIgnoreCase("Y")) {
                    isHumanSuperhero = true;
                } else if (userInput.equalsIgnoreCase("n")) {
                    isHumanSuperhero = false;
                }

                database.addSuperhero(nameSuperhero, realNameSuperhero,
                        superpowerSuperhero, ageSuperhero, strengthSuperhero,
                        isHumanSuperhero);

                System.out.println("Superhelt tilføjet til databasen.");

                System.out.print("Tilbage til start menuen? [y/n] ");
                runAgain = scan.next();

            } else if (startInput == 2) {
                System.out.println(database.superheroList);
                System.out.print("Tilbage til start menuen? [y/n] ");
                runAgain = scan.next();

            } else if (startInput == 3) {
                System.out.print("Indtast søgning: ");
                String søgning = scan.next();
                System.out.println(database.findSuperhero(søgning));
                System.out.print("Tilbage til start menuen? [y/n] ");
                runAgain = scan.next();


            } else if (startInput == 9) {
                System.out.println("Programmet er afsluttet.");
            }

        }

        }
    }

