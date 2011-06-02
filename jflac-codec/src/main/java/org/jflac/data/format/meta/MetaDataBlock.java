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
