
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

public class Owner{
    //Instance variables
    private String name;
    private String address;
    private String number;
    private Set<Pet> pets = new HashSet<Pet>();


    //Constructor
    public Owner(String name, String address, String number){
        this.name = name;
        this.address = address;
        this.number = number;
    }

    //Getter Methods
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getNumber(){
        return this.number;
    }
    public Set<Pet> getPet(){
        return this.pets;
    }

    //Setter Methods
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public void addPet(Pet pet){
        this.pets.add(pet);
    }

    public boolean petLogged(Pet pet){
        if(this.getPet().contains(pet)){
            return true;
        }
        return false;
    }

    //Registration Method
    public void registration(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, welcome to the kennel! What's your name?");
        String name = scanner.next();
        System.out.println("What's your address?");
        String address = scanner.next();
        System.out.println("And finally, what's your number?");
        String number = scanner.next();

        Owner newowner = new Owner(name, address, number);

    }


}