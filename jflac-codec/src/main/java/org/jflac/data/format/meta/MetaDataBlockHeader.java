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
