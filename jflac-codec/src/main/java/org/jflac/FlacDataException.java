/**
 * Copyright 2011 The jFLAC Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
	public FlacDataException(final String message) {
		super(message);
	}

	/**
	 * Create a FlacDataException wrapping the Throwable which caused the exception
	 * 
	 * @param cause the cause of this exception
	 */
	public FlacDataException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Create a FlacDataException with a description and the Throwable which caused the exception
	 * 
	 * @param message a description of the exception
	 * @param cause the Throwable which caused the exception
	 */
	public FlacDataException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
