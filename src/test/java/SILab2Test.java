
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    @BeforeAll
    public static void BeforeTests(){
        System.out.println("-----------------------------------------");
        System.out.println("Starting Tests...");
    }

    @Test
    public void EveryBranchTest(){
        assertThrows(RuntimeException.class, () -> SILab2.function(null ,null));

        User user1 = new User(null, "password!", "mail@.com");
        List<User> list = List.of(user1);
        assertFalse(SILab2.function(user1, list));

        User user2 = new User(null, "password", "mail@.com");
        assertFalse(SILab2.function(user2, list));

        User user3 = new User(null, "pass word", "mail@.com");
        assertFalse(SILab2.function(user3, list));

        User user4 = new User(null, "pass", "mail@.com");
        assertFalse(SILab2.function(user4, list));

        User user5 = new User(null, "password", "mail");
        assertFalse(SILab2.function(user5, list));

        User user6 = new User("Username", "password!", "mail@gmail.com");
        assertTrue(SILab2.function(user6, list));

        System.out.println("Every Branch Test finished.");
    }

    @Test
    public void MultipleConditionTest(){
        User user1 = new User(null, null, null);
        assertThrows(RuntimeException.class, () -> SILab2.function(user1, null));

        User user2 = new User("user", null, null);
        assertThrows(RuntimeException.class, () -> SILab2.function(user2, null));

        User user3 = new User("user", "password", null);
        assertThrows(RuntimeException.class, () -> SILab2.function(user3, null));

        User user4 = new User("user", "password", "mail@gmail.com");
        assertDoesNotThrow(() -> SILab2.function(user4, List.of(user3)));

        System.out.println("Multiple Condition Test finished.");
    }

    @AfterAll
    public static void afterTests(){
        System.out.println("All tests passed successfully!");
        System.out.println("-----------------------------------------");
    }
}
