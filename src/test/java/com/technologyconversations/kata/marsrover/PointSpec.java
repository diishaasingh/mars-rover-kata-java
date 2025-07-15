package com.technologyconversations.kata.marsrover;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

/*
Point is a two-dimensional point on the grid.
New instance is created with initial location and maximum location that can be reached on that axis.
Methods forward/backward increase/decrease location.
If maximum location is reached, forward/backward methods wrap location.
*/
public class PointSpec {
    @Test
    public void shouldSetLocation() {
        //Arrange
        int location = 5;
        int maxLocation = 9;

        //Act
        Point point = new Point(location, maxLocation);

        //Assert
        assertThat(point.getLocation()).isEqualTo(location);
    }

    @Test
    public void shouldSetMaxLocation() {
        //Arrange
        int location = 5;
        int maxLocation = 9;

        //Act
        Point point = new Point(location, maxLocation);

        //Assert
        assertThat(point.getMaxLocation()).isEqualTo(maxLocation);
    }

    @Test
    public void shouldIncreasePointValueByOneWhenForwardLocation() {
        //Arrange
        Point point = pointAt(5, 9);

        //Act
        int forwardLocation = point.getForwardLocation();

        //Assert
        assertThat(forwardLocation).isEqualTo(6);
    }

    @Test
    public void shouldDecreasePointValueByOneWhenBackwardLocation() {
        //Arrange
        Point point = pointAt(5, 9);

        //Act
        int backwardLocation = point.getBackwardLocation();

        //Assert
        assertThat(backwardLocation).isEqualTo(4);
    }

    @Test
    public void shouldWrapToZeroWhenForwardLocationExceedsMaxLocation() {
        //Arrange
        Point point = pointAt(9, 9);

        //Act
        int forwardLocation = point.getForwardLocation();

        //Assert
        assertThat(forwardLocation).isZero();
    }

    @Test
    public void shouldWrapToMaxLocationWhenBackwardLocationGoesBeforeZero() {
        //Arrange
        Point point = pointAt(0, 9);

        //Act
        int backwardLocation = point.getBackwardLocation();

        //Assert
        assertThat(backwardLocation).isEqualTo(9);
    }

    @Test
    public void shouldNotChangeLocationWhenGettingForwardLocation() {
        //Arrange
        Point point = pointAt(5, 9);

        //Act
        point.getForwardLocation();

        //Assert
        assertThat(point.getLocation()).isEqualTo(5);
    }

    @Test
    public void shouldNotChangeLocationWhenGettingBackwardLocation() {
        //Arrange
        Point point = pointAt(5, 9);

        //Act
        point.getBackwardLocation();

        //Assert
        assertThat(point.getLocation()).isEqualTo(5);
    }

    @Test
    public void shouldAllowLocationToBeChanged() {
        //Arrange
        Point point = pointAt(5, 9);

        //Act
        point.setLocation(7);

        //Assert
        assertThat(point.getLocation()).isEqualTo(7);
    }

    @Test
    public void shouldAllowMaxLocationToBeChanged() {
        //Arrange
        Point point = pointAt(5, 9);

        //Act
        point.setMaxLocation(15);

        //Assert
        assertThat(point.getMaxLocation()).isEqualTo(15);
    }

    private Point pointAt(int location, int maxLocation) {
        return new Point(location, maxLocation);
    }
}