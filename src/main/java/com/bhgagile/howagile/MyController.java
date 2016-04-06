 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bhgagile.howagile.model.Answer;
import com.bhgagile.howagile.model.Question;
import com.bhgagile.howagile.model.QuestionModel;

/**
 * @author Barnaby Golden
 *
 */
@Controller
@SessionAttributes("questionModel")
public final class MyController {

    /**
     * Filename of the question file.
     */
    private static final String QUESTION_FILE = "questions.txt";

    /**
     * Initialise the question model form.
     * @return populated form
     */
    @ModelAttribute("questionModel")
    public QuestionModel getQuestionModel() {
        return new QuestionModel();
    }

    /**
     * Request handler for home page.
     *
     * @param questionModel param
     * @param model model
     * @return str
     */
    @RequestMapping(method = RequestMethod.GET, value = "/next")
    public String homeRequest(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        questionModel.setQuestionMap(
                QuestionsHelper.loadQuestionMap(QUESTION_FILE));

        return "home";
    }

    /**
     * Request handler for login page submit.
     *
     * @param questionModel param
     * @param model model
     * @return home destination page
     */
    @RequestMapping(method = RequestMethod.POST, value = "/next")
    public String nextPage(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        questionModel.setPageNumber(questionModel.getPageNumber() + 1);

        printQuestionSet(questionModel.getQuestionMap());

        return "home";
    }

    /**
     * Show the results.
     *
     * @param questionModel param
     * @param model model
     * @return results page
     */
    @RequestMapping(method = RequestMethod.POST, value = "/results")
    public String showResults(
            @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        return "results";
    }

    /**
     * Print out the contents of a question map.
     * @param list map of questions
     */
    private void printQuestionSet(final Map<Integer, Question> list) {

        for (Integer key: list.keySet()) {
            final Question question = (Question) list.get(key);
            System.out.println(question.getQuestion());

            for (Integer answerKey: question.getAnswerMap().keySet()) {

                final Answer answer
                    = (Answer) question.getAnswerMap().get(answerKey);

                System.out.println(answer.getAnswerText());
            }
        }
    }
}
