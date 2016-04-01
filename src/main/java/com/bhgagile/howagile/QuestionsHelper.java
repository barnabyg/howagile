package com.bhgagile.howagile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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

        answers = new HashMap<Integer, Answer>();

        answers.put(1,
            new Answer(
               "Our releases are completely automated", 1, 3));
        answers.put(2,
            new Answer(
               "Our releases are automated, "
                       + "but we include some manual checks", 2, 2));
        answers.put(3,
                new Answer(
                   "Our releases are partially automated", 3, 1));
        answers.put(4,
                new Answer(
                   "We have no release automation", 4, 0));

        question =
                new Question("Do you automate your releases?",
                                              Category.ENGINEERING, answers);

        map.put(4, question);

        return map;
    }

    /**
     * Return a list of questions from a given source file.
     * @param srcPath filename of question source
     * @return map of questions
     */
    public static Map<Integer, Question> loadQuestionMap(
                                             final String srcPath) {

        final Map<Integer, Question> map = new HashMap<Integer, Question>();

        List<String> list = null;

        try {
            list = loadFile(srcPath);
        } catch (HelperException he) {
            System.out.println(he.getMessage());
        }

        final Iterator<String> iterator = list.iterator();

        boolean isFirstQuestion = true;
        List<String> strList = null;
        int count = 1;

        while (iterator.hasNext()) {
            final String str = (String) iterator.next();

            // ignore blank lines
            if (str.length() == 0) {
                continue;
            }

            final String[] parsedStr = str.split("|");

            if (parsedStr[0].equals("Q")) {

                if (isFirstQuestion) {
                    isFirstQuestion = false;
                } else {
                    map.put(count++, parseQuestion(strList));

                }

                strList = new ArrayList<String>();
                strList.add(str);

            } else if (parsedStr[0].equals("A")) {
                strList.add(str);

                if (!iterator.hasNext()) {
                    map.put(count++, parseQuestion(strList));
                }
            }
        }

        return map;
    }

    /**
     * Parse a list of strings in to a question object.
     * @param strings list of strings, starts with Q and then n answers
     * @return populated question object
     */
    private static Question parseQuestion(final List<String> strings) {

        final Map<Integer, Answer> answers = new HashMap<Integer, Answer>();

        for (int i = 1; i < strings.size(); i++) {
            final Answer answer = new Answer(strings.get(i), i, 1);
            answers.put(i, answer);
        }

        final Question question = new Question(
                strings.get(0), Category.TEAM, answers);

        return question;
    }

    /**
     * Load a file and return a list of strings representing the lines in the
     * file.
     *
     * @param srcPath
     *            file name
     * @return list of strings
     * @throws HelperException
     *             thrown on IO error
     */
    private static List<String> loadFile(final String srcPath)
            throws HelperException {

        final List<String> list = new ArrayList<String>();

        BufferedReader inReader = null;

        InputStream in = QuestionsHelper.class.getClassLoader()
                .getResourceAsStream(srcPath);

        try {

            inReader = new BufferedReader(new InputStreamReader(in));
            String line = "";

            while ((line = inReader.readLine()) != null) {
                list.add(line);
            }

        } catch (Exception ex) {
            throw new HelperException(ex);
        } finally {

            try {
                if (inReader != null) {
                    inReader.close();
                }
            } catch (IOException ex) {
                // no action on finally block error
                // but should log this really
                Logger.getLogger("");
            }
        }

        return list;
    }
}
