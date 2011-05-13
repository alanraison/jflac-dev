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

import org.jflac.FlacDataException;
import org.jflac.data.format.util.ByteHelper;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class MetaDataBlockStreamInfo extends MetaDataBlockData {
	private final int minBlockSize; // In Samples
	private final int maxBlockSize; // In Samples
	private final int minFrameSize; // In Bytes
	private final int maxFrameSize; // In Bytes
	private final int sampleRate; // In Hz
	private final short channels;
	private final int bitsPerSample;
	private final long numberOfSamples;
	private final byte[] md5sum; // 128 bits

	public MetaDataBlockStreamInfo(final InputStream is) throws IOException, FlacDataException {
		final byte[] data = new byte[35];

		final int dataLength = is.read(data);

		if (dataLength == 35) {
			this.minBlockSize = ByteHelper.makeInt(data[0], data[1]);
			this.maxBlockSize = ByteHelper.makeInt(data[2], data[3]);
			this.minFrameSize = ByteHelper.makeInt(data[4], data[5], data[6]);
			this.maxFrameSize = ByteHelper.makeInt(data[7], data[8], data[9]);
			this.sampleRate = data[10] << 12 | data[11] << 4 | data[12] >> 4;
			this.channels = (short) (data[12] >> 1);
			this.bitsPerSample = data[12] & 1 << 4 | data[13] & 0xF;
			this.numberOfSamples = ByteHelper.makeInt((byte) (data[13] >> 4), data[14], data[15], data[16], data[17]);
			this.md5sum = Arrays.copyOfRange(data, 18, 34);
		} else {
			throw new FlacDataException("Could not read MetaDataBlockStreamInfo from stream");
		}
	}

	/**
	 * @param minBlockSize
	 * @param maxBlockSize
	 * @param minFrameSize
	 * @param maxFrameSize
	 * @param sampleRate
	 * @param channels
	 * @param bitsPerSample
	 * @param numberOfSamples
	 * @param md5sum
	 */
	public MetaDataBlockStreamInfo(final int minBlockSize, final int maxBlockSize,
			final int minFrameSize, final int maxFrameSize, final int sampleRate, final short channels,
			final int bitsPerSample, final long numberOfSamples, final byte[] md5sum) {
		this.minBlockSize = minBlockSize;
		this.maxBlockSize = maxBlockSize;
		this.minFrameSize = minFrameSize;
		this.maxFrameSize = maxFrameSize;
		this.sampleRate = sampleRate;
		this.channels = channels;
		this.bitsPerSample = bitsPerSample;
		this.numberOfSamples = numberOfSamples;
		this.md5sum = md5sum;
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
