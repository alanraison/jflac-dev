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
package org.jflac.data.format;

import java.util.Collection;

import org.jflac.data.FlacSerializable;
import org.jflac.data.impl.StreamDeserializerImpl;

/**
 * Container for a FLAC stream.
 * 
 * @author alanraison <alanraison@users.sourceforge.net>
 */
public interface Stream {
	/** FLAC stream identifier */
	static final byte[] FLAC_HEADER = new byte[] { (byte) 0x66,
			(byte) 0x4C, (byte) 0x61, (byte) 0x43, };
	static final StreamDeserializerImpl SERIALIZER = StreamDeserializerImpl.getInstance();

	MetaDataBlock getStreamInfo();
	
	Collection<MetaDataBlock> getMetaData();
}
