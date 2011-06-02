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
