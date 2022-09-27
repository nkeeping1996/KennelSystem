import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Kennel ken = new Kennel();
        UserInterface ui = new UserInterface();

        //Owner owner = ui.greeting(ken);
        Owner owner = new Owner("Nikki", "28 Richard Rd", "1112224444");
        ken.addOwner(owner);
        Pet telly = new Cat("Telly");
        Pet charlie = new Dog("Charlie");
        owner.addPet(telly);
        owner.addPet(charlie);
        telly.setMealsPerDay(3);
        telly.setWalksPerDay(1);
        charlie.setWalksPerDay(2);
        charlie.setMealsPerDay(3);

        telly.feedPet();
        telly.walkPet();
        telly.feedPet();

        charlie.walkPet();
        charlie.feedPet();


        String purpose = ui.getPurpose();
        if(purpose.equals("1")){
            ui.checkIn(ken, owner);
        }
        if(purpose.equals("2")){
            ui.checkOut(ken, owner);
        }
        else{
            ui.checkOn(ken, owner);
        }

    }



}