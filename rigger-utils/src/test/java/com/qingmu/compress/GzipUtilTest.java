package com.qingmu.compress;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GzipUtilTest {

    @Test
    void compress() {
        String compress = GzipUtil.compress("test");
        Assert.assertEquals("H4sIAAAAAAAAACtJLS4BAAx+f9gEAAAA",compress);
    }

    @Test
    void uncompress() {
        String compress = GzipUtil.uncompress("H4sIAAAAAAAAACtJLS4BAAx+f9gEAAAA");
        Assert.assertEquals("test",compress);
    }
}