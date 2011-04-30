/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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
			stream.mark(1024); // TODO: is this a sensible limit?
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
