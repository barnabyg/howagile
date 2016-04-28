 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile.model;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Barnaby Golden
 *
 */
public final class QuestionObj implements Serializable {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = -7949357371051780659L;
    /**
     * Question string.
     */
    private transient String question;
    /**
     * Category this question falls under.
     */
    private transient Category category;
    /**
     * Map of answers.
     */
    private Map<Integer, Answer> answerMap;
    /**
     * The index of the answer selected by the user.
     */
    private Integer selectedAnswer;

    /**
     * Default constructor.
     */
    public QuestionObj() {
        // nothing
    }

    /**
     * Constructor takes the string of a question.
     * @param question the question text
     * @param category the category this question falls in to
     * @param answerMap map of answers
     */
    public QuestionObj(
            final String question,
            final Category category,
            final Map<Integer, Answer> answerMap) {

        this.question = question;
        this.category = category;
        this.answerMap = answerMap;
    }

    /**
     * @return the answerMap
     */
    public Map<Integer, Answer> getAnswerMap() {
        return answerMap;
    }

    /**
     * @param answerMap the answerMap to set
     */
    public void setAnswerMap(final Map<Integer, Answer> answerMap) {
        this.answerMap = answerMap;
    }

    /**
     * @return the selectedAnswer
     */
    public Integer getSelectedAnswer() {
        return selectedAnswer;
    }

    /**
     * @param selectedAnswer the selectedAnswer to set
     */
    public void setSelectedAnswer(final Integer selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }
}
