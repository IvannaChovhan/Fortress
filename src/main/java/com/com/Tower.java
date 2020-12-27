package com.com;

import com.com.exception.NotEnoughHighForTowerException;
import org.apache.log4j.Logger;

import java.util.Objects;

/**
 *  The Tower class contain height of tower of the fortress.
 *  Extends Building, so it also includes information about century
 *  and square of tower
 */

public class Tower extends Building {
    private static final Logger LOGGER = Logger.getLogger(Tower.class);
    private static final float MIN_HEIGHT = 9f;
    private Float height;

    public Tower(float height) throws NotEnoughHighForTowerException {
        super();
        if (height < MIN_HEIGHT) {
            throw new NotEnoughHighForTowerException("The Tower not high enough");
        } else {
            this.height = height;
        }
    }

    public Tower(int century, float square, float height) throws NotEnoughHighForTowerException {
        super(century, square);// passed to parent constructor
        if (height < MIN_HEIGHT) {
            throw new NotEnoughHighForTowerException("The Tower not high enough");
        } else {
            this.height = height;
        }
    }

    public Tower() {
        this.height = MIN_HEIGHT;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    /* Own function for showing */
    @Override
    public void show() {
        LOGGER.info("The tower was built in " + century + " and its height is "+ height + " m");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result += 31 * height.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tower tower = (Tower) o;
        return Objects.equals(height, tower.height);
    }
}
