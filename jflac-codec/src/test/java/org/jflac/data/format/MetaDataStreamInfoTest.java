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

import org.junit.Test;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class MetaDataStreamInfoTest {
	private static int TEST_INT_1 = 252334330;
	private static byte[] TEST_INT_1_BYTES = new byte[] {
		(byte) 0x0F, (byte) 0x0A, (byte) 0x50, (byte) 0xFA,
	};
	private static int TEST_INT_2 = Integer.MAX_VALUE;
	private static byte[] TEST_INT_2_BYTES = new byte[] {
		(byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
	};
	@Test
	public void testSerialization() {
		final MetaDataBlockStreamInfo si = new MetaDataBlockStreamInfo();
		si.setMinBlockSize(TEST_INT_1);
		si.setMaxBlockSize(TEST_INT_2);
	}
}
