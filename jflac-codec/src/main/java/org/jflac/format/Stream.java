/**
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jflac.format;

import java.util.Collection;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class Stream {
	/** FLAC stream identifier */
	public static final byte[] FLAC_HEADER = new byte[] { (byte) 0x66,
			(byte) 0x4C, (byte) 0x61, (byte) 0x43, };

	private final byte[] header = new byte[4];
	private MetaDataBlock streamInfo;
	private Collection<MetaDataBlock> metaData;
	private Collection<Frame> frames;

	public boolean isFlacStream() {
		return true;
	}

}
