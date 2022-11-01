public class Dog extends Pet{
    static final String SPECIES = "Dog";
    boolean okWithCats;

    public Dog(String name){
        super(name);
    }

    @Override
    public String getBreed() {
        return "Dog";
    }

    //pet method
    @Override
    public void giveAffection(){
        System.out.println("You pet the dog; the dog wags his tail");
    }

    @Override
    public boolean canCrate(int crateID, Kennel ken) {
        if (crateID == 0) {
            if (!ken.getCrates()[0].isOccupied) {
                if (!ken.getCrates()[1].isOccupied) {
                    return true;
                }
                Pet neighbor1 = ken.getCrates()[1].getPet();
                if (neighbor1.getBreed().equals("Dog")){
                    return true;
                }
                else if(neighbor1.getBreed().equals("Cat") && neighbor1.getFriendly() && this.getFriendly()){
                    return true;
                }
            }
            return false;
        }
        else if (crateID == 5){
            if(!ken.getCrates()[5].isOccupied){
                if(!ken.getCrates()[4].isOccupied){
                    return true;
                }
                Pet neighbor1 = ken.getCrates()[4].getPet();
                if(neighbor1.getBreed().equals("Dog")){
                    return true;
                }
                else if(neighbor1.getBreed().equals("Cat") && neighbor1.getFriendly() && this.getFriendly()){
                    return true;
                }
            }
            return false;
        }
        if(!ken.getCrates()[crateID].isOccupied){
            Pet neighbor1 = null;
            Pet neighbor2 = null;
            if(ken.getCrates()[crateID-1].isOccupied){
                neighbor1 = ken.getCrates()[crateID-1].getPet();
            }
            if(ken.getCrates()[crateID+1].isOccupied){
                neighbor2 = ken.getCrates()[crateID+1].getPet();
            }
            if(neighbor1!=null && neighbor1.getBreed().equals("Cat") && (!neighbor1.getFriendly() || !this.getFriendly())){
                return false;
            }
            else if(neighbor2!=null && neighbor2.getBreed().equals("Cat") && (!neighbor2.getFriendly() || !this.getFriendly())){
                return false;
            }
            return true;
        }
        return false;
    }



    }
