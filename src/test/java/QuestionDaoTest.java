import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.QuestionService;

public class QuestionDaoTest {

    @Test
    public void testQuestionDaoReadCsvFileFromResources() {
        var classLoader = getClass().getClassLoader();
        var inputStream = classLoader.getResourceAsStream("OtusHW1_question.csv");

        assertNotNull(inputStream);
    }

    @Test
    public void testQuestionDaoParseCsvFileFromResources() {
        var questionList = getQuestionService().getQuestionFromCsvFile("OtusHW1_question.csv");

        assertNotNull(questionList);
        assertTrue(questionList.size() > 0);
    }

    @Test
    public void testQuestionDaoFailParseCsvFileFromResources() {
        assertThrows(NullPointerException.class, () -> getQuestionService().getQuestionFromCsvFile("filedFile.csv"));
    }

    private QuestionService getQuestionService() {
        return new ClassPathXmlApplicationContext("/spring-context.xml").getBean(QuestionService.class);
    }
}
