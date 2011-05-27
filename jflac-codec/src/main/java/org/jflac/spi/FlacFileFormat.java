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

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class FlacFileFormat extends AudioFileFormat {

	/** The FLAC file type */
	public static final Type FLAC_NATIVE = new Type("FLAC", "flac");
	public static final Type FLAC_OGG = new Type("OGG", "ogg");
	
	/**
	 * @param type
	 * @param format
	 * @param frameLength
	 * @param properties
	 */
	public FlacFileFormat(Type type, AudioFormat format, int frameLength,
			Map<String, Object> properties) {
		super(type, format, frameLength, properties);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param type
	 * @param format
	 * @param frameLength
	 */
	public FlacFileFormat(Type type, AudioFormat format, int frameLength) {
		super(type, format, frameLength);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param type
	 * @param byteLength
	 * @param format
	 * @param frameLength
	 */
	public FlacFileFormat(Type type, int byteLength, AudioFormat format,
			int frameLength) {
		super(type, byteLength, format, frameLength);
		// TODO Auto-generated constructor stub
	}

	
}
