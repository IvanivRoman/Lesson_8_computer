package org.example;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    void shouldReturnNegativeWhenTextIsNull () {
        Computer comp = new Computer();
        assertThat(comp.findText(null, "some text")).isNegative();
    }

    @Test
    void shouldReturnNegativeWhenTextIsEmpty () {
        Computer comp = new Computer();
        assertThat(comp.findText("", "some text")).isNegative();
    }

    @Test
    void shouldReturnNegativeWhenSearchIsNull () {
        Computer comp = new Computer();
        assertThat(comp.findText("some text here", null)).isNegative();
    }

    @Test
    void shouldReturnNegativeWhenSearchIsEmpty () {
        Computer comp = new Computer();
        assertThat(comp.findText("some text here", "")).isNegative();
    }

    @Test
    void shouldReturnIndex() {
        Computer comp = new Computer();
        assertThat(comp.findText("some text here", "text")).isPositive();
    }
}
