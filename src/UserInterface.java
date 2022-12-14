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
        System.out.println("0. Exit the program.");
        String selection = scanner.next();
        while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3")&&!selection.equals("0")){
            System.out.println("Sorry, that was not a valid response. Please enter 1, 2, 3, or 0:");
            selection = scanner.next();
        }
        return selection;
    }

    public String getPurposeEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What job would you like to do?");
        System.out.println("1. Feed pets.");
        System.out.println("2. Walk pets.");
        System.out.println("3. Just say 'hi' to everyone!");
        System.out.println("0. Exit the program.");
        String selection = scanner.next();
        while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3")&&!selection.equals("0")){
            System.out.println("Sorry, that was not a valid response. Please enter 1, 2, 3, or 0:");
            selection = scanner.next();
        }
        return selection;
    }

    public void checkOut(Kennel ken, Owner owner){
        ;
    }

    public int customerOrEmployee(){
        System.out.println("Are you accessing the terminal as a customer (1) or as an employee (2)?");
        Scanner scanner = new Scanner(System.in);
        int response = scanner.nextInt();
        while(response!=1 &&response!= 2){
            System.out.println("Sorry; please enter '1' for customer or '2' for employee.");
            response = scanner.nextInt();
        }
        return response;
    }

    public void checkOn(Kennel ken, Owner owner){
        for(Pet pet : owner.getPet()){
            System.out.println(pet.getName() + " is doing great!");
            System.out.println(pet.getName() + " has eaten " + pet.getTimesFedToday() + " times today");
            System.out.println(pet.getName() + " has walked " + pet.getTimesWalkedToday() + " times today");
            System.out.println(pet.getName() + " has missed you, but they're having a fun time while you're gone.");
        }
    }

    public void checkIn(Kennel ken, Owner owner){
        if(ken.isFull()){
            System.out.println("Sorry, the kennel is full today! Please come back another time.");
            return;
        }
        if(!ken.getRegistered().containsKey(owner)){
            ken.addOwner(owner);
        }
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
            getPetInfo(dog);
            if(!owner.petLogged(dog)) {
                owner.addPet(dog);
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
            getPetInfo(cat);
            if(!owner.petLogged(cat)) {
                owner.addPet(cat);
            }
        }
    }

    public void getPetInfo(Pet pet){
        System.out.println("How many times will " + pet.getName() + " need to be fed today?");
        Scanner scanner = new Scanner(System.in);
        int timesFed = scanner.nextInt();
        pet.setMealsPerDay(timesFed);
        System.out.println("How many times will " + pet.getName() + " need to be walked today?");
        int timesWalked = scanner.nextInt();
        pet.setWalksPerDay(timesWalked);
        boolean friendly = getFriendly(pet);
        pet.setFriendly(friendly);
        System.out.println();
        System.out.println(pet.getName() + " will be fed " + timesFed + " and walked " + timesWalked + " a day!");
    }

    public boolean getFriendly(Pet pet){
        Scanner scanner = new Scanner(System.in);
        if(pet.getBreed().equals("Dog")){
            System.out.println("Finally, is your dog cat-friendly?");
            String response = scanner.next();
            if(response.toLowerCase().equals("y")){
                System.out.println("Great, thank you for letting us know!");
                return true;
            }
            System.out.println("Thank you for letting us know! We will not put them near any cats.");
            return false;
        }
        System.out.println("Finally, is your cat dog-friendly?");
        String response = scanner.next();
        if(response.toLowerCase().equals("y")){
            System.out.println("Great, thank you for letting us know!");
            return true;
        }
        System.out.println("Thank you for letting us know! We will not put them near any dogs.");
        return false;
    }

    public void feedPets(Kennel ken){
        for(Owner o : ken.getOwners()){
            for(Pet p : o.getPet()){
                if(!p.isFull()){
                    p.feedPet();
                }
            }
        }
    }

    public void walkPets(Kennel ken){
        for(Owner o : ken.getOwners()){
            for(Pet p : o.getPet()){
                if(!p.isTired()){
                    p.walkPet();
                }
            }
        }
    }

    public void sayHi(){
        System.out.println("You walk down the aisles and say a sweet 'hello' to all the fuzzy faces.");
        System.out.println("You receive plenty of tail wags and purring! :)");
    }

    public boolean endOfDay(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is it the end of the day yet? Enter Y for Yes and N for No");
        String response = scanner.next();
        while(!response.toLowerCase().equals("y") && !response.toLowerCase().equals("n")){
            System.out.println("Sorry, not a valid response. Enter Y for Yes and N for No");
            response = scanner.next();
        }
        if(response.toLowerCase().equals("y")){
            return true;
        }
        return false;
    }

}