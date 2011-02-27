/**
 *
 */
package org.kc7bfi.jflac;


/**
 * Contains working data for a block of uncompressed audio data for FLAC compression.
 *
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class Block {
	private final int channels;
	SubBlock[] subBlocks;

	public Block(final int channels, final int blockSize) {
		this.channels = channels;
		subBlocks = new SubBlock[channels];
		for (int i = 0; i < channels; i++) {
			subBlocks[i] = new SubBlock(blockSize);
		}
	}

	int getChannels() {
		return channels;
	}
}
