/**
 * 
 */
package org.kc7bfi.jflac.sound.spi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.spi.AudioFileWriter;

import org.kc7bfi.jflac.Block;
import org.kc7bfi.jflac.Decorrelator;
import org.kc7bfi.jflac.FLACEncoder;
import org.kc7bfi.jflac.Predictor;

/**
 * @author alanraison
 * 
 */
public class FlacAudioFileWriter extends AudioFileWriter {
	Block blocker;
	Decorrelator decorrelator;
	Predictor predictor;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type[] getAudioFileTypes() {
		return new Type[] { FlacFileFormatType.FLAC };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type[] getAudioFileTypes(final AudioInputStream stream) {
		if (stream.getFormat() instanceof FlacAudioFormat) {
			return new Type[] { FlacFileFormatType.FLAC };
		}
		return new Type[] {};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int write(final AudioInputStream stream, final Type fileType,
			final OutputStream out) throws IOException {
		int written = 0;
		if (fileType.equals(FlacFileFormatType.FLAC)) {
			final FLACEncoder enc = new FLACEncoder();
			written = enc.encode(stream);
		}
		// return the number of bytes written
		return written;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sound.sampled.spi.AudioFileWriter#write(javax.sound.sampled.
	 * AudioInputStream, javax.sound.sampled.AudioFileFormat.Type, java.io.File)
	 */
	@Override
	public int write(final AudioInputStream stream, final Type fileType,
			final File out) throws IOException {
		final OutputStream os = new FileOutputStream(out);
		return write(stream, fileType, os);
	}

}
