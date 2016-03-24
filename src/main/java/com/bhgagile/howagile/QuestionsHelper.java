package com.bhgagile.howagile;

import java.util.HashMap;
import java.util.Map;

import com.bhgagile.howagile.model.Answer;
import com.bhgagile.howagile.model.Category;
import com.bhgagile.howagile.model.Question;

 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */

/**
 * @author Barnaby Golden
 *
 */
public final class QuestionsHelper {

    /**
     * Private constructor, all methods are static.
     */
    private QuestionsHelper() {
        // nothing
    }

    /**
     * Load a list of questions.
     *
     * @return populated list of questions
     */
    public static Map<Integer, Question> loadQuestionMap() {

        final Map<Integer, Question> map = new HashMap<Integer, Question>();

        Map<Integer, Answer> answers = new HashMap<Integer, Answer>();

        answers.put(1,
                new Answer(
                   "Our teams are totally self-organising", 1, 3));
        answers.put(2,
                new Answer(
                   "Our teams are mostly self-organising", 2, 2));
        answers.put(3,
            new Answer(
               "We have a manager or a team leader in each team", 3, 1));
        answers.put(4,
            new Answer(
               "Our managers/leaders are outside the team, "
                       + "but they control what goes on in the team", 4, 0));

        Question question =
                new Question(
                   "Are your teams self-organising?", Category.TEAM, answers);

        map.put(1, question);

        answers = new HashMap<Integer, Answer>();

        answers.put(1,
            new Answer(
               "All teams  have from 3 to 9 members", 1, 3));
        answers.put(2,
            new Answer(
               "Some teams have more than 9 or less than 3 members", 2, 2));
        answers.put(3,
                new Answer(
                   "Most teams have more than 9 or less than 3 members", 3, 1));
        answers.put(4,
                new Answer(
                   "All teams have more than 9 or less than 3 members", 4, 0));

        question =
                new Question(
                   "What is your usual team size?", Category.TEAM, answers);

        map.put(2, question);

        answers = new HashMap<Integer, Answer>();

        answers.put(1,
            new Answer(
               "We use CI for everything (builds, unit tests, "
                       + "functional tests, code quality checks, "
                       + "perf tests, etc.)", 1, 3));
        answers.put(2,
            new Answer(
               "We use CI for builds, unit tests and functional tests", 2, 2));
        answers.put(3,
                new Answer(
                   "We use CI for builds and unit tests", 3, 1));
        answers.put(4,
                new Answer(
                   "We don't use CI", 4, 0));

        question =
                new Question("Do you use continuous integration (CI)?",
                                              Category.ENGINEERING, answers);

        map.put(3, question);

        return map;
    }
}
