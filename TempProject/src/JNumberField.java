/*
 * JNumberField.java
 *
 * Copyright 2004 Andres Quiroz Hernandez
 *
 * This file is part of Programming5.
 * Programming5 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Programming5 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Programming5.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

import javax.swing.JTextField;

/**
 *This class is a swing text field which incorporates methods to parse, limit, and return its numeric content. There is
 *also an awt counterpart.
 *@see NumberField
 *@author Andres Quiroz Hernandez
 *@version 6.0
 */
@SuppressWarnings( "serial" )
public class JNumberField extends JTextField {

    private boolean hasRange = false;
    private int minimum = Integer.MIN_VALUE;
    private int maximum = Integer.MAX_VALUE;

    public JNumberField() {
	
    }

    public JNumberField(int min_value, int max_value) {
	this.setRange(min_value, max_value);
    }

    public int getInt() throws NumberFormatException, NumberRangeException {
	int ret = 0;
	ret = Integer.parseInt(this.getText());
	if( hasRange ) {
	    if( ret < minimum ) {
		throw new NumberRangeException("JNumberField.getInt: Value less than minimum", NumberRangeException.ExceptionStatus.UNDER);
	    } else if( ret > maximum ) {
		throw new NumberRangeException("JNumberField.getInt: Value greater than maximum", NumberRangeException.ExceptionStatus.OVER);
	    }
	}
	return ret;
    }
    
    public void setInt(int value) throws NumberFormatException, NumberRangeException {
	int ret = value;
	
	if(hasRange)
	    if(ret >= minimum && ret <= maximum)
		this.setText(ret+"");
    }
    
    public void setRange(int min_value, int max_value) {
	if( min_value <= max_value ) {
	    minimum = min_value;
	    maximum = max_value;
	    hasRange = true;
	} else
	    throw new IllegalArgumentException("JNumberField.setRange: Minimum must be less than or equal to the maximum");
    }
}