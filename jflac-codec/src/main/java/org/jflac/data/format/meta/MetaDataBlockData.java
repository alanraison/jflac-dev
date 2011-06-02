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
public abstract class MetaDataBlockData implements FlacStreamData {
	protected byte[] blockData;

	/**
	 * @param blockLength the length, in bytes, of the data block
	 */
	public MetaDataBlockData(final int blockLength) {
		this.blockData = new byte[blockLength];
	}

	@Override
	public void read(final InputStream is) throws IOException, FlacDataException {
		final int readLength = is.read(this.blockData);
		if (readLength != this.blockData.length) {
			throw new FlacDataException(String.format(
					"Bytes read differs from expected length: expected %d, actual %d",
					this.blockData.length, readLength));
		}
	}

	@Override
	public void write(final OutputStream os) throws IOException {
		os.write(this.blockData);
	}
}
