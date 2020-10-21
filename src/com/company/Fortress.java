package com.company;

import com.company.exception.NotEnoughHighForTowerException;
import com.company.exception.NotEnoughSpaceForFortressException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Fortress class includes name of fortress,
 * array of towers, information about governon and
 * contains nested class garrison
 */

public class Fortress extends Building {
    private static final int MIN_SQUARE = 180;
    private String name;
    private ArrayList<Tower> towers; // Association
    private Person governor; // Aggregation
    private Garrison garrison;

    /**
     * Nested non-static class.
     * Contains array of warriors
     */

    public class Garrison {
        private ArrayList<Warrior> warriors;

        public Garrison() {
            warriors = new ArrayList<Warrior>();
        }

        public Garrison(ArrayList<Warrior> warriors) {
            this.warriors = warriors;
        }

        public void setWarriors(ArrayList<Warrior> warriors) {
            this.warriors = warriors;
        }

        public ArrayList<Warrior> getWarriors() {
            return warriors;
        }

        /* Method to add a single warrior to garrison */
        public void addWarrior(Warrior w) {
            this.warriors.add(w);
        }

        /* Get amount warriors in garrison */
        public int getCount() {
            return warriors.size();
        }

        /* Own function for showing */
        public void show() {
            System.out.println("There are " + this.getCount() + " warriors in a garisson of the fortress: \n");
            Iterator<Warrior> it = warriors.iterator();
            while(it.hasNext()) {
                it.next().show();
            }
        }
    }

    public Fortress() {
        towers = new ArrayList<Tower>();
    }

    public Fortress(int century, float square, String name, ArrayList<Float> heights, Person gov, ArrayList<Warrior> warriors) {
        // passed to parent constructor
        super(century, square);
        if (square < MIN_SQUARE) {
            throw new NotEnoughSpaceForFortressException("This space isn't enough for Fortress");
        }
        this.name = name;

        /* Creating an array of towers by their heights */
        towers = new ArrayList<Tower>();
        Iterator<Float> it = heights.iterator();

        while(it.hasNext()) {
            Tower tmp = null;
            try {
                tmp = new Tower(this.getCentury(), this.getSquare(), it.next());
            } catch (NotEnoughHighForTowerException e) {
                System.out.println(e.getMessage());
            }
            towers.add(tmp);
        }

        /* Creating governor and garrison for fortress */
        governor = new Person(gov);
        garrison = new Garrison(warriors);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGarrison(ArrayList<Warrior> warriors) {
        garrison = new Garrison(warriors);
    }

    public void setGovernor(Person governor) {
        this.governor = governor;
    }

    public void setTowers(ArrayList<Float> heights) {

        /* Creating an array of towers by their heights */
        Iterator<Float> it = heights.iterator();
        while(it.hasNext()) {
            Tower tmp = null;
            try {
                tmp = new Tower(this.getCentury(), this.getSquare(), it.next());
            } catch (NotEnoughHighForTowerException e) {
                System.out.println(e.getMessage());
            }
            towers.add(tmp);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public Person getGovernor() {
        return governor;
    }

    public Garrison getGarrison() {
        return garrison;
    }

    public int getCountTowers() {
        return this.towers.size();
    }

    /* Own function for showing */
    public void show() {
        System.out.println("\nName of fortress: " + this.name + "\n");
        super.show();
        System.out.println("There are " + this.getCountTowers() + " towers: \n");

        Iterator<Tower> it = towers.iterator();
        while(it.hasNext()) {
            it.next().show();
        }

        System.out.println("\nThe governor: \n");
        this.governor.show();

        System.out.println("\nThe garrison: \n");
        this.garrison.show();
    }

}
