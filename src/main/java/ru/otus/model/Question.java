package ru.otus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Question {

    private final String questionNum;

    private final String question;

    private final String answer;

}
