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
