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
		return ByteHelper.makeInt(blockData[0], blockData[1], blockData[2], blockData[3]);
	}
	
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(int applicationId) {
		blockData[0] = (byte) (applicationId >> 24);
		blockData[1] = (byte) (applicationId >> 16);
		blockData[2] = (byte) (applicationId >> 8);
		blockData[3] = (byte) applicationId;
	}
	
	/**
	 * @return the data
	 */
	public byte[] getData() {
		return Arrays.copyOfRange(blockData, 4, blockData.length - 4);
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(byte[] data) {
		System.arraycopy(data, 0, blockData, 4, data.length);
	}

}
