//Represents a pet in a kennel

public abstract class Pet{
    //Instance variables
    private String name;
    private String species;
    private String owner;
    private int mealsPerDay;
    private int walksPerDay;
    private int entryDay;
    private int exitDay;
    private int timesFedToday;
    private int timesWalkedToday;

    private boolean friendly;

    //Constructor
    public Pet(String name){
        this.name = name;
        this.timesFedToday = 0;
        this.timesWalkedToday = 0;
    }

    //Setter Methods
    public void setMealsPerDay(int mealsPerDay){
        this.mealsPerDay = mealsPerDay;
    }
    public void setWalksPerDay(int walksPerDay){
        this.walksPerDay = walksPerDay;
    }
    public void setEntryDay(int entrDay){
        this.entryDay = entryDay;
    }
    public void setExitDay(int exitDay){
        this.exitDay = exitDay;
    }
    public void setFriendly(boolean friendly){
        this.friendly = friendly;
    }

    //Getter Methods
    public String getName(){
        return this.name;
    }
    public abstract String getBreed();
    public int getMealsPerDay(){
        return this.mealsPerDay;
    }
    public int getWalksPerDay(){
        return this.walksPerDay;
    }
    public int getEntryDay(){
        return this.entryDay;
    }
    public int getExitDay(){
        return this.exitDay;
    }
    public int getTimesFedToday(){
        return this.timesFedToday;
    }
    public int getTimesWalkedToday(){
        return this.timesWalkedToday;
    }
    public boolean getFriendly() { return this.friendly;}

    //Feeder Method
    public boolean feedPet(){
        if(this.isFull()){
            System.out.println(this.getName() + " has already has his meals today. Give him anymore and he'll be stuffed!");
            return false;
        }
        else{
            this.timesFedToday++;
            System.out.println(this.getName() + " says thank you for the kibble. He has now eaten " + this.getTimesFedToday() + " times today. He gets " + this.mealsLeftToday() + " more meals today.");
            return true;
        }
    }

    //Meals remaining method
    public int mealsLeftToday(){
        return (this.getMealsPerDay() - this.getTimesFedToday());
    }

    //Has he received all his meals method
    public boolean isFull(){
        if(this.mealsLeftToday() == 0){
            return true;
        }
        return false;
    }

    //Walker Method
    public boolean walkPet(){
        if(this.isTired()){
            System.out.println(this.getName() + " is too tired for any more walks today.");
            return false;
        }
        else{
            this.timesWalkedToday++;
            System.out.println(this.getName() + " says thank you for the walk. He has " + this.walksLeftToday() + " left in him today.");
            return true;
        }
    }

    //Walks Remaining method
    public int walksLeftToday(){
        return (this.getWalksPerDay() - this.getTimesWalkedToday());
    }

    //Has he gotten all his walks method
    public boolean isTired(){
        if(this.walksLeftToday() == 0){
            return true;
        }
        else{
            return false;
        }

    }

    public abstract void giveAffection();

    public void setCrate(Kennel ken, int crateInt){
        if(canCrate(crateInt, ken)){
            ken.getCrates()[crateInt].setPet(this);
            ken.getCrates()[crateInt].setOccupied(true);
        }
    }

    public abstract boolean canCrate(int crateID, Kennel ken);

    //Return pet by crateID

}