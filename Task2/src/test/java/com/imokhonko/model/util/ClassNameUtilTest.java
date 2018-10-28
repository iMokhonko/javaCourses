package com.imokhonko.model.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassNameUtilTest {

    @Test
    public void getCurrentClassName() {
        String currentClassName = this.getClass().getName();
        assertThat(currentClassName).isEqualTo(ClassNameUtil.getCurrentClassName());
    }
}