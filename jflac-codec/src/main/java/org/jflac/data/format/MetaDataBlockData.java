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
}
