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
import java.io.OutputStream;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.spi.AudioFileWriter;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class FlacFileWriter extends AudioFileWriter {

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileWriter#getAudioFileTypes()
	 */
	@Override
	public Type[] getAudioFileTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileWriter#getAudioFileTypes(javax.sound.sampled.AudioInputStream)
	 */
	@Override
	public Type[] getAudioFileTypes(final AudioInputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileWriter#write(javax.sound.sampled.AudioInputStream, javax.sound.sampled.AudioFileFormat.Type, java.io.OutputStream)
	 */
	@Override
	public int write(final AudioInputStream stream, final Type fileType, final OutputStream out)
	throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.sound.sampled.spi.AudioFileWriter#write(javax.sound.sampled.AudioInputStream, javax.sound.sampled.AudioFileFormat.Type, java.io.File)
	 */
	@Override
	public int write(final AudioInputStream stream, final Type fileType, final File out)
	throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
