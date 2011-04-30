/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jflac.format;

import java.io.InputStream;
import java.util.Collection;

/**
 * @author alanraison <alanraison@users.sourceforge.net>
 * 
 */
public class FlacStream implements FlacDataBlock {
	/** FLAC stream identifier */
	public static final byte[] FLAC_HEADER = new byte[] { (byte) 0x66,
			(byte) 0x4C, (byte) 0x61, (byte) 0x43, };

	private final byte[] header = new byte[4];
	private MetaDataBlock streamInfo;
	private Collection<MetaDataBlock> metaData;
	private Collection<Frame> frames;

	public boolean isFlacStream() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jflac.format.FlacDataBlock#read(java.io.InputStream)
	 */
	@Override
	public void read(final InputStream stream) {
		str
	}
}
