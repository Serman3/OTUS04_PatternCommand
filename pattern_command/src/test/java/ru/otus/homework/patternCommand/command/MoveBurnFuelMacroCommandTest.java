package ru.otus.homework.patternCommand.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.homework.patternCommand.model.BurnFuelingObject;
import ru.otus.homework.patternCommand.model.MovinObject;
import ru.otus.homework.patternCommand.util.Point;
import ru.otus.homework.patternCommand.util.Vector;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class MoveBurnFuelMacroCommandTest extends BaseTest {

    private MovinObject movinObject;
    private BurnFuelingObject burnFuelingObject;
    private Command moveBurnFuelCommand;

    @BeforeEach
    void setUp() {
        movinObject = mock(MovinObject.class);
        burnFuelingObject = mock(BurnFuelingObject.class);
        moveBurnFuelCommand = new MoveBurnFuelMacroCommand(movinObject, burnFuelingObject);
    }

    @Test
    public void movingAndBurnFuelingTest() {
        when(movinObject.getLocation()).thenReturn(new Point(12, 5));
        when(movinObject.getVelocity()).thenReturn(new Vector(-7, 3));
        doNothing().when(movinObject).setLocation(any(Point.class));

        when(burnFuelingObject.getFuelAmount()).thenReturn(10.0);
        when(burnFuelingObject.getFuelConsumptionRate()).thenReturn(3.0);
        doNothing().when(burnFuelingObject).setFuelAmount(anyDouble());

        moveBurnFuelCommand.execute();

        verify(movinObject).setLocation(eq(new Point(5, 8)));
        verify(burnFuelingObject).setFuelAmount(eq(7.0));
    }
}