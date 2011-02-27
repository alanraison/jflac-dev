/**
 * 
 */
package org.kc7bfi.jflac;

import javax.sound.sampled.AudioInputStream;

/**
 * @author alan
 * 
 */
public interface BlockFactory {
	Block createBlock(final float sampleRate, final int sampleSize,
			final int channels);

	Block createBlock(AudioInputStream stream);
}
