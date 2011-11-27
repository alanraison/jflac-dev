/*
 * Copyright 2011 The jFLAC Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jflac.spi;

import org.jflac.FlacDataException;
import org.jflac.data.NativeFlacStream;
import org.jflac.data.format.meta.MetaDataBlockStreamInfo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class FlacNativeFileReader extends BaseAudioFileReader {

	@Override
	public FlacFileFormat getAudioFileFormat(final InputStream stream)
	throws UnsupportedAudioFileException, IOException {
		// Mark the stream so that we can reset afterwards (if possible)
		if (stream.markSupported()) {
			// Long enough for fLaC stream marker, a METADATA_BLOCK_HEADER and the first METADATA_BLOCK_STREAMINFO block
			stream.mark(42);
		}

		final NativeFlacStream flacStream = new NativeFlacStream(stream);

		try {
			if (!flacStream.readFlacHeader()) {
				throw new FlacDataException("Could not locate FLAC file marker");
			}

			MetaDataBlockStreamInfo streamInfo;
			streamInfo = flacStream.getFirstStreamInfo();

			final FlacFormat format = new FlacFormat(streamInfo.getSampleRate(), streamInfo.getBitsPerSample(),
					streamInfo.getChannels(), streamInfo.getMaxFrameSize(), AudioSystem.NOT_SPECIFIED);
			final FlacFileFormat fileFormat = new FlacFileFormat(FlacFileFormat.FLAC_NATIVE, format,
					(int) streamInfo.getNumberOfSamples());
			return fileFormat;

		} catch (final FlacDataException e) {
			stream.reset();
			throw new UnsupportedAudioFileException(e.getMessage());
		}
	}

	@Override
	public AudioInputStream getAudioInputStream(final InputStream stream)
	throws UnsupportedAudioFileException, IOException {
		final FlacFileFormat fileFormat = getAudioFileFormat(stream);

		return new AudioInputStream(stream, fileFormat.getFormat(), fileFormat.getFrameLength());
	}

}
