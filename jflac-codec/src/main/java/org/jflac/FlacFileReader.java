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

import org.jflac.data.impl.StreamSerializer;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class FlacFileReader extends AudioFileReader {
	/** The FLAC identifier block */
	public static final byte[] FLAC_ID = { (byte) 0x66, (byte) 0x4C,
			(byte) 0x61, (byte) 0x43 };

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
			stream.mark(5); // TODO: is this a sensible limit?
		}
		try {
			StreamSerializer.getInstance().read(stream);
		} catch (IOException e) {
			throw new UnsupportedAudioFileException("Could not locate FLAC file marker");
		}
		
		final byte[] header = new byte[4];
		stream.read(header);

		if (!Arrays.equals(FLAC_ID, header)) {
			return null;
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
