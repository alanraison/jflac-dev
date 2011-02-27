/**
 *
 */
package org.kc7bfi.jflac;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Tests {@link FixedSizeBlockFactory}
 *
 * @author alanraison <alanraison@users.sourceforge.net>
 *
 */
public class FixedSizeBlockFactoryTest {
	private static final String TEST_WAV = "/testdata/Snare-Drum-8.wav";
	FixedSizeBlockFactory factory;

	@Test
	public void testBlockerSimple() {
		final Block expected = new Block(1, 10);
		final byte[] test_sample = new byte[] {
				(byte) 0,
				(byte) 1,
				(byte) 2,
				(byte) 3,
				(byte) 4,
				(byte) 5,
				(byte) 6,
				(byte) 7,
				(byte) 8,
				(byte) 9
		};
		expected.subBlocks[0].setSample(test_sample);

		final Block actual = factory.createBlock(44100f, 10, 1);
		Assert.assertNotNull("Created non null block", actual);
		Assert.assertEquals("Channels", expected.getChannels(), actual.getChannels());
		//Assert.assertEquals("Block SIze", //expected.subBlocks.)
	}

	@Test
	public void testFromWav() throws UnsupportedAudioFileException, IOException {
		final AudioInputStream stream = AudioSystem.getAudioInputStream(
				getClass().getResourceAsStream(TEST_WAV));
		final Block actual = factory.createBlock(stream);

		Assert.assertNotNull("Created non null block", actual);
		Assert.assertEquals("channels", 2, actual.getChannels());
		Assert.assertEquals("Sample Size", 24000, actual.subBlocks[0].getSample().length);
	}
}
