package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void testSimpleTaskWhenMatches() {
        SimpleTask simpleTask = new SimpleTask(111, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskWhenNotMatches() {
        SimpleTask simpleTask = new SimpleTask(111, "Позвонить родителям");
        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicWhenNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(222, subtasks);
        boolean actual = epic.matches("Позвонить");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicWhenMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(222, subtasks);
        boolean actual = epic.matches("Яйца");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingWhenMatchesTopic() {
        Meeting meeting = new Meeting(222, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingWhenMatchesProject() {
        Meeting meeting = new Meeting(222, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Приложение НетоБанка");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNotMatches() {
        Meeting meeting = new Meeting(222, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Абрикос");

        Assertions.assertFalse(actual);
    }
}