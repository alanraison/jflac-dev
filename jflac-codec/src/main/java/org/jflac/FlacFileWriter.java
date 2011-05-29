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
