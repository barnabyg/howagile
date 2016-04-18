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
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import com.bhgagile.howagile.model.Answer;
import com.bhgagile.howagile.model.Category;
import com.bhgagile.howagile.model.QuestionObj;

/**
 * @author Barnaby Golden
 *
 */
public final class QuestionTest {

    /**
     * Populate a question object.
     */
    @Test
    public void populateQuestions() {

        final Map<Integer, Answer> answers
                = new ConcurrentHashMap<Integer, Answer>();

        answers.put(1,
          new Answer(
            "We have a manager or a leader in each team", 1, 2));
        answers.put(2,
          new Answer(
            "We have managers for some discipline outside of the team", 2, 1));

        final QuestionObj question =
                new QuestionObj(
                   "Are your teams self-organising?", Category.TEAM, answers);

        assertEquals("Invalid map size", 2, question.getAnswerMap().size());

    }
}
