package com.com;

import org.apache.log4j.Logger;

import java.util.ArrayList;

class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        /* Array of heights for towers of fortress f1 */
        ArrayList<Float> heights1 = new ArrayList<>();
        heights1.add((float) 50);
        heights1.add((float) 30);
        heights1.add((float) 20.2);

        /* Array of heights for towers of fortress f2 */
        ArrayList<Float> heights2 = new ArrayList<>();
        heights2.add((float) 10);
        heights2.add((float) 12.4);
        heights2.add((float) 17.9);

        /* Array of warriors for garrison of fortress f1 */
        ArrayList<Warrior> warriors1 = new ArrayList<>();
        warriors1.add(new Warrior("James", "Williams", TypeOfWarrior.ARCHER));
        warriors1.add(new Warrior("Mike", "Karry", TypeOfWarrior.SPEARMAN));
        warriors1.add(new Warrior("Jordan", "Black", TypeOfWarrior.SWORDSMAN));

        /* Array of warriors for garrison of fortress f2 */
        ArrayList<Warrior> warriors2 = new ArrayList<>();
        warriors2.add(new Warrior("Jean", "Jacques", TypeOfWarrior.ARCHER));
        warriors2.add(new Warrior("Bruse", "Feamen", TypeOfWarrior.SPEARMAN));
        warriors2.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));

        /* Creating 2 Person objects to set in f1 and f2 */
        Person g1 = new Person("George", "Washington");
        Person g2 = new Person("John", "Rafr");

        /* Fortress f1 to test setters */
        Fortress f1 = new Fortress();
        f1.setName("Akkerman");
        f1.setCentury(16);
        f1.setSquare(2000);
        f1.setTowers(heights1);
        f1.setGarrison(warriors1);
        f1.setGovernor(g1);

        /* Fortress f2 to test constructor */
        Fortress f2 = new Fortress(15, 1540, "Khotyn", heights2, g2, warriors2);

        /* Array of fortresses for iterator */
        ArrayList<Fortress> f = new ArrayList<>();
        f.add(f1);
        f.add(f2);

        /* Showing each fortress in array */
        for (Fortress fortress : f) {
            fortress.show();
        }

        String str = TypeOfWarrior.showTypeOfWarriors();
        LOGGER.info(str);
    }
}
