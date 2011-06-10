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

public enum ID3PictureType {
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

	private ID3PictureType(final int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public static ID3PictureType getFromId(final int id) {
		for (final ID3PictureType pictureType : ID3PictureType.values()) {
			if (pictureType.getId() == id) {
				return pictureType;
			}
		}
		return null;
	}
}