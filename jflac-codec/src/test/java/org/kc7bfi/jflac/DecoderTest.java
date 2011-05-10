/**
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kc7bfi.jflac;


import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 *
 * @author <a href="mailto:jason@zenplex.com">Jason van Zyl</a>
 */
public class DecoderTest extends AbstractTestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DecoderTest( String testName ) {
        super( testName );
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( DecoderTest.class );
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertEquals( "maven kicks ass", "maven kicks ass" );
    }
}
