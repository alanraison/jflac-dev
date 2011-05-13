/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jflac;

/**
 * Indicates that unexpected data has been found in the FLAC data stream
 * 
 * @author alanraison <alanraison@users.sourceforge.net>
 */
public class FlacDataException extends Exception {

	private static final long serialVersionUID = 2434514808578035509L;

	/**
	 * Create a new FlacDataException with no arguments
	 */
	public FlacDataException() {
		super();
	}
	
	/**
	 * Create a FlacDataException with a description of the error
	 * 
	 * @param message a description of the cause of the error
	 */
	public FlacDataException(String message) {
		super(message);
	}
	
	/**
	 * Create a FlacDataException wrapping the Throwable which caused the exception
	 * 
	 * @param cause the cause of this exception
	 */
	public FlacDataException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Create a FlacDataException with a description and the Throwable which caused the exception
	 * 
	 * @param message a description of the exception
	 * @param cause the Throwable which caused the exception
	 */
	public FlacDataException(String message, Throwable cause) {
		super(message, cause);
	}
}
