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
package org.jflac.data.format.meta;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.jflac.FlacDataException;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class MetaDataBlockVorbisComment extends MetaDataBlockData {

	/**
	 * @param blockLength
	 */
	public MetaDataBlockVorbisComment(final int blockLength) {
		super(blockLength);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void read(final InputStream is) throws IOException, FlacDataException {
		super.read(is);
		// TODO Auto-generated method stub
	}

	@Override
	public void write(final OutputStream os) throws IOException {
		// TODO Auto-generated method stub

	}
}
