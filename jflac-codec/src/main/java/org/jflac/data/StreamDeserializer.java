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
import java.util.Collection;

import org.jflac.FlacDataException;
import org.jflac.data.format.Frame;
import org.jflac.data.format.meta.MetaDataBlock;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public interface StreamDeserializer extends Deserializer<NativeFlacStream> {
	Collection<MetaDataBlock> readMetaData(InputStream is) throws IOException, FlacDataException;
	Frame readDataFrame(InputStream is) throws IOException, FlacDataException;
}
