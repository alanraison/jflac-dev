/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jflac.data.format;

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
		this.applicationId = applicationId;
	}
	
	/**
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}

}
