public class Cat extends Pet{
    static final String SPECIES = "Cat";
    boolean okWithDogs;

    public Cat(String name){
        super(name);
    }

    //pet method
    @Override
    public void giveAffection(){
        System.out.println("You pet the cat; the cat says purrrrr");
    }
}
