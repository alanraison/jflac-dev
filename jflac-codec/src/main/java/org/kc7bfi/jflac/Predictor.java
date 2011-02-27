/**
 * 
 */
package org.kc7bfi.jflac;

import javax.sound.sampled.AudioInputStream;

/**
 * @author alan
 * 
 */
public interface Predictor {
	byte[] predict(AudioInputStream in);
}
