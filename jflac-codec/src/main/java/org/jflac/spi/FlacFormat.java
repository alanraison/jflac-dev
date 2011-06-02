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
package org.jflac.spi;

import java.util.Map;

import javax.sound.sampled.AudioFormat;

/**
 * @author alan.raison
 *
 */
public class FlacFormat extends AudioFormat {

	private static final boolean BIG_ENDIAN = true;
	/**
	 * @param encoding
	 * @param sampleRate
	 * @param sampleSizeInBits
	 * @param channels
	 * @param frameSize
	 * @param frameRate
	 * @param properties
	 */
	public FlacFormat(final Encoding encoding, final float sampleRate,
			final int sampleSizeInBits, final int channels, final int frameSize, final float frameRate,
			final Map<String, Object> properties) {
		super(encoding, sampleRate, sampleSizeInBits, channels, frameSize, frameRate,
				BIG_ENDIAN, properties);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param encoding
	 * @param sampleRate
	 * @param sampleSizeInBits
	 * @param channels
	 * @param frameSize
	 * @param frameRate
	 */
	public FlacFormat(final Encoding encoding, final float sampleRate,
			final int sampleSizeInBits, final int channels, final int frameSize, final float frameRate) {
		super(encoding, sampleRate, sampleSizeInBits, channels, frameSize, frameRate,
				BIG_ENDIAN);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sampleRate
	 * @param sampleSizeInBits
	 * @param channels
	 * @param signed
	 */
	public FlacFormat(final float sampleRate, final int sampleSizeInBits, final int channels,
			final boolean signed) {
		super(sampleRate, sampleSizeInBits, channels, signed, BIG_ENDIAN);
		// TODO Auto-generated constructor stub
	}

}
