//Represents a crate in a kennel

public class Crate{
    //Instance variables
    int crateID;
    boolean isOccupied;
    Pet petInSeat;

    //Constructor
    public Crate(){
        this.isOccupied = false;
    }

    //Getter Methods
    public int getCrateID(){
        return this.crateID;
    }
    public boolean getOccupied(){
        return this.isOccupied;
    }
    public Pet getPet(){
        return this.petInSeat;
    }
    //Setter Methods
    public void setCrateID(int crateID){
        this.crateID = crateID;
    }
    public void setOccupied(boolean isOccupied){
        this.isOccupied = isOccupied;
    }
    public void setPet(Pet pet){
        this.petInSeat = pet;
    }

    //place in crate
    public void putPetinCrate(Pet pet){
        this.petInSeat = pet;
    }

    //remove from crate
    public void removePetFromCrate(Pet pet){
        this.petInSeat=null;
    }

    //print crate
    @Override
    public String toString(){
        if(this.petInSeat==null){
            return "()";
        }
        else{
            return this.petInSeat.getName();
        }
    }


}