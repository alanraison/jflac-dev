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

import org.jflac.data.Deserializer;
import org.jflac.data.impl.MetaDataBlockStreamInfoDeerializer;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public enum MetaDataBlockDataType {
	STREAMINFO(0, MetaDataBlockStreamInfoDeerializer.getInstance());

	private int id;
	private Deserializer<? extends MetaDataBlockData> serializer;

	private MetaDataBlockDataType(final int id, Deserializer<? extends MetaDataBlockData> serializer) {
		this.id = id;
		this.serializer = serializer;
	}

	public static MetaDataBlockDataType getFromId(final int id) {
		for (final MetaDataBlockDataType type : MetaDataBlockDataType.values()) {
			if (type.id == id) {
				return type;
			}
		}
		return null;
	}
	
	public Deserializer<? extends MetaDataBlockData> serializer() {
		return this.serializer;
	}
}
