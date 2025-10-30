package ru.otus.homework.patternCommand.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.homework.patternCommand.model.MovinObject;
import ru.otus.homework.patternCommand.model.MovingRotatingObject;
import ru.otus.homework.patternCommand.model.RotatingObject;
import ru.otus.homework.patternCommand.util.Point;
import ru.otus.homework.patternCommand.util.Vector;

import static org.mockito.Mockito.*;

class ChangeVelocityCommandTest extends BaseTest {

    private Command changeVelocityCommand;
    private MovinObject movinObject;
    private RotatingObject rotatingObject;
    private MovingRotatingObject movingRotatingObject;

    @BeforeEach
    void setUp() {
        movinObject = mock(MovinObject.class);
        rotatingObject = mock(RotatingObject.class);
        movingRotatingObject = mock(MovingRotatingObject.class);
    }

    @Test
    public void changeVelocityRotatingMovingObjectTest() {
        when(movinObject.getLocation()).thenReturn(new Point(12, 5));
        when(movinObject.getVelocity()).thenReturn(new Vector(-7, 3));
        doNothing().when(movinObject).setLocation(any(Point.class));

        when(rotatingObject.getAngularVelocity()).thenReturn(10);
        when(rotatingObject.getDirectionsNumber()).thenReturn(5);
        when(rotatingObject.getDirection()).thenReturn(100);
        doNothing().when(rotatingObject).setAngularVelocity(anyInt());
        doNothing().when(rotatingObject).setDirection(anyInt());

        when(movingRotatingObject.getRotatingObject()).thenReturn(rotatingObject);
        when(movingRotatingObject.getMovingObject()).thenReturn(movinObject);

        changeVelocityCommand = new ChangeVelocityCommand(movingRotatingObject, 5);

        changeVelocityCommand.execute();

        verify(rotatingObject).setAngularVelocity(5);
        verify(rotatingObject).setDirection(0);
        verify(movinObject).setLocation(eq(new Point(5, 8)));
    }

    @Test
    public void changeVelocityRotatingObjectTest() {
        when(rotatingObject.getAngularVelocity()).thenReturn(10);
        when(rotatingObject.getDirectionsNumber()).thenReturn(5);
        when(rotatingObject.getDirection()).thenReturn(100);
        doNothing().when(rotatingObject).setAngularVelocity(anyInt());
        doNothing().when(rotatingObject).setDirection(anyInt());

        when(movingRotatingObject.getRotatingObject()).thenReturn(rotatingObject);
        when(movingRotatingObject.getMovingObject()).thenReturn(null);

        changeVelocityCommand = new ChangeVelocityCommand(movingRotatingObject, 5);

        changeVelocityCommand.execute();

        verify(rotatingObject).setAngularVelocity(5);
        verify(rotatingObject).setDirection(0);
        verify(movinObject, never()).getLocation();
    }

}