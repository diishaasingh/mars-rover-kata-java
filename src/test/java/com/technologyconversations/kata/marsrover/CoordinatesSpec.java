package com.technologyconversations.kata.marsrover;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinatesSpec {

    @Test
    public void shouldSetValueOfXPoint() {
        //Arrange
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20));

        //Act
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);

        //Assert
        assertThat(coordinates.getX()).isEqualTo(x);
    }

    @Test
    public void shouldSetValueOfYPoint() {
        //Arrange
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20));

        //Act
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);

        //Assert
        assertThat(coordinates.getY()).isEqualTo(y);
    }

    @Test
    public void shouldSetValueOfDirection() {
        //Arrange
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20));

        //Act
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);

        //Assert
        assertThat(coordinates.getDirection()).isEqualTo(direction);
    }

    @Test
    public void shouldSetValueOfObstacles() {
        //Arrange
        Point x = new Point(1, 99);
        Point y = new Point(2, 99);
        Direction direction = Direction.NORTH;
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(20, 20));

        //Act
        Coordinates coordinates = new Coordinates(x, y, direction, obstacles);

        //Assert
        assertThat(coordinates.getObstacles()).hasSameElementsAs(obstacles);
    }

    @Test
    public void shouldIncreaseYLocationWhenMovingForwardNorth() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.NORTH);

        //Act
        coordinates.moveForward();

        //Assert
        assertThat(coordinates.getY().getLocation()).isEqualTo(6);
    }

    @Test
    public void shouldIncreaseXLocationWhenMovingForwardEast() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.EAST);

        //Act
        coordinates.moveForward();

        //Assert
        assertThat(coordinates.getX().getLocation()).isEqualTo(6);
    }

    @Test
    public void shouldDecreaseYLocationWhenMovingForwardSouth() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.SOUTH);

        //Act
        coordinates.moveForward();

        //Assert
        assertThat(coordinates.getY().getLocation()).isEqualTo(4);
    }

    @Test
    public void shouldDecreaseXLocationWhenMovingForwardWest() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.WEST);

        //Act
        coordinates.moveForward();

        //Assert
        assertThat(coordinates.getX().getLocation()).isEqualTo(4);
    }

    @Test
    public void shouldDecreaseYLocationWhenMovingBackwardFromNorth() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.NORTH);

        //Act
        coordinates.moveBackward();

        //Assert
        assertThat(coordinates.getY().getLocation()).isEqualTo(4);
    }

    @Test
    public void shouldDecreaseXLocationWhenMovingBackwardFromEast() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.EAST);

        //Act
        coordinates.moveBackward();

        //Assert
        assertThat(coordinates.getX().getLocation()).isEqualTo(4);
    }

    @Test
    public void shouldIncreaseYLocationWhenMovingBackwardFromSouth() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.SOUTH);

        //Act
        coordinates.moveBackward();

        //Assert
        assertThat(coordinates.getY().getLocation()).isEqualTo(6);
    }

    @Test
    public void shouldIncreaseXLocationWhenMovingBackwardFromWest() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.WEST);

        //Act
        coordinates.moveBackward();

        //Assert
        assertThat(coordinates.getX().getLocation()).isEqualTo(6);
    }

    @Test
    public void shouldNotChangeXLocationWhenForwardMovementIsBlockedByObstacle() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.EAST,
                new Obstacle(6, 5));

        //Act
        coordinates.moveForward();

        //Assert
        assertThat(coordinates.getX().getLocation()).isEqualTo(5);
    }

    @Test
    public void shouldNotChangeYLocationWhenForwardMovementIsBlockedByObstacle() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.EAST,
                new Obstacle(6, 5));

        //Act
        coordinates.moveForward();

        //Assert
        assertThat(coordinates.getY().getLocation()).isEqualTo(5);
    }

    @Test
    public void shouldNotChangeXLocationWhenBackwardMovementIsBlockedByObstacle() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.NORTH,
                new Obstacle(5, 4));

        //Act
        coordinates.moveBackward();

        //Assert
        assertThat(coordinates.getX().getLocation()).isEqualTo(5);
    }

    @Test
    public void shouldNotChangeYLocationWhenBackwardMovementIsBlockedByObstacle() {
        //Arrange
        Coordinates coordinates = coordinatesAt(5, 5, Direction.NORTH,
                new Obstacle(5, 4));

        //Act
        coordinates.moveBackward();

        //Assert
        assertThat(coordinates.getY().getLocation()).isEqualTo(5);
    }

    @Test
    public void shouldDisplayCoordinatesWithLocationAndDirection() { //test name (shouldFormatToStringWithLocationAndDirection)
        //Arrange
        Coordinates coordinates = coordinatesAt(10, 20, Direction.SOUTH);

        //Act
        String result = coordinates.toString();

        //Assert
        assertThat(result).isEqualTo("10 X 20 S");
    }

    private Coordinates coordinatesAt(int x, int y, Direction direction) {
        return coordinatesAt(x, y, direction, Collections.<Obstacle>emptyList());
    }

    private Coordinates coordinatesAt(int x, int y, Direction direction, Obstacle... obstacles) {
        return coordinatesAt(x, y, direction, Arrays.asList(obstacles));
    }

    private Coordinates coordinatesAt(int x, int y, Direction direction, List<Obstacle> obstacles) {
        Point xPoint = new Point(x, 99);
        Point yPoint = new Point(y, 99);
        return new Coordinates(xPoint, yPoint, direction, obstacles);
    }
}