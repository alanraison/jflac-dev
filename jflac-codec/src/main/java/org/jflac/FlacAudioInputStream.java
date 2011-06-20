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

import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.TargetDataLine;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class FlacAudioInputStream extends AudioInputStream {

	/**
	 * @param stream
	 * @param format
	 * @param length
	 */
	public FlacAudioInputStream(final InputStream stream, final AudioFormat format,
			final long length) {
		super(stream, format, length);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param line
	 */
	public FlacAudioInputStream(final TargetDataLine line) {
		super(line);
		// TODO Auto-generated constructor stub
	}


}
