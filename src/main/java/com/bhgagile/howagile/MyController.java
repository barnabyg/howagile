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
     * Home page.
     */
    public static final String HOME_PAGE = "home";
    /**
     * Questions page.
     */
    public static final String QUESTION_PAGE = "questions";
    /**
     * Results page.
     */
    public static final String RESULTS_PAGE = "results";

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
    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String homeRequest(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        questionModel.setQuestionMap(
                QuestionsHelper.loadQuestionMap(QUESTION_FILE));

        return HOME_PAGE;
    }

    /**
     * Request handler for questions page submit.
     *
     * @param questionModel param
     * @param model model
     * @return home destination page
     */
    @RequestMapping(
            method = RequestMethod.POST, value = "/next", params = "Next")
    public String nextPage(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        // increment the page counter
        questionModel.setPageNumber(questionModel.getPageNumber() + 1);

        return QUESTION_PAGE;
    }

    /**
     * Request handler for questions page submit.
     *
     * @param questionModel param
     * @param model model
     * @return home destination page
     */
    @RequestMapping(
          method = RequestMethod.POST, value = "/next", params = "Previous")
    public String previousPage(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        // decrement the page counter
        questionModel.setPageNumber(questionModel.getPageNumber() - 1);

        return QUESTION_PAGE;
    }

    /**
     * Request handler for questions page submit.
     *
     * @param questionModel param
     * @param model model
     * @return home destination page
     */
    @RequestMapping(
            method = RequestMethod.POST, value = "/next", params = "Results")
    public String resultsPage(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model model) {

        return RESULTS_PAGE;
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
