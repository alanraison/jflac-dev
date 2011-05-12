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
import java.util.Collection;
import java.util.List;

import org.jflac.data.Deserializer;
import org.jflac.data.FlacSerializable;
import org.jflac.data.FlacStreamData;
import org.jflac.data.StreamDeserializer;
import org.jflac.data.impl.StreamDeserializerImpl;

/**
 * Container for a FLAC stream.
 * 
 * @author alanraison <alanraison@users.sourceforge.net>
 */
public class Stream implements FlacStreamData {
	/** FLAC stream identifier */
	public static final byte[] FLAC_HEADER = new byte[] { (byte) 0x66,
			(byte) 0x4C, (byte) 0x61, (byte) 0x43, };
	
	private List<MetaDataBlock> metaData;
	private List<Frame> frames;
	
	private static final StreamDeserializer DESERIALIZER = new StreamDeserializer() {
		
		@Override
		public Stream read(InputStream is) throws IOException {
			byte[] marker = new byte[4];
			if (is.read(marker) != 4 || Arrays.equals(Stream.FLAC_HEADER, marker)) {
				return null;
			}
			return new Stream();
		}
		
		@Override
		public Collection<MetaDataBlock> readMetaData(InputStream is)
				throws IOException {
			Stream s = read(is);
			return s != null ? MetaDataBlock.getDeserializer().read(is);
		}
		
		@Override
		public Frame readDataFrame(InputStream is) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}
	};

	public MetaDataBlock getStreamInfo() {
		return metaData.get(0);
	}
	
	public List<MetaDataBlock> getMetaData() {
		
	}

	@Override
	public StreamDeserializer getDeserializer() {
		return DESERIALIZER;
	}
	
	//private static class 
}
