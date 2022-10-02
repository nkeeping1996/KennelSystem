public class Cat extends Pet{
    static final String SPECIES = "Cat";
    boolean okWithDogs;

    public Cat(String name){
        super(name);
    }

    @Override
    public String getBreed() {
        return "Cat";
    }

    //pet method
    @Override
    public void giveAffection(){
        System.out.println("You pet the cat; the cat says purrrrr");
    }
}
