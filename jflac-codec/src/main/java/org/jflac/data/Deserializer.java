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
package org.jflac.data;

import java.io.IOException;
import java.io.InputStream;

/**
 * The mechanism for serializing and deserializing objects in a FLAC stream.
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 * @param <T> The object being serialized
 */
public interface Deserializer<T> {

	/**
	 * Read an object from the stream
	 * @return the object from the stream
	 * @throws IOException if there is a problem reading the stream
	 */
	T read(InputStream is) throws IOException;
}
