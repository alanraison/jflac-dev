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
package org.jflac;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.spi.FormatConversionProvider;

import org.jflac.spi.FlacFormat;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class FlacToWavFormatConverter extends FormatConversionProvider {

	// We only support one target encoding (for now)
	private static final Encoding[] TARGET_ENCODINGS = { Encoding.PCM_SIGNED };

	@Override
	public Encoding[] getSourceEncodings() {
		return new Encoding[] { FlacFormat.FLAC };
	}

	@Override
	public Encoding[] getTargetEncodings() {
		return TARGET_ENCODINGS;
	}

	@Override
	public Encoding[] getTargetEncodings(final AudioFormat sourceFormat) {
		// Can convert FlacFormat streams only
		return sourceFormat instanceof FlacFormat ? TARGET_ENCODINGS : new Encoding[] {};
	}

	@Override
	public AudioFormat[] getTargetFormats(final Encoding targetEncoding,
			final AudioFormat sourceFormat) {
		return new AudioFormat[] { new AudioFormat(targetEncoding, sourceFormat.getSampleRate(),
				sourceFormat.getSampleSizeInBits(), sourceFormat.getChannels(),
				sourceFormat.getFrameSize(), sourceFormat.getSampleRate(),
				sourceFormat.isBigEndian()) };
	}

	@Override
	public AudioInputStream getAudioInputStream(final Encoding targetEncoding,
			final AudioInputStream sourceStream) {
		// TODO Auto-generated method stub
		//return new FlacToSignedPcmDecoderStream(stream, format, length);
		return null;
	}

	@Override
	public AudioInputStream getAudioInputStream(final AudioFormat targetFormat,
			final AudioInputStream sourceStream) {
		// TODO Auto-generated method stub
		return null;
	}

}
