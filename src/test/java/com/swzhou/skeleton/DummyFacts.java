package com.swzhou.skeleton;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/24/12
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DummyFacts {

    @Test
    public void should_succeed() {
        assertThat(true, is(true));
    }
}
