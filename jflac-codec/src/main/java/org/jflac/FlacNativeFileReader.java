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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.spi.AudioFileReader;

import org.jflac.data.format.meta.MetaDataBlockHeader;
import org.jflac.spi.FlacFileFormat;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class FlacNativeFileReader extends AudioFileReader {
	/** The FLAC identifier block */
	public static final byte[] FLAC_ID = { (byte) 0x66, (byte) 0x4C,
		(byte) 0x61, (byte) 0x43 };
	/** Byte Order of FLAC files */
	private static final boolean BIG_ENDIAN = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sound.sampled.spi.AudioFileReader#getAudioFileFormat(java.io.
	 * InputStream)
	 */
	@Override
	public AudioFileFormat getAudioFileFormat(final InputStream stream)
	throws UnsupportedAudioFileException, IOException {
		// Mark the stream so that we can reset afterwards (if possible)
		if (stream.markSupported()) {
			// Long enough for fLaC stream marker, a METADATA_BLOCK_HEADER and the first METADATA_BLOCK_STREAMINFO block
			stream.mark(42);
		}
		try {
			final byte[] read = new byte[4];
			stream.read(read);

		} catch (final IOException e) {
			throw new UnsupportedAudioFileException("Could not locate FLAC file marker");
		}

		final AudioFileFormat aff = new FlacFileFormat(FlacFileFormat.FLAC_NATIVE, null, 0, null);

		final byte[] header = new byte[4];
		stream.read(header);

		if (!Arrays.equals(FLAC_ID, header)) {
			return null;
		}

		final MetaDataBlockHeader mdbHeader = new MetaDataBlockHeader();
		try {
			mdbHeader.read(stream);
		} catch (final FlacDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final float sampleRate;

		// Look for Sample Size
		final int sampleSizeInBits;

		// Look for channels
		final int channels;

		// FrameSize
		final int frameSize;

		final float frameRate;

		final boolean bigEndian;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.sound.sampled.spi.AudioFileReader#getAudioFileFormat(java.net.URL)
	 */
	@Override
	public AudioFileFormat getAudioFileFormat(final URL url)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.sound.sampled.spi.AudioFileReader#getAudioFileFormat(java.io.File)
	 */
	@Override
	public AudioFileFormat getAudioFileFormat(final File file)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sound.sampled.spi.AudioFileReader#getAudioInputStream(java.io.
	 * InputStream)
	 */
	@Override
	public AudioInputStream getAudioInputStream(final InputStream stream)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.sound.sampled.spi.AudioFileReader#getAudioInputStream(java.net.URL)
	 */
	@Override
	public AudioInputStream getAudioInputStream(final URL url)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.sound.sampled.spi.AudioFileReader#getAudioInputStream(java.io.File)
	 */
	@Override
	public AudioInputStream getAudioInputStream(final File file)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
