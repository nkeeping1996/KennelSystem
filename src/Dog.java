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

}