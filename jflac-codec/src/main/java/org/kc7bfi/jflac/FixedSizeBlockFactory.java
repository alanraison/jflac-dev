/**
 * 
 */
package org.kc7bfi.jflac;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/**
 * @author alan
 * 
 */
public class FixedSizeBlockFactory implements BlockFactory {
	private static final int DEFAULT_BLOCK_SIZE = 1152;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.kc7bfi.jflac.BlockFactory#createBlock(int, int, int)
	 */
	@Override
	public Block createBlock(final float sampleRate, final int sampleSize,
			final int channels) {
		final SubBlock[] sub = new SubBlock[channels];
		return null;
	}

	public Block createBlock(final AudioInputStream stream) {
		final AudioFormat format = stream.getFormat();
		if (format == null) {
			throw new IllegalArgumentException(
					"Audio Format not specified by stream");
		}
		final int channels = format.getChannels();
		if (channels == AudioSystem.NOT_SPECIFIED) {
			throw new IllegalArgumentException(
					"Number of channels not specified by stream");
		}
		final int blockSize = format.getSampleSizeInBits();
		if (blockSize == AudioSystem.NOT_SPECIFIED) {
			throw new IllegalArgumentException(
					"Sample Size not specified by stream");
		}
		final float sampleRate = format.getSampleRate();
		if (sampleRate == AudioSystem.NOT_SPECIFIED) {
			throw new IllegalArgumentException(
					"Sample Rate not specified by stream");
		}
		return createBlock(sampleRate, blockSize, channels);
	}
}
