//A kennel; is an array of crates, which may or may not have dogs within them at any time. 
import java.util.ArrayList;
import java.util.HashMap;

public class Kennel{
    //Instance Variables
    private Crate[] Crates = new Crate[6];
    private int cratesFull;
    private HashMap<Owner, Pet> registeredMembers;

    //Constructor
    public Kennel(){
        int id = 0;
        for(int i = 0; i<6; i++){
            Crates[i] = new Crate();
            Crates[i].setCrateID(id);
            id++;
        }
        this.cratesFull = 0;
        this.registeredMembers = new HashMap<Owner, Pet>();
    }

    //Getter Methods
    public int getCratesFull(){
        return this.cratesFull;
    }
    public void setCratesFull(int cratesFull){this.cratesFull=cratesFull;}
    public Crate[] getCrates(){
        return this.Crates;
    }
    public HashMap<Owner, Pet> getRegistered(){
        return this.registeredMembers;
    }

    public void addPet(Owner owner, Pet pet){
        this.getRegistered().put(owner, pet);
    }
    public ArrayList<Owner> getOwners(){
        ArrayList<Owner> owners = new ArrayList<Owner>();
        if(this.registeredMembers==null){
            return owners;
        }
        else{
            for(Owner o : this.registeredMembers.keySet()){
                owners.add(o);
            }
        }
        return owners;
    }

    public ArrayList<String> getOwnersNames(){
        ArrayList<String> owners = new ArrayList<String>();
        if(this.registeredMembers == null){
            return owners;
        }
        for(Owner o : this.registeredMembers.keySet()){
            owners.add(o.getName());
        }
        return owners;
    }

    //Okay to place in crate
    public boolean okToBoard(int crateID, Pet pet){
        if(this.getCratesFull()==6){
            System.out.println("The kennel is all full! Another pet will have to check out first.");
            return false;
        }
        else if(this.Crates[crateID].getPet()==null){
            return true;
        }
        else{
            System.out.println("It looks like this crate is already taken.");
            return false;
        }
    }

    //Place in crate
    public void placeInCrate(int crateID, Pet pet){
        if(okToBoard(crateID, pet)){
            this.Crates[crateID].putPetinCrate(pet);
            Crates[crateID].setOccupied(true);
            this.cratesFull++;
            System.out.println(pet.getName() + " is now in crate number " + crateID);
            int crates = this.getCratesFull();
            int remaining = 6 - crates;
            System.out.println("The kennel now has " + crates + " full crate(s) and " + remaining + " crate(s) available.");
        }
    }

    //Take out of crate
    public void removeFromCrate(Pet pet){
        for(int i = 0; i<6; i++){
            if(this.Crates[i].petInSeat == pet){
                this.Crates[i].removePetFromCrate(pet);
                Crates[i].setOccupied(false);
                cratesFull--;
            }
        }
    }


    //printing the kennel
    public void print(){
        for(int i = 0; i<6; i++){
            System.out.println(Crates[i]);
        }
    }

    public boolean contains(Owner owner){
        for(Owner o : this.registeredMembers.keySet()){
            if(owner.getName().equals(o.getName()) && owner.getAddress().equals(o.getAddress()) && owner.getNumber().equals(o.getNumber())){
                return true;
            }
        }
        return false;
    }

    public boolean isFull(){
        if(this.cratesFull == Crates.length){
            return true;
        }
        return false;
    }

    public void addOwner(Owner owner){
        this.getOwners().add(owner);
    }
}