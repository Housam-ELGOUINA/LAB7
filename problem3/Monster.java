package problem3;

import java.util.List;

public class Monster implements ISaveable{

    private String name  ;
    private int hitPoints ;
    private int strength ;

    Monster(String name , int hitPoints , int strength) {
        this.name =  name ;
        this.hitPoints = hitPoints ;
        this.strength = strength ;
    }


    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        return List.of(this.name , String.valueOf(this.hitPoints) , String.valueOf(this.strength));

    }

    @Override
    public void read(List<String> list) {
        list.set(0 , this.name) ;
        list.set(1 , String.valueOf(this.hitPoints)) ;
        list.set(2 , String.valueOf(this.strength)) ;
    }

    @Override

    public String toString() {
        return "Monster {name= " + this.name +  " , hitPOints = " + this.hitPoints + " , strength= " + this.hitPoints ;
    }
}
