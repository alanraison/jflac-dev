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
package org.jflac.data.format.util;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class ByteHelper {
	public static int makeInt(final byte... b) {
		int res = 0;
		for (int i = b.length - 1, shift = 0; i >= 0; i--, shift += 8) {
			res |= ( b[i] & 0xFF ) << shift;
		}
		return res;
	}
}
