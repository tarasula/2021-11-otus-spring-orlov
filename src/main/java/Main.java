import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.QuestionService;

public class Main {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("/spring-context.xml");
        var service = context.getBean(QuestionService.class);
        var questionList = service.getQuestionFromCsvFile("OtusHW1_question.csv");

        questionList.forEach(question -> {
            System.out.println(question.getQuestionNum() + ". " + question.getQuestion());
            System.out.println(question.getAnswer());
        });
        context.close();
    }
}
