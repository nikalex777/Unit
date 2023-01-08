import org.example.MagicBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MagicBoxTest {

    MagicBox<Integer> boxInt = new MagicBox<>(3);
    MagicBox<String> boxString = new MagicBox<>(3);
    static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void testConstructor() {
        MagicBox magicBox = new MagicBox<>(3);
        Assertions.assertNotNull(magicBox);
        System.out.println("Тест1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Один", "Два", "Три"})
    public void fillArray(String item) {
        assertTrue(boxString.add(item));

    }

    @Test
    public void testArray() {
        MagicBox<Integer> magicBox = new MagicBox<>(3);
        assertEquals(3, magicBox.numberAndString);
    }

    @Test
    void pickExceptionTest() {
        boxInt.add(list.get(3));
        assertThrows(RuntimeException.class, () -> boxInt.pick());
        System.out.println("Тест5");
    }

    @Test
    void testPickException() {
        Throwable exception = assertThrows(RuntimeException.class, () -> boxInt.pick(),
                "Коробка не полна и остались ещё места."
        );
        assertEquals("Коробка не полна и остались ещё места.", exception.getMessage());
    }
}
