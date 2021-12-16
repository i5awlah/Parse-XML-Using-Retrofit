package com.example.parsexmlusingretrofit


import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import retrofit2.http.Field
import java.io.Serializable


@Root(name = "rss", strict = false)
class RssFeed constructor() : Serializable   {

    @field:Element(required = false, name = "channel")
    var channel: Channel? = null


}

@Root(name = "channel", strict = false)
class Channel @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    var title: String? = null,

    @field:Element(required = false, name = "description")
    @param:Element(name = "description")
    var description: String? = null,

//    @field:Element(name = "lastbuilddate")
//    @param:Element(name = "lastbuilddate")
//    var lastBuildDate: String? = null,

    @field:Element(name = "language")
    @param:Element(name = "language")
    var language: String? = null,

    @field:ElementList(inline = true, name = "item")
    var items: List<Items>? = null

) : Serializable {


}


@Root(name = "item", strict = false)
class Items constructor(): Serializable {
    @field:Element(name = "title")
    var title: String? = null
}

/*
package com.example.parsexmlusingretrofit


import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "rss", strict = false)
class RssFeed {
    @Element
    var channel: RssChannel? = null
    override fun toString(): String {
        return "RssFeed [channel=$channel]"
    }
}

@Root(name = "channel", strict = false)
class RssChannel {
    @Element
    private val title: String? = null

    @Element
    private val image: RssImage? = null

    @ElementList(inline = true, required = false)
    var items: List<RssItem>? = null
    override fun toString(): String {
        return "Channel [image=$image, item=$items]"
    }
}

@Root(name = "image", strict = false)
class RssImage {
    @Element
    private val url: String? = null

    @Element
    private val width: String? = null

    @Element
    private val height: String? = null
    override fun toString(): String {
        return "RssImage [url=$url, width=$width, height=$height]"
    }
}

@Root(name = "item", strict = false)
class RssItem {
    @Element
    val title: String? = null

    @Element
    val link: String? = null

    @Element
    val pubDate: String? = null

    @Element
    private val description: String? = null
    override fun toString(): String {
        return ("RssItem [title=" + title + ", link=" + link + ", pubDate=" + pubDate
                + ", description=" + description + "]")
    }
}
*/