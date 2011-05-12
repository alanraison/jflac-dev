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
import java.util.Arrays;

import org.jflac.data.Deserializer;
import org.jflac.data.FlacStreamData;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class MetaDataBlockHeader implements FlacStreamData {
	public static final Deserializer<MetaDataBlockHeader> deserializer = new Deserializer<MetaDataBlockHeader>() {		
		@Override
		public MetaDataBlockHeader read(InputStream is) throws IOException {
			MetaDataBlockHeader mdbh = new MetaDataBlockHeader();
			int bytes = is.read(mdbh.data);
			if (bytes < 4) {
				// TODO: error
			}
			return mdbh;
		}
	};
	private byte[] data = new byte[4];
	private MetaDataBlockData metaDataBlockData;
	
	public MetaDataBlockHeader()
	{
		Arrays.fill(data, (byte) 0);
	}
	
	@Override
	public Deserializer<MetaDataBlockHeader> getDeserializer() {
		return deserializer;
	}
	
	public boolean isLastMetaData() {
		return data[0] >>7 == 1;
	}
	
	public MetaDataBlockDataType getMetaDataBlockDataType() {
		byte msb = data[0] &= 01111;
		return null;
	}
}
