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
public class MetaDataBlockPicture extends MetaDataBlockData {

	/**
	 * @param blockLength
	 */
	public MetaDataBlockPicture(final int blockLength) {
		super(blockLength);
		// TODO Auto-generated constructor stub
	}

	public String getMimeType() {
		// TODO: complete
		return null;
	}

	public void setMimeType(final String mimeType) {
		// TODO
		// remember to set mimetype length
	}

	public String getDescription() {
		// TODO
		return null;
	}

	public void setDescription(final String description) {
		// TODO
		// remember to set description length
	}

	public int getWidth() {
		// TODO
		return 0;
	}

	public void setWidth(final int width) {
		// TODO
	}

	public int getHeight() {
		// TODO
		return 0;
	}

	public void setHeight(final int height) {
		// TODO
	}

	public int getDepth() {
		// TODO
		return 0;
	}

	public void setDepth(final int depth) {
		// TODO
	}

	public int getIndexedColourCount() {
		// TODO
		return 0;
	}

	public void setIndexedColourCount(final int count) {
		// TODO
	}

	public byte[] getPictureData() {
		// TODO
		return null;
	}

	public void setPictureData(final byte[] data) {
		// TODO
		// remember to set length of data
	}
}
