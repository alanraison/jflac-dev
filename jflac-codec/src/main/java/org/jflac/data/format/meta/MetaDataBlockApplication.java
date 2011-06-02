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

import java.util.Arrays;

import org.jflac.data.format.util.ByteHelper;


/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class MetaDataBlockApplication extends MetaDataBlockData {

	public MetaDataBlockApplication(final int blockLength) {
		super(blockLength);
	}

	/**
	 * @return the applicationId
	 */
	public int getApplicationId() {
		return ByteHelper.makeInt(this.blockData[0], this.blockData[1], this.blockData[2], this.blockData[3]);
	}

	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(final int applicationId) {
		this.blockData[0] = (byte) (applicationId >> 24);
		this.blockData[1] = (byte) (applicationId >> 16);
		this.blockData[2] = (byte) (applicationId >> 8);
		this.blockData[3] = (byte) applicationId;
	}

	/**
	 * @return the data
	 */
	public byte[] getData() {
		return Arrays.copyOfRange(this.blockData, 4, this.blockData.length - 4);
	}

	/**
	 * @param data the data to set
	 */
	public void setData(final byte[] data) {
		System.arraycopy(data, 0, this.blockData, 4, data.length);
	}

}
