import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Kennel ken = new Kennel();
        UserInterface ui = new UserInterface();

        //Owner owner = ui.greeting(ken);
        Owner owner = new Owner("Nikki", "28 Richard Rd", "1112224444");
        Pet telly = new Cat("Telly");
        owner.setPet(telly);
        telly.setMealsPerDay(3);
        telly.setWalksPerDay(1);


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