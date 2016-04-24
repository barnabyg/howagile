 /*************************************************************************
 *  2014 BHGAGILE
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of BHGAGILE.
 */
package com.bhgagile.howagile;

import java.awt.Paint;
import java.util.Arrays;

import org.jfree.chart.renderer.category.BarRenderer;

/**
 * @author Barnaby Golden
 *
 */
public final class CustomRenderer extends BarRenderer {

    /**
     * sUID.
     */
    private static final long serialVersionUID = 8146812231731546486L;
    /**
     *  The colors.
     */
    private final transient Paint[] colors;

    /**
     * Creates a new renderer.
     *
     * @param colors  the colors.
     */
    public CustomRenderer(final Paint[] colors) {
        super();
        this.colors = Arrays.copyOf(colors, colors.length);
    }

    /**
     * Returns the paint for an item. Overrides the default behaviour
     * inherited from AbstractSeriesRenderer.
     *
     * @param row  the series.
     * @param column  the category.
     * @return The item color.
     */
    public Paint getItemPaint(final int row, final int column) {
        return this.colors[column % this.colors.length];
    }
}
