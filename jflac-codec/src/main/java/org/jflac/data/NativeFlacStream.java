/**
 * Copyright 2011 The jFLAC Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jflac.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.jflac.FlacDataException;
import org.jflac.data.format.Frame;
import org.jflac.data.format.meta.MetaDataBlock;
import org.jflac.data.format.meta.MetaDataBlockData;
import org.jflac.data.format.meta.MetaDataBlockStreamInfo;

/**
 * Container for a FLAC stream.
 * 
 * @author alanraison <alanraison@users.sourceforge.net>
 */
public class NativeFlacStream {
	/** FLAC stream identifier */
	public static final byte[] FLAC_HEADER = new byte[] { (byte) 0x66,
		(byte) 0x4C, (byte) 0x61, (byte) 0x43, };

	private final InputStream inputStream;
	private MetaDataBlockStreamInfo streamInfo;
	private final List<MetaDataBlockData> metaData;
	private List<Frame> frames;

	public NativeFlacStream(final InputStream is)
	{
		this.inputStream = is;
		this.metaData = new ArrayList<MetaDataBlockData>();
	}

	/**
	 * Read the first four bytes of the stream and check that they match the FLAC stream marker ("fLaC")
	 * @return whether the stream starts with the FLAC stream marker
	 * @throws IOException if there is an error reading the stream
	 */
	public boolean readFlacHeader() throws IOException
	{
		final byte[] buf = new byte[4];
		this.inputStream.read(buf);
		return Arrays.equals(FLAC_HEADER, buf);
	}

	/**
	 * @throws IOException
	 * @throws FlacDataException
	 */
	private void readFirstStreamInfoBlock() throws IOException, FlacDataException {
		final MetaDataBlock streamInfoBlock = new MetaDataBlock();
		streamInfoBlock.read(this.inputStream);
		this.streamInfo = (MetaDataBlockStreamInfo) streamInfoBlock.getData();
		this.metaData.clear();
		this.metaData.add(this.streamInfo);
	}

	/**
	 * @return the first METADATA_STREAMINFO_BLOCK in the stream
	 * @throws IOException if there is an error reading the stream
	 * @throws FlacDataException if there is an error with the stream data
	 */
	public MetaDataBlockStreamInfo getFirstStreamInfo() throws IOException, FlacDataException {
		// Not thread safe - but then neither is the IO
		if (this.streamInfo == null) {
			readFirstStreamInfoBlock();
		}
		return this.streamInfo;
	}

	public List<MetaDataBlock> getMetaData() {
		return Collections.emptyList();
	}

}
