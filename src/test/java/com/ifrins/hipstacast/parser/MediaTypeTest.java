package com.ifrins.hipstacast.parser;

import com.ifrins.hipstacast.parser.models.PodcastItemEnclosure;
import org.junit.*;

public class MediaTypeTest {

    @Test
    public void testAudioFormat() {
        int contentType = ParserUtils.getFileContentType("audio/mpeg");
        Assert.assertEquals("audio/mpeg is audio", contentType, PodcastItemEnclosure.TYPE_AUDIO);
    }

    @Test
    public void testVideoFormat() {
        int contentType = ParserUtils.getFileContentType("video/mp4");
        Assert.assertEquals("video/mp4 is audio", contentType, PodcastItemEnclosure.TYPE_VIDEO);
    }

}
