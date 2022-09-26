import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    public Owner greeting(Kennel ken){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, welcome to the kennel! What's your name?");
        String name = scanner.next();
        System.out.println("What's your address?");
        String address = scanner.next();
        System.out.println("And finally, what's your number?");
        String number = scanner.next();

        Owner owner = new Owner(name, address, number);
        if(ken.getOwners()!=null && ken.getOwnersNames().contains(owner.getName())){
            System.out.println("Welcome back, " + owner.getName());
        }
        else{
            ken.addOwner(owner);
            System.out.println("Welcome to the kennel, " + owner.getName());
        }
        return owner;
    }

    public String getPurpose(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of the purpose of your visit:");
        System.out.println("1. Drop off a pet.");
        System.out.println("2. Pick up a pet.");
        System.out.println("3. Check on pet.");
        String selection = scanner.next();
        while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3")){
            System.out.println("Sorry, that was not a valid response. Please enter 1 or 2:");
            selection = scanner.next();
        }
        return selection;
    }


    public void checkOut(Kennel ken, Owner owner){
        ;
    }

    public void checkOn(Kennel ken, Owner owner){
        for(Map.Entry<Owner, Pet> entry : ken.getRegistered().entrySet()){
            if(entry.getKey()==owner){
                Pet pet = owner.getPet();
                System.out.println(pet.getName() + " is doing great!");
                System.out.println(pet.getName() + " has eaten " + pet.getTimesFedToday() + " times today");
                System.out.println(pet.getName() + " has walked " + pet.getTimesWalkedToday() + " times today");
                System.out.println(pet.getName() + " has missed you, but they're having a fun time while you're gone.");
            }
        }
    }

    public void checkIn(Kennel ken, Owner owner){
        System.out.println("Who will you be checking in today?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("And is that a dog or cat? Please enter 'Dog' or 'Cat'.");
        String spec = scanner.next();

        while(!spec.toLowerCase().equals("dog") && !spec.toLowerCase().equals("cat")){
            System.out.println("Sorry, that was not valid. Please respond either 'Dog' or 'Cat', exactly as seen.");
            spec = scanner.next();
        }

        if(spec.toLowerCase().equals("dog")){
            Dog dog = new Dog(name);
            if(ken.getRegistered()==null || !ken.getRegistered().containsValue(dog)){
                ken.addPet(owner, dog);
                System.out.println("Welcome to the kennel, " + dog.getName());
            }
            else{
                System.out.println("Welcome back to the kennel, " + dog.getName());
            }
        }
        else{
            Cat cat = new Cat(name);
            if(ken.getRegistered()==null || !ken.getRegistered().containsValue(cat)){
                ken.addPet(owner, cat);
                System.out.println("Welcome to the kennel, " + cat.getName());
            }
            else{
                System.out.println("Welcome back to the kennel, " + cat.getName());
            }
        }
    }

}