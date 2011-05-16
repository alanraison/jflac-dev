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
package org.jflac.data.format.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author alanraison <alanraison@sourceforge.net>
 *
 */
public class ByteHelperTest {
	@Test
	public void testMakeInt() {
		for (int mul = 0; mul < 4; mul++) {
			final int index = 3 - mul;
			final int shift = (int) Math.pow(2, mul * 8);
			for (int i = 1; i < 255; i++) {
				final byte[] source = new byte[4]; //{ (byte) 0, (byte) 0, (byte) 0, (byte) 0 };
				source[index] = (byte) i;
				final int expected = i * shift;
				System.out.printf("i=%d, expected=%d, mul=%d, shift=%d%n", i, expected, mul, shift);
				Assert.assertEquals(expected, ByteHelper.makeInt(source));
				//if (i % 100 == 0) {
				//}
			}
		}
	}
}
