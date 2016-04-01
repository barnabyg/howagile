 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.bhgagile.howagile.model.Answer;
import com.bhgagile.howagile.model.Question;

/**
 * @author Barnaby Golden
 *
 */
public final class QuestionHelperTest {

    /**
     * How many questions do we expect.
     */
    private static final int QUESTION_COUNT = 2;
    /**
     * How many answers we expect on the first question.
     */
    private static final int ANSWER_COUNT = 3;
    /**
     * Name of the file that contains the list of questions.
     */
    private static final String Q_FILE = "test-questions.txt";

    /**
     * Test the retrieval of a list of questions.
     */
    @Test
    public void getQuestionsTest() {

        final Map<Integer, Question> list
                    = QuestionsHelper.loadQuestionMap(Q_FILE);

        for (Integer key: list.keySet()) {
            final Question question = (Question) list.get(key);
            System.out.println(question.getQuestion());

            for (Integer answerKey: question.getAnswerMap().keySet()) {

                final Answer answer
                    = (Answer) question.getAnswerMap().get(answerKey);

                System.out.println(answer.getAnswerText());
            }
        }

        assertEquals("Question list was the wrong size",
                                QUESTION_COUNT, list.size());

        assertEquals("Question list was the wrong size",
                ANSWER_COUNT, list.get(1).getAnswerMap().size());
    }

}
