/**
 *
 */
package org.kc7bfi.jflac;

/**
 * Contains working data for a FLAC sub block of uncompressed audio data.
 *
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class SubBlock {
	private final byte[] sample;
	public SubBlock(final int blockSize) {
		sample = new byte[blockSize];
	}

	public byte[] getSample() {
		return sample;
	}

	public void setSample(final byte[] sample) {
		System.arraycopy(sample, 0, this.sample, 0, this.sample.length);
	}
}
