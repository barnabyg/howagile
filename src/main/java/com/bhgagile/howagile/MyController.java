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

import com.bhgagile.howagile.model.QuestionModel;

/**
 * @author Barnaby Golden
 *
 */
@Controller
public final class MyController {

    /**
     * Request handler for home page.
     *
     * @param questionModel param
     * @param m model
     * @return str
     */
    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String homeRequest(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model m) {

        questionModel.setQuestionMap(QuestionsHelper.loadQuestionMap());

        return "home";
    }

    /**
     * Request handler for login page submit.
     *
     * @param questionModel param
     * @param m model
     * @return str destination page
     */
    @RequestMapping(method = RequestMethod.POST, value = "/nextPage")
    public String nextPage(
        @ModelAttribute(value = "questionModel")
                final QuestionModel questionModel, final Model m) {

        return "home";
    }

}