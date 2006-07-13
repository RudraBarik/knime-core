/* 
 * -------------------------------------------------------------------
 * This source code, its documentation and all appendant files
 * are protected by copyright law. All rights reserved.
 * 
 * Copyright, 2003 - 2006
 * Universitaet Konstanz, Germany.
 * Lehrstuhl fuer Angewandte Informatik
 * Prof. Dr. Michael R. Berthold
 * 
 * You may not modify, publish, transmit, transfer or sell, reproduce,
 * create derivative works from, distribute, perform, display, or in
 * any way exploit any of the content, in whole or in part, except as
 * otherwise expressly permitted in writing by the copyright owner.
 * -------------------------------------------------------------------
 * 
 * History
 *   01.02.2006 (mb): created
 */
package de.unikn.knime.core.data.property;

import de.unikn.knime.core.data.DataCell;
import de.unikn.knime.core.data.DoubleValue;
import de.unikn.knime.core.data.property.SizeHandler.SizeModel;
import de.unikn.knime.core.node.InvalidSettingsException;
import de.unikn.knime.core.node.config.ConfigRO;
import de.unikn.knime.core.node.config.ConfigWO;

/**
 * A <code>SizeModel</code> computing sizes of objects (rows) based on the 
 * <code>double</code> value of <code>DataCell</code>.
 * 
 * @author M. Berthold, University of Konstanz
 */
public class SizeModelDouble implements SizeModel {

    /** Minimum range value of domain. */
    private final double m_min;
    
    /** Maximum range value of domain. */
    private final double m_max;

    /**
     * Create new SizeHandler based on double values and a given interval.
     * 
     * @param min minimum of domain
     * @param max maximum of domain
     */
    public SizeModelDouble(final double min, final double max) {
        assert min < max;
        m_min = min;
        m_max = max;
    }
    
    /**
     * Compute size based on actual value of this cell and the range
     * which was defined during contruction.
     * 
     * @param dc value to be used for size computation.
     * @return size in percent or -1 if cell type invalid or out of range
     * 
     * @see SizeHandler#getSize(DataCell)
     */
    public double getSize(final DataCell dc) {
        if (dc.isMissing()) {
            return SizeHandler.DEFAULT_SIZE;
        }
        if (dc.getType().isCompatible(DoubleValue.class)) {
            double d = ((DoubleValue)dc).getDoubleValue();
            if ((d < m_min) || (d > m_max)) {
                return SizeHandler.DEFAULT_SIZE;    // out of range
            }
            return (d - m_min) / (m_max - m_min);
        }
        return SizeHandler.DEFAULT_SIZE;       // incomptible type
    }
    
    /** @return minimum double value. */
    public double getMinValue() {
        return m_min;
    }

    /** @return maximum double value. */
    public double getMaxValue() {
        return m_max;
    }

    private static final String CFG_MIN = "min";
    private static final String CFG_MAX = "max";
    
    /**
     * Saves min and max ranges to the given <code>Config</code>.
     * @param config To write bounds into.
     * @see de.unikn.knime.core.data.property.SizeHandler.SizeModel
     *      #save(ConfigWO)
     * @throws NullPointerException If the <i>config</i> is <code>null</code>.
     */
    public void save(final ConfigWO config) {
        config.addDouble(CFG_MIN, m_min);
        config.addDouble(CFG_MAX, m_max);
    }
    
    /**
     * Reads the size settings and return a new <code>SizeModelDouble</code>.
     * @param config Read min and max bound from.
     * @return A new size model.
     * @throws InvalidSettingsException If the bounds could not be read.
     * @throws NullPointerException If the <i>config</i> is <code>null</code>.
     */
    public static SizeModelDouble load(final ConfigRO config) 
            throws InvalidSettingsException {
        double min = config.getDouble(CFG_MIN);
        double max = config.getDouble(CFG_MAX);
        return new SizeModelDouble(min, max);
    }
    
    /**
     * @return String representation containing SizeModel type and min/max
     *         boundaries.
     */
    @Override
    public String toString() {
        return "DoubleRange SizeModel (min=" + m_min + ",max=" + m_max + ")";
    }

}
