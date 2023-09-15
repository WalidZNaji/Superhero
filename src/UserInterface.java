import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public void startProgram() {

    Database database = new Database();
        Superhero p1 = new Superhero("Rico", "Victor Thy", "Skifte personlighed ved indtagelse af alkohol", 23, 9, true);
        Superhero p2 = new Superhero("Menig Hoijer", "Mads Teglskov", "Superstyrke, Stram", 24, 8, true);
        Superhero p3 = new Superhero("AC", "Anders kristensen", "Retard strength", 31, 6, true);
        Superhero p4 = new Superhero("TS", "Tommy Skrudstrup", "Dårlig beslutningstager. Altid gør det modsatte af hvad han siger", 38, 8, true);
        database.addSuperhero("Rico", "Victor Thy", "Skifte personlighed ved indtagelse af alkohol", 23, 9, true);
        database.addSuperhero("Menig Hoijer", "Mads Teglskov", "Superstyrke, Stram", 24, 8, true);
        database.addSuperhero("AC", "Anders kristensen", "Retard strength", 31, 6, true);
        database.addSuperhero("TS", "Tommy Skrudstrup", "Dårlig beslutningstager. Altid gør det modsatte af hvad han siger", 38, 8, true);
        String runAgain = "y";
        Scanner scan = new Scanner(System.in);


        System.out.println("-----Velkommen til superhelte databasen-----");

        while (runAgain.equalsIgnoreCase("y")) {

            System.out.println("---Start menu---");
            System.out.println( "Tryk 1: Opret ny superhelt\n" +
                    "Tryk 2: Vis superhelte liste\n" +
                    "Tryk 3: Søg efter superhelt\n" +
                    "Tryk 4: Rediger superhelt\n" +
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


            } else if (startInput == 4) {

                //Her kan delvist navn indtastes
                System.out.println("Indtast søgekriterium for superhelt");
                String brugerInput = scan.nextLine();

                // Find person(er)
                ArrayList<Superhero> søgeResultat = database.findSuperhero(brugerInput);
                Superhero superheroToEdit = null;

                // Søgning finder ingen personer
                if (søgeResultat.size() == 0) {
                    System.out.println("Der findes ingen superhelte der opfylder søgekriterium");

                } else if (søgeResultat.size() > 1) {
                    // Vælg en person i søgeresultat med flere personer
                    System.out.println("Vælg superhelt");
                    int tæller = 1;
                    for (Superhero superhero : søgeResultat) {
                        System.out.println(tæller++ + ". " +
                                superhero.getName() + " " +
                                superhero.getRealName() + " " +
                                superhero.getSuperpower() + " " +
                                superhero.getAge() + " " +
                                superhero.getStrength() + " " +
                                superhero.isHuman());
                    }
                    int superheroPick = scan.nextInt();
                    scan.nextLine(); // Håndterer Scanner Bug
                    superheroToEdit = søgeResultat.get(superheroPick - 1);
                }
                //Søgning finder én person
                else {
                    superheroToEdit = søgeResultat.get(0);
                }

                // Redigering af valgte personer
                if (superheroToEdit != null) {
                    System.out.println("Rediger superhelt information. Tryk ENTER hvis information ikke skal redigeres.");
                    String nyVærdi;
                    System.out.println("navn: " + superheroToEdit.getName());
                    nyVærdi = scan.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroToEdit.setName(nyVærdi);
                    }
                    System.out.println("Rigtige navn: " + superheroToEdit.getRealName());
                    nyVærdi = scan.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroToEdit.setRealName((nyVærdi));
                    }
                    {
                        System.out.println("Superkraft: " + superheroToEdit.getSuperpower());
                        nyVærdi = scan.nextLine();
                        if (!nyVærdi.isEmpty()) {
                            superheroToEdit.setSuperpower((nyVærdi));
                    }
                    System.out.println("Alder: " + superheroToEdit.getAge());
                    nyVærdi = scan.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroToEdit.setAge(Integer.parseInt(nyVærdi));
                    }
                    System.out.println("Styrke niveau: " + superheroToEdit.getStrength());
                    nyVærdi = scan.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroToEdit.setStrength(Integer.parseInt(nyVærdi));
                    }
                    System.out.println(superheroToEdit + " er opdateret.");
                }
            }


        } else if (startInput == 9) {
                runAgain = "n";
        }

        }
        System.out.println("Programmet er afsluttet.");

    }
}
