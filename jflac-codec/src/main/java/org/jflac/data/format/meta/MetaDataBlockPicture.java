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
public class MetaDataBlockPicture extends MetaDataBlockData {

	// TODO: this should probably be available in the public API
	public static enum PictureType {
		/** Other */
		OTHER(0),
		/** 32x32 'file icon' (PNG) */
		FILE_ICON(1),
		/** Other file icon */
		OTHER_FILE_ICON(2),
		/** Cover (front) */
		FRONT_COVER(3),
		/** Cover (back) */
		BACK_COVER(4),
		/** Leaflet page */
		LEAFLET(5),
		/** Media (e.g. label side of CD */
		MEDIA(6),
		/** Lead Artist/lead performer/soloist */
		LEAD_ARTIST(7),
		/** Artist/Performer */
		ARTIST(8),
		/** Conductor */
		CONDUCTOR(9),
		/** Band/Orchestra */
		BAND(10),
		/** Composer */
		COMPOSER(11),
		/** Lyricist/text writer */
		LYRICIST(12),
		/** Recording Location */
		RECORDING_LOCATION(13),
		/** During recording */
		DURING_RECORDING(14),
		/** During performance */
		DURING_PERFORMANCE(15),
		/** Movie/video screen capture */
		MOVIE(16),
		/** A bright coloured fish (?!) */
		FISH(17),
		/** Illustration */
		ILLUSTRATION(18),
		/** Band/artist logotype */
		BAND_LOGO(19),
		/** Publisher/Studio logotype */
		PUBLISHER_LOGO(20);
		
		private int id;
		
		private PictureType(int id) {
			this.id = id;
		}
		
		public int getId() {
			return this.id;
		}
		
		public static PictureType getFromId(int id) {
			for (PictureType pictureType : PictureType.values()) {
				if (pictureType.getId() == id) {
					return pictureType;
				}
			}
			return null;
		}
	}
	
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
	
	public void setMimeType(String mimeType) {
		// TODO
		// remember to set mimetype length
	}
	
	public String getDescription() {
		// TODO
		return null;
	}
	
	public void setDescription(String description) {
		// TODO
		// remember to set description length
	}
	
	public int getWidth() {
		// TODO
		return 0;
	}
	
	public void setWidth(int width) {
		// TODO
	}
	
	public int getHeight() {
		// TODO
		return 0;
	}
	
	public void setHeight(int height) {
		// TODO
	}
	
	public int getDepth() {
		// TODO
		return 0;
	}
	
	public void setDepth(int depth) {
		// TODO
	}
	
	public int getIndexedColourCount() {
		// TODO
		return 0;
	}
	
	public void setIndexedColourCount(int count) {
		// TODO
	}
	
	public byte[] getPictureData() {
		// TODO
		return null;
	}
	
	public void setPictureData(byte[] data) {
		// TODO
		// remember to set length of data
	}
}
