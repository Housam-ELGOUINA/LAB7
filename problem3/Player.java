package problem3;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    private String name ;
    private String weapon ;
    private int hitPoints ;
    private int strength ;

    Player(String name , int hitPoints , int strength) {
        this.name  = name ;
        this.hitPoints = hitPoints ;
        this.strength =  strength ;
        this.weapon = "Sword" ;

    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getStrength() {
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        ArrayList<String> written  = new ArrayList<>(List.of(this.name, this.weapon , String.valueOf(this.hitPoints) , String.valueOf(this.strength) )) ;
        return written ;

    }

    @Override
    public void read(List<String> list) {
        if (list == null) {
            return ;
        }

        this.name  = list.get(0) ;
        this.weapon =  list.get(1) ;
        this.hitPoints = Integer.parseInt(list.get(2));
        this.strength  =  Integer.parseInt(list.get(3)) ;
    }

    @Override

    public String toString() {
        return "Player {name= " + this.name + " , hitPoints  = " + this.hitPoints +" , strength = " + this.strength + " , weapon  = " + this.weapon ;

    }


}
