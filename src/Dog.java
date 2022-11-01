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
    public void setCrate() {

    }

    @Override
    public void setCrate(Kennel ken, int crateInt){
        if(ken.getCrates()[crateInt]!=null){
            ken.getCrates()[crateInt].setPet(this);
            ken.getCrates()[crateInt].setOccupied(true);
        }
    }

}