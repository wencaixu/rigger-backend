package com.qingmu.compress;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeflaterZipUtilTest {

    @Test
    void compress() {
        String compress = DeflaterZipUtil.compress("aaaa");
        Assert.assertEquals("eAFLTExMBAADzgGF",compress);
    }

    @Test
    void uncompress() {
        String compress = DeflaterZipUtil.uncompress("eAFLTExMBAADzgGF");
        Assert.assertEquals("aaaa",compress);
    }
}