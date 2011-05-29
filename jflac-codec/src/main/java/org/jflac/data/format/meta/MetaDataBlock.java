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
 * A FLAC MetaDataBlock
 * 
 * @author alanraison <alanraison@users.sourceforge.net>
 */
public class MetaDataBlock implements FlacStreamData {
	private MetaDataBlockHeader header;
	private MetaDataBlockData data;

	@Override
	public void read(final InputStream is) throws IOException, FlacDataException {
		this.header = new MetaDataBlockHeader();
		this.header.read(is);
		switch (this.header.getMetaDataBlockDataType()) {
		case STREAMINFO:
			this.data = new MetaDataBlockStreamInfo();
		}
	}

	@Override
	public void write(final OutputStream os) throws IOException {
		this.header.write(os);
		this.data.write(os);
	}

	/**
	 * @return the header
	 */
	public MetaDataBlockHeader getHeader() {
		return this.header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(final MetaDataBlockHeader header) {
		this.header = header;
	}

	/**
	 * @return the data
	 */
	public MetaDataBlockData getData() {
		return this.data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(final MetaDataBlockData data) {
		this.data = data;
	}

}
