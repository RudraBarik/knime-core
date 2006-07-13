/* @(#)$RCSfile$ 
 * $Revision$ $Date$ $Author$
 * 
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
 *   12.07.2006 (gabriel): created
 */
package de.unikn.knime.core.node.config;

import de.unikn.knime.core.data.DataCell;
import de.unikn.knime.core.data.DataType;

public interface ConfigWO {
    
    public Config addConfig(String key);
    
    public void addConfig(Config config);

    /**
     * Adds an int.
     * 
     * @param key The key.
     * @param value The int value.
     */
    public void addInt(final String key, final int value);

    /**
     * Adds a double by the given key.
     * 
     * @param key The key.
     * @param value The double value to add.
     */
    public void addDouble(final String key, final double value);

    /**
     * Adds this char value to the Config by the given key.
     * 
     * @param key The key.
     * @param value The char to add.
     */
    public void addChar(final String key, final char value);

    /**
     * Adds this short value to the Config by the given key.
     * 
     * @param key The key.
     * @param value The short to add.
     */
    public void addShort(final String key, final short value);

    /** 
     * Adds this long value to the Config by the given key.
     * 
     * @param key The key.
     * @param value The long to add.
     */
    public void addLong(final String key, final long value);

    /**
     * Adds this byte value to the Config by the given key.
     * 
     * @param key The key.
     * @param value The byte to add.
     */
    public void addByte(final String key, final byte value);

    /**
     * Adds this String object to the Config by the given key. The String can be
     * null.
     * 
     * @param key The key.
     * @param value The boolean to add.
     */
    public void addString(final String key, final String value);

    /**
     * Adds this DataCell object to the Config by the given key. The cell can be
     * null.
     * 
     * @param key The key.
     * @param cell The DataCell to add.
     */
    public void addDataCell(final String key, final DataCell cell);

    /**
     * Adds this DataType object value to the Config by the given key. The type
     * can be null.
     * 
     * @param key The key.
     * @param type The DataType object to add.
     */
    public void addDataType(final String key, final DataType type);

    /**
     * Adds this boolean value to the Config by the given key.
     * 
     * @param key The key.
     * @param value The boolean to add.
     */
    public void addBoolean(final String key, final boolean value);

    /**
     * Adds this int array to the Config by the given key.
     * 
     * @param key The key.
     * @param values The int array to add.
     */
    public void addIntArray(final String key, final int... values);

    /**
     * Adds this double array value to the Config by the given key. The array
     * can be null-
     * 
     * @param key The key.
     * @param values The double array to add.
     */
    public void addDoubleArray(final String key, final double... values);

    /**
     * Adds this byte array to the Config by the given key. The array can be
     * null.
     * 
     * @param key The key.
     * @param values The byte array to add.
     */
    public void addByteArray(final String key, final byte... values);

    /**
     * Adds this short array to the Config by the given key.
     * 
     * @param key The key.
     * @param values The short to add.
     */
    public void addShortArray(final String key, final short... values);

    /**
     * Adds this long array to the Config by the given key.
     * 
     * @param key The key.
     * @param values The long arry to add.
     */
    public void addLongArray(final String key, final long... values);

    /**
     * Adds this char array to the Config by the given key.
     * 
     * @param key The key.
     * @param values The char array to add.
     */
    public void addCharArray(final String key, final char... values);

    /**
     * Adds this boolean values to the Config by the given key. The array can be
     * null.
     * 
     * @param key The key.
     * @param values The boolean array to add.
     */
    public void addBooleanArray(final String key, final boolean... values);

    /**
     * Adds this array of String object to the Config by the given key. The
     * array and the elements can be null.
     * 
     * @param key The key.
     * @param values The String array to add.
     */
    public void addStringArray(final String key, final String... values);

    /**
     * Adds an array of DataCell objects to this Config. The array and all
     * elements can be null.
     * 
     * @param key The key.
     * @param values The data cells, elements can be null.
     */
    public void addDataCellArray(final String key, final DataCell... values);

    /**
     * Adds an array of DataType objects to this Config. The array and all
     * elements can be null.
     * 
     * @param key The key.
     * @param values The data types, elements can be null.
     */
    public void addDataTypeArray(final String key, final DataType... values);

}