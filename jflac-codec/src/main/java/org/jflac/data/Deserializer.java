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
package org.jflac.data;

import java.io.IOException;
import java.io.InputStream;

/**
 * The mechanism for serializing and deserializing objects in a FLAC stream.
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 * @param <T> The object being serialized
 */
public interface Deserializer<T> {
	
	/**
	 * Read an object from the stream
	 * @return the object from the stream
	 * @throws IOException if there is a problem reading the stream
	 */
	T read(InputStream is) throws IOException;
}
