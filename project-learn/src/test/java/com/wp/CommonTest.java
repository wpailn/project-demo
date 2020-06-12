package com.wp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.http.util.CharsetUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CommonTest {
    @Test
    public void objectTest() throws IOException {
        //System.out.println(StandardCharsets.UTF_8.name());
        //FileUtils.writeStringToFile(new File("C:\\file\\test.txt"),"我是123\n666",StandardCharsets.UTF_8.name());
        List strings = FileUtils.readLines(new File("C:\\file\\test.txt"), StandardCharsets.UTF_8.name());
        System.out.println(strings.toString());
    }
}
