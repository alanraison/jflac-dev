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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.jflac.data.FlacSerializable;
import org.jflac.data.Deserializer;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class MetaDataBlock {
	private MetaDataBlockHeader header;
	private MetaDataBlockData data;

	/**
	 * @return the header
	 */
	public MetaDataBlockHeader getHeader() {
		return header;
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
		return data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(final MetaDataBlockData data) {
		this.data = data;
	}
	
	public void write(final Class<MetaDataBlock> clazz, final MetaDataBlock t,
			final OutputStream os) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
