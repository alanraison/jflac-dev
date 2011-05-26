/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.jflac.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.jflac.FlacDataException;
import org.jflac.data.format.Frame;
import org.jflac.data.format.MetaDataBlock;
import org.jflac.data.format.Stream;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public interface StreamDeserializer extends Deserializer<Stream> {
	Collection<MetaDataBlock> readMetaData(InputStream is) throws IOException, FlacDataException;
	Frame readDataFrame(InputStream is) throws IOException, FlacDataException;
}
