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


/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class MetaDataBlockSeekTable extends MetaDataBlockData {
	private final int count;
	/**
	 * @param blockLength
	 */
	public MetaDataBlockSeekTable(final int blockLength) {
		super(blockLength);
		this.count = blockLength / 18;
	}

	public Seekpoint[] getSeekpoints() {
		// TODO
		return null;
	}

	public void setSeekpoints(final Seekpoint[] seekpoints) {
		// TODO
	}

	public void setSeekpoint(final int index, final Seekpoint seekpoint) {
		// TODO
		if (index >= this.count) {
			throw new IndexOutOfBoundsException("Array contains " + this.count + " elements");
		}
	}
}
