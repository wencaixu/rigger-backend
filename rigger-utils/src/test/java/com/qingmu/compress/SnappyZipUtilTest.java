package com.qingmu.compress;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnappyZipUtilTest {

    @Test
    void compress() {
        String compress = SnappyZipUtil.compress("test");
        Assert.assertEquals("BAx0ZXN0",compress);
    }

    @Test
    void uncompress() {
        String compress = SnappyZipUtil.uncompress("BAx0ZXN0");
        Assert.assertEquals("test",compress);
    }
}