import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean result;

    public AccountTest(String name, boolean result) {
        this.name = name;
        this.result = result;
    }

    @Test
    public void shouldValidateName() {
        boolean actual = new Account(name).checkNameToEmboss();
        assertEquals(result, actual);
    }


    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][]{
                {"", false},
                {null, false},
                {" ТимотиШаламе", false}, // пробел в начале
                {"ТимотиШаламе ", false}, // пробел в конце
                {"Тимоти Шаламе", true},
                {"ТимотиШаламе", false}, // пробела нет
                {"Тимоти  Шаламе", false}, // два пробела посередине
                {"Timothee Chalamet", true},
                {"Т", false}, // 1 символ
                {"Т Ш", true},
                {"Ти Ш", true},
                {"Максим Сухаревский", true}, // 18 символов
                {"Николай Сухаревский", true}, // 19 символов
                {"Владимир Сухаревский", false}, // 20 символов
                {"123 345", true}
        };
    }
}