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
     * @return chart object
     */
    public static JFreeChart showChart() {

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(4.0, "Java", "2005");
        dataset.addValue(9.0, "Java", "2006");
        dataset.addValue(7.0, "Java", "2007");

        JFreeChart chart = ChartFactory.createBarChart(
                "blah", "badger", "frog", dataset,
                PlotOrientation.VERTICAL, true, true, true);

        return chart;
    }
}
