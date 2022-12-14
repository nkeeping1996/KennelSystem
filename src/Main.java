import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Kennel ken = new Kennel();
        UserInterface ui = new UserInterface();


        //ken.setCratesFull(6);
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
            int user = ui.customerOrEmployee();
            if(user==1) {
                Owner owner = ui.greeting(ken);
                String purpose = ui.getPurpose();
                while (purpose != "0") {
                    if (purpose.equals("1")) {
                        ui.checkIn(ken, owner);
                    } else if (purpose.equals("2")) {
                        ui.checkOut(ken, owner);
                    } else if (purpose.equals("3")) {
                        ui.checkOn(ken, owner);
                    } else if (purpose.equals("0")) {
                        break;
                    } else {
                        System.out.println("Sorry, not a valid option");
                    }
                    purpose = ui.getPurpose();
                }
            }
            else{
                String purpose = ui.getPurposeEmployee();
                while(purpose != "0"){
                    if(purpose.equals("1")){
                        ui.feedPets(ken);
                    }
                    else if(purpose.equals("2")){
                        ui.walkPets(ken);
                    }
                    else if(purpose.equals("3")){
                        ui.sayHi();
                    }
                    else if(purpose.equals("0")){
                        break;
                    }
                    purpose = ui.getPurposeEmployee();
                }
            }
            endOfDay = ui.endOfDay();
            if(!endOfDay){
                System.out.println("Alright, next user!");
            }
        }

        System.out.println("Thanks to all who visited the kennel today! Goodnight.");

    }



}