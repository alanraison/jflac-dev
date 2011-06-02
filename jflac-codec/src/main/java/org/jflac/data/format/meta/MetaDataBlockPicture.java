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

		private PictureType(final int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}

		public static PictureType getFromId(final int id) {
			for (final PictureType pictureType : PictureType.values()) {
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
