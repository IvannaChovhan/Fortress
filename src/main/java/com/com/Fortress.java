package com.com;

import com.com.exception.NotEnoughHighForTowerException;
import com.com.exception.NotEnoughSpaceForFortressException;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * The Fortress class includes name of fortress,
 * array of towers, information about governon and
 * contains nested class garrison
 */

public class Fortress extends Building {
    private static final Logger LOGGER = Logger.getLogger(Fortress.class);
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
            warriors = new ArrayList<>();
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
            if (this.warriors.isEmpty()) {
                this.warriors = new ArrayList<>(Collections.singletonList(w));
            }
            else {
                this.warriors.add(w);
            }
        }

        public void addWarrior(String name, String surname, TypeOfWarrior typeOfWarrior) {
            Person p = new Person(name, surname); //Association
            Warrior w = new Warrior(p, typeOfWarrior);
            this.warriors.add(w);
        }

        /* Get amount warriors in garrison */
        public int getCount() {
            return warriors.size();
        }

        public String getTheMostPopularWarriorsReward() {
            List<String> mostPopularWarriorsReward = warriors
                    .stream()
                    .flatMap(w -> w.getRewards().stream())
                    .map(Reward::getTitle)
                    .collect(Collectors.toList());

            return mostPopularWarriorsReward.stream()
                    .reduce(BinaryOperator.maxBy(Comparator.comparingInt(i
                            -> Collections.frequency(mostPopularWarriorsReward, i)))).orElse(null);
        }

        /* Own function for showing */
        void show() {
            LOGGER.info("There are " + this.getCount() + " warriors in a garisson of the fortress: \n");
            for (Warrior warrior : warriors) {
                warrior.show();
            }
        }
    }

    public Fortress() {
        towers = new ArrayList<>();
        garrison = new Garrison();
    }

    public Fortress(int century, float square, String name, ArrayList<Float> heights, Person gov, ArrayList<Warrior> warriors) {
        // passed to parent constructor
        super(century, square);
        if (square < MIN_SQUARE) {
            throw new NotEnoughSpaceForFortressException("This space isn't enough for Fortress");
        }
        this.name = name;

        /* Creating an array of towers by their heights */
        towers = new ArrayList<>();

        for (Float height : heights) {
            Tower tmp = null;
            try {
                tmp = new Tower(this.getCentury(), this.getSquare(), height);
            } catch (NotEnoughHighForTowerException e) {
                LOGGER.info(e.getMessage());
            }
            towers.add(tmp);
        }

        /* Creating governor and garrison for fortress */
        governor = new Person(gov);
        garrison = new Garrison(warriors);
    }

    @Override
    public void setCentury(int century) {
        this.century = century;
        for (Tower tower: towers) {
            tower.setCentury(century);
        }
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

    @Override
    public void setSquare(float square) {
        if (square < MIN_SQUARE) {
            throw new NotEnoughSpaceForFortressException("This space isn't enough for Fortress");
        }
        this.square = square;
    }

    public void setTowers(ArrayList<Float> heights) {

        /* Creating an array of towers by their heights */
        towers = new ArrayList<>();
        for (Float height : heights) {
            Tower tmp = null;
            try {
                tmp = new Tower(this.getCentury(), this.getSquare(), height);
            } catch (NotEnoughHighForTowerException e) {
                LOGGER.info(e.getMessage());
            }
            towers.add(tmp);
        }
    }

    public String getName() {
        return name;
    }

    private ArrayList<Tower> getTowers() {
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

    public void addTower(Tower tower) {
        this.towers.add(tower);
    }

    public Map<String, List<Tower>> getNewTowers(int century) {
        Map<String, List<Tower>> map = new HashMap<>();
        List<Tower> newTowers = getTowers()
                .stream()
                .filter(e -> e.getCentury() >= century)
                .collect(Collectors.toList());
        map.put("Підходить: ", newTowers);
        List<Tower> oldTowers = getTowers()
                .stream()
                .filter(e -> e.getCentury() < century)
                .collect(Collectors.toList());
        map.put("Не підходить: ", oldTowers);
        map.forEach((k, v) -> LOGGER.info(k + ": " + v));
        return map;
    }

    public double getAvgHeightSomeTowers(int century) {
        List<Tower> someTowers = getTowers()
                .stream()
                .filter(e -> e.getCentury() == century)
                .collect(Collectors.toList());
        return  someTowers
                .stream()
                .mapToDouble(Tower::getHeight)
                .average()
                .orElseThrow(RuntimeException::new);
    }

    public double getAvgHeightTowers(){
        return  getTowers()
                .stream()
                .mapToDouble(Tower::getHeight)
                .average()
                .orElseThrow(RuntimeException::new);
    }

    public Tower getMaxHeightTower(){
        return  getTowers()
                .stream()
                .max(Comparator.comparing(Tower::getHeight))
                .orElseThrow(RuntimeException::new);
    }

    /* Own function for showing */
    @Override
    public void show() {
        LOGGER.info("\nName of fortress: " + this.name + "\n");
        super.show();
        LOGGER.info("There are " + this.getCountTowers() + " towers: \n");

        for (Tower tower : towers) {
            tower.show();
        }

        LOGGER.info("\nThe governor: \n");
        this.governor.show();

        LOGGER.info("\nThe garrison: \n");
        this.garrison.show();
    }

}
