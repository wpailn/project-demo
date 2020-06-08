package com.wp;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class ApplicationTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Integer s = ObjectUtils.max(1,2,3);
        System.out.println(s);
    }
}
