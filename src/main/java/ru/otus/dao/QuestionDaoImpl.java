package ru.otus.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.otus.model.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionDaoImpl implements QuestionDao {

    @Override
    public List<Question> readCsvFile(String fileName) {
        var classLoader = getClass().getClassLoader();
        var inputStream = classLoader.getResourceAsStream(fileName);

        try (var csvReader = new CSVReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            var questionList = new ArrayList<Question>();
            var fileData = csvReader.readAll();
            fileData.forEach(row -> questionList.add(new Question(row[0], row[1], row[2])));
            return questionList;

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
