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
