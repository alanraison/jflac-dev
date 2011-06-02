/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.jflac.data.format.meta;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class Seekpoint {
	private final byte[] bytes;

	public Seekpoint(final byte[] bytes) {
		this.bytes = bytes;
	}

	/**
	 * @return the firstSampleFrame
	 */
	public BigInteger getFirstSampleFrame() {
		return new BigInteger(1, Arrays.copyOfRange(this.bytes, 0, 8));
	}
	/**
	 * @param firstSampleFrame the firstSampleFrame to set
	 */
	public void setFirstSampleFrame(final BigInteger firstSampleFrame) {
		System.arraycopy(firstSampleFrame.toByteArray(), 0, this.bytes, 0, 8);
	}
	/**
	 * @return the offset
	 */
	public BigInteger getOffset() {
		return new BigInteger(1, Arrays.copyOfRange(this.bytes, 8, 8));
	}
	/**
	 * @param offset the offset to set
	 */
	public void setOffset(final BigInteger offset) {
		System.arraycopy(offset, 0, this.bytes, 8, 8);
	}
	/**
	 * @return the samples
	 */
	public int getSamples() {
		return new BigInteger(Arrays.copyOfRange(this.bytes, 16, 2)).intValue();
	}
	/**
	 * @param samples the samples to set
	 */
	public void setSamples(final int samples) {
		this.bytes[16] = (byte) (samples & 0xFF00 >> 1);
		this.bytes[17] = (byte) (samples & 0xFF);
	}


}
