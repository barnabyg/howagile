package com.bhgagile.howagile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.bhgagile.howagile.model.Answer;
import com.bhgagile.howagile.model.Category;
import com.bhgagile.howagile.model.QuestionObj;

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
     * Logger.
     */
    private static final Logger LOG =
            Logger.getLogger(QuestionsHelper.class);

    /**
     * Private constructor, all methods are static.
     */
    private QuestionsHelper() {
        // nothing
    }

    /**
     * Return a list of questions from a given source file.
     * @param srcPath filename of question source
     * @return map of questions
     * @throws HelperException thrown
     */
    public static Map<Integer, QuestionObj> loadQuestionMap(
                          final String srcPath) throws HelperException {

        final Map<Integer, QuestionObj> map
                = new ConcurrentHashMap<Integer, QuestionObj>();

        List<String> list = null;

        list = loadFile(srcPath);

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

            //CHECKSTYLE.OFF
            final String[] parsedStr = str.split("\\|");
            //CHECKSTYLE.ON

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
    private static QuestionObj parseQuestion(final List<String> strings) {

        final Map<Integer, Answer> answers
                = new ConcurrentHashMap<Integer, Answer>();

        for (int i = 1; i < strings.size(); i++) {

            final String line = strings.get(i);

            //CHECKSTYLE.OFF
            final String[] parsedAnswer = line.split("\\|");
            //CHECKSTYLE.ON

            final Answer answer = new Answer(parsedAnswer[1],
                                    i, Integer.parseInt(parsedAnswer[2]));

            answers.put(i, answer);
        }

        //CHECKSTYLE.OFF
        final String[] parsedQuestion = strings.get(0).split("\\|");
        //CHECKSTYLE.ON

        final QuestionObj question = new QuestionObj(
             parsedQuestion[1], Category.valueOf(parsedQuestion[2]), answers);

        return question;
    }

    /**
     * Load a file and return a list of strings representing the lines in the
     * file.
     *
     * @param srcPath file name
     * @return list of strings
     * @throws HelperException thrown on IO error
     */
    private static List<String> loadFile(final String srcPath)
            throws HelperException {

        final List<String> list = new ArrayList<String>();

        BufferedReader inReader = null;

        final InputStream in
                = Thread.currentThread().getContextClassLoader()
                                        .getResourceAsStream(srcPath);

        try {

            inReader = new BufferedReader(new InputStreamReader(in));
            String line = "";

            while ((line = inReader.readLine()) != null) {
                list.add(line);
            }

        } catch (IOException ex) {
            throw new HelperException(ex);
        } finally {

            try {
                if (inReader != null) {
                    inReader.close();
                }
            } catch (IOException ex) {
                LOG.fatal(ex.getMessage());
            }
        }

        return list;
    }
}
