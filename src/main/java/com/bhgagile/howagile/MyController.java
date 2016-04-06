 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
     * Request handler for questions page.
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
     * Request handler for questions page submit.
     *
     * @param questionModel param
     * @param model model
     * @return home destination page
     */
    @RequestMapping(
            method = RequestMethod.POST, value = "/next", params = "Next >>")
    public String nextPage(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        questionModel.setPageNumber(questionModel.getPageNumber() + 1);

        return "home";
    }

    /**
     * Request handler for questions page submit.
     *
     * @param questionModel param
     * @param model model
     * @return home destination page
     */
    @RequestMapping(
            method = RequestMethod.POST, value = "/next", params = "Results >>")
    public String resultsPage(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        return "results";
    }

    /**
     * Request handler for questions page submit.
     *
     * @param questionModel param
     * @param model model
     * @return home destination page
     */
    @RequestMapping(
          method = RequestMethod.POST, value = "/next", params = "<< Previous")
    public String previousPage(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        questionModel.setPageNumber(questionModel.getPageNumber() - 1);

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
}
