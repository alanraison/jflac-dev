package org.kc7bfi.jflac.metadata;

/**
 * libFLAC - Free Lossless Audio Codec library
 * Copyright (C) 2001,2002,2003  Josh Coalson
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA.
 */

import java.io.IOException;

import org.kc7bfi.jflac.util.InputBitStream;

/**
 * An entry into the seek table.
 * @author kc7bfi
 */
public class SeekPoint {

    private static final int SEEKPOINT_SAMPLE_NUMBER_LEN = 64; // bits
    private static final int SEEKPOINT_STREAM_OFFSET_LEN = 64; // bits
    private static final int SEEKPOINT_FRAME_SAMPLES_LEN = 16; // bits

    protected long sampleNumber; // The sample number of the target frame.
    protected long streamOffset; // The offset, in bytes, of the target frame with respect to beginning of the first frame.
    protected int frameSamples; // The number of samples in the target frame.
    
    /**
     * The constructor.
     * @param is                The InputBitStream
     * @throws IOException      Thrown if error reading from InputBitStream
     */
    public SeekPoint(InputBitStream is) throws IOException {
        sampleNumber = is.readRawULong(SEEKPOINT_SAMPLE_NUMBER_LEN);
        streamOffset = is.readRawULong(SEEKPOINT_STREAM_OFFSET_LEN);
        frameSamples = is.readRawUInt(SEEKPOINT_FRAME_SAMPLES_LEN);
    }
    
    /**
     * The constructor.
     * @param sampleNumber  The sample number of the target frame
     * @param streamOffset  The offset, in bytes, of the target frame with respect to beginning of the first frame
     * @param frameSamples  The number of samples in the target frame
     */
    public SeekPoint(long sampleNumber, long streamOffset, int frameSamples) {
        this.sampleNumber = sampleNumber;
        this.streamOffset = streamOffset;
        this.frameSamples = frameSamples;
    }
}
