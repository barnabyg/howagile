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
     * Number of questions on a page.
     */
    private int questionsPerPage = 3;
    /**
     * List of questions.
     */
    private Map<Integer, QuestionObj> questionMap;
    /**
     * Page number.
     */
    private int pageNumber;

    /**
     * @param questionMap list of question
     */
    public void setQuestionMap(final Map<Integer, QuestionObj> questionMap) {
        this.questionMap = questionMap;
    }
    /**
     * @return map of questions
     */
    public Map<Integer, QuestionObj> getQuestionMap() {
        return this.questionMap;
    }
    /**
     * @return the pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }
    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(final int pageNumber) {
        this.pageNumber = pageNumber;
    }
    /**
     * @return the questionsPerPage
     */
    public int getQuestionsPerPage() {
        return questionsPerPage;
    }
    /**
     * @param questionsPerPage the questionsPerPage to set
     */
    public void setQuestionsPerPage(final int questionsPerPage) {
        this.questionsPerPage = questionsPerPage;
    }
    /**
     * @return total number of questions
     */
    public int getQuestionCount() {
        int count;

        if (this.questionMap == null) {
            count = 0;
        } else {
            count = this.questionMap.size();
        }

        return count;
    }

    /**
     * @return total number of pages
     */
    public int getTotalPages() {
        return (int) this.getQuestionCount() / this.questionsPerPage;
    }

    /**
     * @return total score
     */
    public int getTotalScore() {

        int total = 0;

        for (final Integer key: this.questionMap.keySet()) {

            final QuestionObj question
                    = (QuestionObj) this.questionMap.get(key);

            if (question.getSelectedAnswer() != null
                        && question.getSelectedAnswer() > 0) {

                final Answer answer
                     = (Answer) question.getAnswerMap().get(
                                             question.getSelectedAnswer());

                total = total + answer.getPoints();
            }
        }

        return total;
    }

    /**
     * @param category question category
     * @return total score for a given category of questions
     */
    public int getTotalScore(final Category category) {

        int total = 0;

        for (final Integer key: this.questionMap.keySet()) {

            final QuestionObj question
                    = (QuestionObj) this.questionMap.get(key);

            if (question.getCategory().equals(category)
                        && question.getSelectedAnswer() != null
                        && question.getSelectedAnswer() > 0) {

                final Answer answer
                     = (Answer) question.getAnswerMap().get(
                                             question.getSelectedAnswer());

                total = total + answer.getPoints();
            }
        }

        return total;
    }

    /**
     * @return maximum possible score
     */
    public int getMaxPossibleScore() {

        int maxScore = 0;

        for (final Integer key: this.questionMap.keySet()) {

            final QuestionObj question
                    = (QuestionObj) this.questionMap.get(key);

            maxScore = maxScore + findMaxPointsAnswer(question);
        }

        return maxScore;
    }

    /**
     * @param category question category
     * @return maximum possible score
     */
    public int getMaxPossibleScore(final Category category) {

        int maxScore = 0;

        for (final Integer key: this.questionMap.keySet()) {

            final QuestionObj question
                    = (QuestionObj) this.questionMap.get(key);

            if (question.getCategory().equals(category)) {
                maxScore = maxScore + findMaxPointsAnswer(question);
            }
        }

        return maxScore;
    }

    /**
     * Find the highest scoring answer for a given question.
     * @param question the question to analyse
     * @return points for highest score answer
     */
    private int findMaxPointsAnswer(final QuestionObj question) {

        int maxPoints = 0;

        for (final Integer key: question.getAnswerMap().keySet()) {
            final Answer answer = (Answer) question.getAnswerMap().get(key);

            if (answer.getPoints() > maxPoints) {
                maxPoints = answer.getPoints();
            }
        }
        return maxPoints;
    }
}
