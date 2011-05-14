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
import java.util.Arrays;

import org.jflac.FlacDataException;
import org.jflac.data.format.util.ByteHelper;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class MetaDataBlockStreamInfo extends MetaDataBlockData {
	private static final int STREAM_INFO_LENGTH = 35;
	private int minBlockSize; // In Samples
	private int maxBlockSize; // In Samples
	private int minFrameSize; // In Bytes
	private int maxFrameSize; // In Bytes
	private int sampleRate; // In Hz
	private short channels;
	private int bitsPerSample;
	private long numberOfSamples;
	private byte[] md5sum; // 128 bits

	public MetaDataBlockStreamInfo() {
		super(STREAM_INFO_LENGTH);
	}

	@Override
	public void read(final InputStream is) throws IOException, FlacDataException {
		final int dataLength = is.read(this.blockData);

		if (dataLength == 35) {
			this.minBlockSize = ByteHelper.makeInt(this.blockData[0], this.blockData[1]);
			this.maxBlockSize = ByteHelper.makeInt(this.blockData[2], this.blockData[3]);
			this.minFrameSize = ByteHelper.makeInt(this.blockData[4], this.blockData[5],
					this.blockData[6]);
			this.maxFrameSize = ByteHelper.makeInt(this.blockData[7], this.blockData[8],
					this.blockData[9]);
			this.sampleRate = this.blockData[10] << 12 | this.blockData[11] << 4
			| this.blockData[12] >> 4;
			this.channels = (short) (this.blockData[12] >> 1);
			this.bitsPerSample = this.blockData[12] & 1 << 4 | this.blockData[13] & 0xF;
			this.numberOfSamples = ByteHelper.makeInt((byte) (this.blockData[13] >> 4),
					this.blockData[14], this.blockData[15], this.blockData[16], this.blockData[17]);
			this.md5sum = Arrays.copyOfRange(this.blockData, 18, 34);
		} else {
			throw new FlacDataException("Could not read MetaDataBlockStreamInfo from stream");
		}
	}

	@Override
	public void write(final OutputStream os) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the minBlockSize
	 */
	public int getMinBlockSize() {
		return this.minBlockSize;
	}

	/**
	 * @return the maxBlockSize
	 */
	public int getMaxBlockSize() {
		return this.maxBlockSize;
	}

	/**
	 * @return the minFrameSize
	 */
	public int getMinFrameSize() {
		return this.minFrameSize;
	}

	/**
	 * @return the maxFrameSize
	 */
	public int getMaxFrameSize() {
		return this.maxFrameSize;
	}

	/**
	 * @return the sampleRate
	 */
	public int getSampleRate() {
		return this.sampleRate;
	}

	/**
	 * @return the channels
	 */
	public short getChannels() {
		return this.channels;
	}

	/**
	 * @return the bitsPerSample
	 */
	public int getBitsPerSample() {
		return this.bitsPerSample;
	}

	/**
	 * @return the numberOfSamples
	 */
	public long getNumberOfSamples() {
		return this.numberOfSamples;
	}

	/**
	 * @return the md5sum
	 */
	public byte[] getMd5sum() {
		return this.md5sum;
	}
}
