import java.util.Scanner;

    public class Main {
    public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            Database database = new Database();

        System.out.println("-----Velkommen til superhelte databasen-----");


        System.out.print("Indtast navn på superhelten: ");
            String nameSuperhero1 = scan.nextLine();

        System.out.print("Indtast superheltens rigtige navn: ");
            String realNameSuperhero1 = scan.nextLine();

        System.out.print("Indtast superheltens superkraft: ");
            String superpowerSuperhero1 = scan.nextLine();

        System.out.print("Indtast superheltens alder: ");
            int ageSuperhero1 = scan.nextInt();

        System.out.print("Indtast superheltens styrkeniveau 1-9999: ");
            int strengthSuperhero1 = scan.nextInt();

        System.out.print("Er superhelten et menneske? [y/n] ");

            String userInput1 = scan.next();
            boolean isHumanSuperhero1 = false; /* Lokale variabler skal have en værdi, derfor gives
                                                  "false" som default */
            if (userInput1.equalsIgnoreCase("Y")) {
                isHumanSuperhero1 = true;
            } else if (userInput1.equalsIgnoreCase("n")) {
                isHumanSuperhero1 = false;
            } else System.out.println("Ugyldigt input.");

        database.addSuperhero(nameSuperhero1, realNameSuperhero1,
                              superpowerSuperhero1, ageSuperhero1, strengthSuperhero1,
                              isHumanSuperhero1);

        System.out.println(database.getSuperhero(0));



        }
    }

