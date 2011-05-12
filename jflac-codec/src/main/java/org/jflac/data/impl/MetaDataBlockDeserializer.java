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
package org.jflac.data.impl;

import java.io.IOException;
import java.io.InputStream;

import org.jflac.data.Deserializer;
import org.jflac.data.format.MetaDataBlock;
import org.jflac.data.format.MetaDataBlockData;
import org.jflac.data.format.MetaDataBlockHeader;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class MetaDataBlockDeserializer implements Deserializer<MetaDataBlock> {
	private static MetaDataBlockDeserializer instance = new MetaDataBlockDeserializer();
	
	public static MetaDataBlockDeserializer getInstance() {
		return instance;
	}
	
	private MetaDataBlockDeserializer() {
		// Private constructor;
	}

	@Override
	public MetaDataBlock read(InputStream is) throws IOException {
		MetaDataBlock mdb = new MetaDataBlock();
		mdb.setHeader(MetaDataBlockHeader.read(is));
		MetaDataBlockData data;
		return mdb;
	}

}
