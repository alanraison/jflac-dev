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

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.spi.AudioFileReader;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class FlacOggFileReader extends AudioFileReader {

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileReader#getAudioFileFormat(java.io.InputStream)
	 */
	@Override
	public AudioFileFormat getAudioFileFormat(final InputStream stream)
	throws UnsupportedAudioFileException, IOException {
		if (stream.markSupported()) {
			stream.mark(79);
		}


		return null;
	}

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileReader#getAudioFileFormat(java.net.URL)
	 */
	@Override
	public AudioFileFormat getAudioFileFormat(final URL url)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileReader#getAudioFileFormat(java.io.File)
	 */
	@Override
	public AudioFileFormat getAudioFileFormat(final File file)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileReader#getAudioInputStream(java.io.InputStream)
	 */
	@Override
	public AudioInputStream getAudioInputStream(final InputStream stream)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileReader#getAudioInputStream(java.net.URL)
	 */
	@Override
	public AudioInputStream getAudioInputStream(final URL url)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileReader#getAudioInputStream(java.io.File)
	 */
	@Override
	public AudioInputStream getAudioInputStream(final File file)
	throws UnsupportedAudioFileException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
