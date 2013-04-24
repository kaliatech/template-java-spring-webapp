package com.mycompany.myproj.library1;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Library1JavaClassTest 
    extends TestCase
{
    public Library1JavaClassTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( Library1JavaClassTest.class );
    }

    public void testApp()
    {
        assertTrue( true );
    }
}
