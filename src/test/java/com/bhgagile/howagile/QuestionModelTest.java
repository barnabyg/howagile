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

import com.bhgagile.howagile.model.Question;
import com.bhgagile.howagile.model.QuestionModel;

/**
 * @author Barnaby Golden
 *
 */
public final class QuestionModelTest {

    /**
     * Score for the selected answers.
     */
    private static final int SELECTED_SCORE = 3;
    /**
     * Maximum possible score.
     */
    private static final int MAX_SCORE = 6;
    /**
     * Name of the file that contains the list of questions.
     */
    private static final String Q_FILE = "test-questions.txt";

    /**
     * Scoring tests.
     */
    @Test
    public void scoreTest() {

        final Map<Integer, Question> list
        = QuestionsHelper.loadQuestionMap(Q_FILE);

        Question question = list.get(1);
        question.setSelectedAnswer(1);

        question = list.get(2);
        question.setSelectedAnswer(2);

        final QuestionModel qModel = new QuestionModel();

        qModel.setQuestionMap(list);

        assertEquals("Unexpected score for selected answers",
                            SELECTED_SCORE, qModel.getTotalScore());

        assertEquals("Unexpected maximum possible score",
                            MAX_SCORE, qModel.getMaxPossibleScore());
    }
}
