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
import java.io.OutputStream;
import java.util.Arrays;

import org.jflac.data.format.util.ByteHelper;

/**
 * A FLAC METADATA_BLOCK_STREAMINFO block.
 * 
 * <table>
 * <tr>
 * <td></td>
 * </tr>
 * 
 * 
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class MetaDataBlockStreamInfo extends MetaDataBlockData {
	private static final int STREAM_INFO_LENGTH = 34;

	public MetaDataBlockStreamInfo() {
		super(STREAM_INFO_LENGTH);
	}

	@Override
	public void write(final OutputStream os) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the minBlockSize
	 */
	public int getMinBlockSize() {
		return ByteHelper.makeInt(this.blockData[0], this.blockData[1]);
	}

	/**
	 * @param minBlockSize the minBlockSize to set
	 */
	public void setMinBlockSize(final int minBlockSize) {
		this.blockData[0] = (byte) (minBlockSize >> 8);
		this.blockData[1] = (byte) minBlockSize;
	}

	/**
	 * @return the maxBlockSize
	 */
	public int getMaxBlockSize() {
		return ByteHelper.makeInt(this.blockData[2], this.blockData[3]);
	}

	/**
	 * @param maxBlockSize the maxBlockSize to set
	 */
	public void setMaxBlockSize(final int maxBlockSize) {
		this.blockData[2] = (byte) (maxBlockSize >> 8);
		this.blockData[3] = (byte) maxBlockSize;
	}

	/**
	 * @return the minFrameSize
	 */
	public int getMinFrameSize() {
		return ByteHelper.makeInt(this.blockData[4], this.blockData[5],
				this.blockData[6]);
	}

	/**
	 * @param minFrameSize the minFrameSize to set
	 */
	public void setMinFrameSize(final int minFrameSize) {
		this.blockData[4] = (byte) (minFrameSize >> 24);
		this.blockData[5] = (byte) (minFrameSize >>16);
		this.blockData[6] = (byte) minFrameSize;
	}

	/**
	 * @return the maxFrameSize
	 */
	public int getMaxFrameSize() {
		return ByteHelper.makeInt(this.blockData[7], this.blockData[8],
				this.blockData[9]);
	}

	/**
	 * @param maxFrameSize the maxFrameSize to set
	 */
	public void setMaxFrameSize(final int maxFrameSize) {
		this.blockData[7] = (byte) (maxFrameSize >> 24);
		this.blockData[8] = (byte) (maxFrameSize >> 16);
		this.blockData[9] = (byte) maxFrameSize;
	}

	/**
	 * @return the sampleRate
	 */
	public int getSampleRate() {
		return this.blockData[10] << 12
		| this.blockData[11] << 4
		| this.blockData[12] >> 4;
	}

	/**
	 * @param sampleRate the sampleRate to set
	 */
	public void setSampleRate(final int sampleRate) {
		this.blockData[10] = (byte) (sampleRate >> 12);
		this.blockData[11] = (byte) (sampleRate >> 4);
		this.blockData[12] = (byte) (sampleRate << 4 | (this.blockData[12] & 0xF));
	}

	/**
	 * @return the channels
	 */
	public short getChannels() {
		return (short) (this.blockData[12] >> 1);
	}

	/**
	 * @param channels the channels to set
	 */
	public void setChannels(final short channels) {
		if (channels > 7) {
			throw new IllegalArgumentException("FLAC supports 1-8 channels");
		}
		this.blockData[12] = (byte) (this.blockData[12] & 0xE | channels << 1);
	}

	/**
	 * @return the bitsPerSample
	 */
	public int getBitsPerSample() {
		return this.blockData[12] & 1 << 4 | (this.blockData[13] & 0xF) >> 4;
	}

	/**
	 * @param bitsPerSample the bitsPerSample to set
	 */
	public void setBitsPerSample(final int bitsPerSample) {
		this.blockData[12] = (byte) (this.blockData[12] & 0xFE | bitsPerSample & 0x10 >> 4);
		this.blockData[13] = (byte) (this.blockData[13] & 0xF | (bitsPerSample & 0xF) << 4);
	}

	/**
	 * @return the numberOfSamples
	 */
	public long getNumberOfSamples() {
		return ByteHelper.makeInt((byte) (this.blockData[13] >> 4),
				this.blockData[14], this.blockData[15], this.blockData[16], this.blockData[17]);
	}

	/**
	 * @param numberOfSamples the numberOfSamples to set
	 */
	public void setNumberOfSamples(final long numberOfSamples) {
		this.blockData[13] = (byte) (this.blockData[13] & 0xF0 | (numberOfSamples >> 32) & 0xF);
		this.blockData[14] = (byte) (numberOfSamples >> 24);
		this.blockData[15] = (byte) (numberOfSamples >> 16);
		this.blockData[16] = (byte) (numberOfSamples >> 8);
		this.blockData[17] = (byte) (numberOfSamples);
	}

	/**
	 * @return the md5sum
	 */
	public byte[] getMd5sum() {
		return Arrays.copyOfRange(this.blockData, 18, 34);
	}

	/**
	 * @param md5sum the md5sum to set
	 */
	public void setMd5sum(final byte[] md5sum) {
		System.arraycopy(md5sum, 0, this.blockData, 18, 16);
	}
}
