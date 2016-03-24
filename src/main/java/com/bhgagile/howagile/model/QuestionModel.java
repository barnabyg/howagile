 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile.model;

import java.util.Map;

/**
 * @author Barnaby Golden
 *
 */
public final class QuestionModel {

    /**
     * List of questions.
     */
    private Map<Integer, Question> questionMap;

    /**
     * @param questionMap list of question
     */
    public void setQuestionMap(final Map<Integer, Question> questionMap) {
        this.questionMap = questionMap;
    }
    /**
     * @return map of questions
     */
    public Map<Integer, Question> getQuestionMap() {
        return this.questionMap;
    }
}
