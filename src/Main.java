import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Kennel ken = new Kennel();
        UserInterface ui = new UserInterface();

        Owner owner = ui.greeting(ken);
        ken.s
//        Owner owner = new Owner("Nikki", "28 Richard Rd", "1112224444");
//        ken.addOwner(owner);
//        Pet telly = new Cat("Telly");
//        Pet charlie = new Dog("Charlie");
//        owner.addPet(telly);
//        owner.addPet(charlie);
//        telly.setMealsPerDay(3);
//        telly.setWalksPerDay(1);
//        charlie.setWalksPerDay(2);
//        charlie.setMealsPerDay(3);
//
//        telly.feedPet();
//        telly.walkPet();
//        telly.feedPet();
//
//        charlie.walkPet();
//        charlie.feedPet();


        boolean endOfDay = false;
        while (!endOfDay) {
            String purpose = ui.getPurpose();
            while (purpose != "0") {
                if (purpose.equals("1")) {
                    ui.checkIn(ken);
                }
                else if (purpose.equals("2")) {
                    ui.checkOut(ken, owner);
                }
                else if (purpose.equals("3")) {
                    ui.checkOn(ken, owner);
                }
                else if (purpose.equals("0")) {
                    break;
                }
                else {
                    System.out.println("Sorry, not a valid option");
                }
                purpose = ui.getPurpose();
            }
            endOfDay = ui.endOfDay();
            if(!endOfDay){
                System.out.println("Alright, next customer!");
            }
        }

        System.out.println("Thanks to all who visited the kennel today! Goodnight.");

    }



}