 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Barnaby Golden
 *
 */
public final class ChartHelper {

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
                PlotOrientation.VERTICAL, true, true, true);

        return chart;
    }
}
