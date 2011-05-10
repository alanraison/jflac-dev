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

import java.io.File;

import junit.framework.TestCase;

/**
 * Abstract base class for test cases.
 *
 * @author <a href="jason@zenplex.com">Jason van Zyl</a>
 */
public abstract class AbstractTestCase extends TestCase {
    /** 
     * Basedir for all file I/O. Important when running tests from
     * the reactor.
     */
    public String basedir = System.getProperty("basedir");
    
    /**
     * Constructor.
     */
    public AbstractTestCase(String testName) {
        super(testName);
    }
    
    /**
     * Get test input file.
     *
     * @param path Path to test input file.
     */
    public String getTestFile(String path) {
        return new File(basedir,path).getAbsolutePath();
    }
}
