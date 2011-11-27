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

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import java.util.Map;

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
	public FlacFileFormat(final Type type, final AudioFormat format, final int frameLength,
			final Map<String, Object> properties) {
		super(type, format, frameLength, properties);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param type
	 * @param format
	 * @param frameLength
	 */
	public FlacFileFormat(final Type type, final AudioFormat format, final int frameLength) {
		super(type, format, frameLength);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param type
	 * @param byteLength
	 * @param format
	 * @param frameLength
	 */
	public FlacFileFormat(final Type type, final int byteLength, final AudioFormat format,
			final int frameLength) {
		super(type, byteLength, format, frameLength);
		// TODO Auto-generated constructor stub
	}


}
