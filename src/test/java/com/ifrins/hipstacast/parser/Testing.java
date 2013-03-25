package com.ifrins.hipstacast.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

import com.ifrins.hipstacast.parser.models.PodcastChannel;
import com.ifrins.hipstacast.parser.models.PodcastImage;
import com.ifrins.hipstacast.parser.models.PodcastItem;
import com.ifrins.hipstacast.parser.models.PodcastItemEnclosure;
import com.ifrins.hipstacast.parser.models.PodcastRss;
import com.sjl.dsl4xml.DocumentReader;
import com.sjl.dsl4xml.XmlReadingException;

import static com.sjl.dsl4xml.SAXDocumentReader.*;

public class Testing {
	private static DocumentReader<PodcastRss> reader;
	
	public Testing() {
		
	}
	
	public static void main(String[] args) throws XmlReadingException, FileNotFoundException {
		long ti = System.nanoTime();
		
		
		reader = mappingOf("rss", PodcastRss.class).to(
					tag("channel", PodcastChannel.class).with(
						tag("title"),
						tag("link"),
						tag("description"),
						tag("itunes:image", PodcastImage.class).with(attributes("href")),
						tag("item", PodcastItem.class).with( 
							tag("title"),
							tag("link"),
							tag("pubDate"),
							tag("itunes:duration").withPCDataMappedTo("duration"),
							tag("description"),
							tag("enclosure", PodcastItemEnclosure.class).with(
								attributes("url", "length", "type")
							)
						)
					)
				);
		reader.registerConverters(new ThreadSafeDateLocaleConverter("EEE, dd MMM yyyy HH:mm:ss Z"));
		
		PodcastRss n = reader.read(new FileInputStream("/Users/francesc/Downloads/podcast.xml"), "utf-8");//
		
		
		
		long to = System.nanoTime();
		System.out.println("TITLE: " + n.channel.title);
		System.out.println("IMAGE: " + n.channel.image.href);
		System.out.println("ITEMS: " + n.channel.items.get(0).duration);

		System.out.println(String.format("PERFORMANCE: %dms", (to - ti)/1000000));
	}
}
