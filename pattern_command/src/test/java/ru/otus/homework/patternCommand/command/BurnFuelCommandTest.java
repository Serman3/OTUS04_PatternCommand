package ru.otus.homework.patternCommand.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.homework.patternCommand.model.BurnFuelingObject;

import static org.mockito.Mockito.*;

class BurnFuelCommandTest extends BaseTest {

    private BurnFuelingObject burnFuelingObject;
    private Command burnFuelCommand;

    @BeforeEach
    public void setUp() {
        burnFuelingObject = mock(BurnFuelingObject.class);
    }

    @Test
    public void reduceAmountFuelTest() {
        when(burnFuelingObject.getFuelAmount()).thenReturn(10.0);
        when(burnFuelingObject.getFuelConsumptionRate()).thenReturn(3.0);
        doNothing().when(burnFuelingObject).setFuelAmount(anyDouble());

        burnFuelCommand = new BurnFuelCommand(burnFuelingObject);
        burnFuelCommand.execute();
        verify(burnFuelingObject).setFuelAmount(eq(7.0));
    }
}