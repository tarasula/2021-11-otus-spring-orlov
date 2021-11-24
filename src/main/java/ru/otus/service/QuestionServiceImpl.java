package ru.otus.service;


import lombok.AllArgsConstructor;
import ru.otus.dao.QuestionDao;
import ru.otus.model.Question;

import java.util.List;

@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionDao questionDao;

    @Override
    public List<Question> getQuestionFromCsvFile(String fileName) {
        return questionDao.readCsvFile(fileName);
    }
}
