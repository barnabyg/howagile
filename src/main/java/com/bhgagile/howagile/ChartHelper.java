 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile;

import java.awt.Color;
import java.awt.Paint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Barnaby Golden
 *
 */
public final class ChartHelper {

    /**
     * Two thirds.
     */
    private static final double TWO_THIRDS = 0.66;
    /**
     * One third.
     */
    private static final double ONE_THIRD = 0.33;

    /**
     * Private constructor as this is a helper.
     */
    private ChartHelper() {
        // private constructor
    }

    /**
     * Show chart.
     * @param label label for the chart
     * @param score the score achieved
     * @param scoreOutOf the maximum possible score
     * @return chart object
     */
    public static JFreeChart showChart(
            final String label, final int score, final int scoreOutOf) {

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(score, "", "Your Score");
        dataset.addValue(scoreOutOf, "", "Ideal Score");

        final JFreeChart chart = ChartFactory.createBarChart(
                label, "", "", dataset,
                PlotOrientation.VERTICAL, false, false, false);

        final CategoryPlot plot = chart.getCategoryPlot();

        // set the colour based on how good the score was
        Color scoreColour = Color.green;

        float scorePercentage = 0;

        if (score != 0) {
            scorePercentage = (float) score / (float) scoreOutOf;
        }

        if (score == 0) {
            scoreColour = Color.red;
        } else if (scorePercentage < ONE_THIRD) {
            scoreColour = Color.red;
        } else if (
                scorePercentage >= ONE_THIRD && scorePercentage < TWO_THIRDS) {

            scoreColour = Color.orange;
        } else {
            scoreColour = Color.green;
        }

        final CategoryItemRenderer renderer = new CustomRenderer(
                new Paint[] {scoreColour, Color.green});

        plot.setRenderer(renderer);

        return chart;
    }
}
