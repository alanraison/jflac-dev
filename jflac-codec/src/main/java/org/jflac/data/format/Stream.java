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
package org.jflac.data.format;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.jflac.FlacDataException;
import org.jflac.data.FlacStreamData;
import org.jflac.data.StreamDeserializer;
import org.jflac.data.format.meta.MetaDataBlock;

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
		public Stream read(final InputStream is) throws IOException {
			final byte[] marker = new byte[4];
			if (is.read(marker) != 4 || Arrays.equals(Stream.FLAC_HEADER, marker)) {
				return null;
			}
			return new Stream();
		}

		@Override
		public List<MetaDataBlock> readMetaData(final InputStream is)
		throws IOException, FlacDataException {
			final Stream s = read(is);
			if (s == null) {
				return Collections.emptyList();
			} else {
				final List<MetaDataBlock> metaData = new ArrayList<MetaDataBlock>();
				boolean isLast = false;
				while (!isLast) {
					final MetaDataBlock mdb = new MetaDataBlock();
					mdb.read(is);
					metaData.add(mdb);
					isLast = mdb.getHeader().isLastMetaData();
				}
				return metaData;
			}
		}

		@Override
		public Frame readDataFrame(final InputStream is) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}
	};

	public MetaDataBlock getStreamInfo() {
		return this.metaData.get(0);
	}

	public List<MetaDataBlock> getMetaData() {
		return Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see org.jflac.data.FlacStreamData#read(java.io.InputStream)
	 */
	@Override
	public void read(final InputStream is) throws IOException, FlacDataException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.jflac.data.FlacStreamData#write(java.io.OutputStream)
	 */
	@Override
	public void write(final OutputStream os) throws IOException {
		// TODO Auto-generated method stub

	}

}
