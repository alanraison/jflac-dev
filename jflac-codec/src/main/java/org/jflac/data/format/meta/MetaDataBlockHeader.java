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
package org.jflac.data.format.meta;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.jflac.FlacDataException;
import org.jflac.data.FlacStreamData;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class MetaDataBlockHeader implements FlacStreamData {
	private boolean last;
	private MetaDataBlockDataType dataType;
	private int dataLength;

	@Override
	public void read(final InputStream is) throws IOException, FlacDataException
	{
		final byte[] data = new byte[4];
		final int length = is.read(data);
		if (length == 4) {
			this.last = data[0] >>7 == 1;
			this.dataType = MetaDataBlockDataType.getFromId(data[0] & 0x7F);
			this.dataLength  = data[1] << 16 | data[2] << 8 | data[3];
		} else {
			throw new FlacDataException("Failed to read MetaDataBlockHeader");
		}
	}

	@Override
	public void write(final OutputStream os) throws IOException {
		final byte[] data = new byte[4];
		data[0] = (byte) (this.last ? 1 << 7 : 0 | this.dataType.getId());
		data[1] = (byte) (this.dataLength >> 16);
		data[2] = (byte) (this.dataLength >> 8);
		data[3] = (byte) (this.dataLength);
		os.write(data);
	}

	public boolean isLastMetaData() {
		return this.last;
	}

	public MetaDataBlockDataType getMetaDataBlockDataType() {
		return this.dataType;
	}

	public int getLength() {
		return this.dataLength;
	}
}
