 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile.model;

/**
 * @author Barnaby Golden
 *
 */
public final class Answer {

    /**
     * The text of the answer.
     */
    private transient String answerText;
    /**
     * The key for the answer.
     */
    private transient Integer answerKey;
    /**
     * The value of selecting this answer.
     */
    private transient int points;

    /**
     * Default constructor.
     */
    public Answer() {
        // nothing
    }

    /**
     * Constructor takes the text of the answer and the points value.
     * @param answerText text of the answer
     * @param key answer key
     * @param points the points for this answer
     */
    public Answer(
         final String answerText, final Integer key, final int points) {

        this.answerText = answerText;
        this.answerKey = key;
        this.points = points;
    }

    /**
     * @return the answerText
     */
    public String getAnswerText() {
        return this.answerText;
    }
    /**
     * @return the points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * @return answer key
     */
    public Integer getAnswerKey() {
        return this.answerKey;
    }
}
