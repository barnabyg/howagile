 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bhgagile.howagile.model.Category;
import com.bhgagile.howagile.model.QuestionModel;

/**
 * @author Barnaby Golden
 *
 */
@Controller
@SessionAttributes(MyController.QUESTION_MODEL)
public final class MyController {

    /**
     * Question model object.
     */
    public static final String QUESTION_MODEL = "questionModel";
    /**
     * Width of a full sized chart.
     */
    private static final int FULL_WIDTH = 500;
    /**
     * Height of a full sized chart.
     */
    private static final int FULL_HEIGHT = 300;
    /**
     * Width of a small chart.
     */
    private static final int SMALL_WIDTH = 400;
    /**
     * Height of a small chart.
     */
    private static final int SMALL_HEIGHT = 200;
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
     * Error page.
     */
    public static final String ERROR_PAGE = "error";
    /**
     * Filename of the question file.
     */
    private static final String QUESTION_FILE = "questions.txt";

    /**
     * Initialise the question model form.
     * @return populated form
     */
    @ModelAttribute(QUESTION_MODEL)
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
        @ModelAttribute(value = QUESTION_MODEL)
                final QuestionModel questionModel, final Model model) {

        String retVal = "";

        try {
            questionModel.setQuestionMap(
                    QuestionsHelper.loadQuestionMap(QUESTION_FILE));
            retVal = HOME_PAGE;
        } catch (HelperException e) {
            retVal = ERROR_PAGE;
        }

        return retVal;
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
        @ModelAttribute(value = QUESTION_MODEL)
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
        @ModelAttribute(value = QUESTION_MODEL)
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
        @ModelAttribute(value = QUESTION_MODEL)
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
            @ModelAttribute(value = QUESTION_MODEL)
                final QuestionModel questionModel, final Model model) {

        return "results";
    }

    /**
     * Draw a chart.
     * @param chartType chart type
     * @param questionModel question model
     * @param map map
     * @param request HTTP request
     * @param response HTTP response
     */
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public void showChart(
            @ModelAttribute(value = QUESTION_MODEL)
            @RequestParam("chartType") final String chartType,
            final QuestionModel questionModel,
            final ModelMap map,
            final HttpServletRequest request,
            final HttpServletResponse response) {

        response.setContentType("image/png");

        int total = 0;
        int outOf = 0;
        String label = "";
        int width = SMALL_WIDTH;
        int height = SMALL_HEIGHT;

        switch (chartType) {
        case "total":
            total = questionModel.getTotalScore();
            outOf = questionModel.getMaxPossibleScore();
            label = "Total Score";
            width = FULL_WIDTH;
            height = FULL_HEIGHT;
            break;
        case "team":
            total = questionModel.getTotalScore(Category.TEAM);
            outOf = questionModel.getMaxPossibleScore(Category.TEAM);
            label = "Team Score";
            break;
        case "product":
            total = questionModel.getTotalScore(Category.PRODUCT);
            outOf = questionModel.getMaxPossibleScore(Category.PRODUCT);
            label = "Product Score";
            break;
        case "engineering":
            total = questionModel.getTotalScore(Category.ENGINEERING);
            outOf = questionModel.getMaxPossibleScore(Category.ENGINEERING);
            label = "Engineering Score";
            break;
        case "communication":
            total = questionModel.getTotalScore(Category.COMMUNICATION);
            outOf = questionModel.getMaxPossibleScore(Category.COMMUNICATION);
            label = "Communication Score";
            break;
        default: // no default needed
        }

        try {

            ChartUtilities.writeChartAsPNG(
              response.getOutputStream(),
              ChartHelper.showChart(label, total, outOf), width, height);

        } catch (IOException ioe) {
            response.setContentType("text/html");
        }
    }
}
