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

/**
 * @author Barnaby Golden
 *
 */
public final class QuestionHelperTest {

    /**
     * How many questions do we expect.
     */
    private static final int QUESTION_COUNT = 3;

    /**
     * Test the retrieval of a list of questions.
     */
    @Test
    public void getQuestionsTest() {

        final Map<Integer, Question> list = QuestionsHelper.loadQuestionMap();

        assertEquals("Question list was the wrong size",
                                list.size(), QUESTION_COUNT);
    }
}
