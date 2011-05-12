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
package org.jflac.data.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import org.jflac.data.StreamSerializer;
import org.jflac.data.format.Frame;
import org.jflac.data.format.MetaDataBlock;
import org.jflac.data.format.Stream;
import org.jflac.data.format.impl.StreamImpl;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class StreamDeserializerImpl implements StreamSerializer {
	private static final StreamDeserializerImpl instance = new StreamDeserializerImpl();
	
	private StreamDeserializerImpl()
	{
		// Private constructor
	}
	
	public static StreamDeserializerImpl getInstance()
	{
		return instance;
	}

	@Override
	public Stream read(InputStream is) throws IOException {
		byte[] marker = new byte[4];
		if (is.read(marker) != 4 || Arrays.equals(Stream.FLAC_HEADER, marker)) {
			throw new IOException("Not a recognised FLAC stream");
		}
		return new StreamImpl();
	}
	
	/* (non-Javadoc)
	 * @see org.jflac.data.StreamSerializer#readMetaData()
	 */
	@Override
	public Collection<MetaDataBlock> readMetaData() throws IOException {
		MetaDataBlock block = null;
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.jflac.data.StreamSerializer#writeMetaData(java.util.Collection)
	 */
	@Override
	public void writeMetaData(Collection<MetaDataBlock> metadata)
			throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see org.jflac.data.StreamSerializer#readData()
	 */
	@Override
	public Frame readDataFrame() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.jflac.data.StreamSerializer#writeData(java.util.Collection)
	 */
	@Override
	public void writeDataFrame(Frame data) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
