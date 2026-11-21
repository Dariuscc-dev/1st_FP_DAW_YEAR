# Unit 3: Content Syndication (RSS, Atom, Feeds and Aggregators)

## Overview & Contents
- **What syndication is:** source, feed, consumer, prosumer and aggregator.
- **Pros, cons and real-world uses**, and why syndication is not the same as duplicate content.
- **RSS and Atom:** standards, structure and differences.
- **Building a feed:** HTML `<link>` in the page head, the `.rss` / `.atom` file and a visible link.
- **Full RSS 2.0 and Atom examples.**
- **Tools:** editors, validators, directories and feed readers (plus OPML and RSS Bridge).
- **Practice exercises.**

## Block 1: The Concept of Syndication
Syndication lets a website distribute updated content through **channels** or **feeds** that users read with an **aggregator**.

A **content channel (feed)** is the set of services offered by the original site plus their metadata.

```text
Source (website) → Feed (XML file with news + metadata) → HTTP → Aggregator (feed reader) → User
```

- **XML** is the language used in syndication.
- **HTTP** is the protocol that transfers the feed.
- An **aggregator** is also called a feed reader.

| Role | What it does |
|---|---|
| **Producer / source** | Creates and publishes content (news, articles, podcasts...) |
| **Consumer** | Reads the content through a feed they subscribe to |
| **Prosumer** | Consumes and also produces content (typical of Web 2.0) |
| **Aggregator** | Manages subscriptions and shows the updates |

Simple example: a blog publishes posts, the feed summarizes them, and Feedly or Thunderbird shows them to the user.

### Linking a feed from an HTML page
```html
<link rel="alternate" type="application/rss+xml"
      title="Canal RSS" href="http://localhost/UD3/archivo.rss" />
<link rel="alternate" type="application/atom+xml"
      title="Canal Atom" href="http://localhost/UD3/archivo.atom" />
```

| Attribute | Meaning |
|---|---|
| `rel="alternate"` | An alternative version of the content is available |
| `type` | Whether the feed is RSS or Atom |
| `title` | Name of the feed link |
| `href` | Path to the `.rss` or `.atom` file |

### RSS/Atom vs HTML
| Format | Purpose | Example |
|---|---|---|
| **HTML** | Show content to people in a browser | A page with an article, images and styles |
| **RSS** | Send updates in XML to aggregators | Headline, link, description, date |
| **Atom** | Send and publish content with a stricter XML structure | Feed with `id`, `updated`, `author`, `entry` |
| **Aggregator** | Read and display the feed comfortably | Feedly, Inoreader, Thunderbird |

`.rss` and `.atom` files carry data for transmission. They are not full HTML pages.

### Advantages
- Up-to-date information without visiting each site.
- Saves time: many sources in one reader.
- Less email (less spam and malware risk).
- Loyalty: the site keeps users connected.
- Privacy: subscribing to a feed needs no personal data.
- Visibility: more referral traffic and reach.

### Disadvantages and risks
- **Plagiarism:** third parties may reuse content without credit.
- **Reliability:** users may stop checking whether a source is trustworthy.
- **Loss of control:** the author loses control over reuse.
- **Overload:** too much information for the subscriber.

### Where it is used
News sites, professional or educational updates, e-commerce promotions, podcasts and videocasts (including downloads), and comments in forums.

### Proper syndication vs duplicate content
| Concept | What happens | Effect |
|---|---|---|
| **Proper syndication** | A site republishes all or part of a piece, citing and linking the original | More reach, can improve visibility |
| **External duplicate content** | The same text appears on several domains without control | Can hurt SEO |
| **Internal duplicate content** | Content repeats inside the same domain (bad category or tag management) | Harder maintenance, can hurt SEO |

Syndicating is not just copying: there must be publishing conditions and a link to the original.

## Block 2: RSS and Atom
Both are XML-based, but they are not identical and they don't require the same data.

### RSS
**RSS (Really Simple Syndication)** is an XML data format that gives automated access to a website's information. A user can **receive** information (subscribe with an aggregator) or a site can **offer** it (publish its own RSS file). Typical content: title, link, date, description. The reader decides how it looks.

| Version | Name | Notes |
|---|---|---|
| RSS 0.91 | Rich Site Summary | Netscape, 1999, for headlines in My Netscape |
| RSS 1.0 | RDF Site Summary | RSS-DEV group, more stable and richer, based on RDF |
| RSS 2.0 | Really Simple Syndication | Harvard Law (after UserLand), the most used, supports XML namespaces |

This unit works with **RSS 2.0**.

### Atom
**Atom** is an XML format and publishing protocol created as an answer to the many RSS versions.

- **Atom Syndication Format:** reading information from feeds.
- **Atom Publishing Protocol:** adding or sending information.
- Atom 1.0 became an **IETF standard in December 2005**. It competes with RSS but is still less used.

### RSS vs Atom
| Aspect | RSS | Atom |
|---|---|---|
| Nature | Family of feed formats | Two standards: syndication + publishing |
| Minimum fields | Title, link, description | Updated date, title, unique id |
| Content | Plain text and HTML | Plain text, HTML, XHTML, XML, external references |
| Date format | RFC 822 | RFC 3339 / ISO 8601 |
| Language | No language per item | `xml:lang` |
| Modularity | Doesn't reuse elements outside RSS | Can reuse elements outside the feed |

## Block 3: Feed Structure
### Feed is not the same as RSS
| Term | Meaning | Typical mistake |
|---|---|---|
| Web feed / channel | The way web content is redistributed | Saying every feed "is RSS" |
| RSS | One possible feed format | Mixing the format with the general concept |
| Atom | Another possible feed format | Thinking Atom always replaces RSS |
| `.rss` / `.atom` file | XML document published by the site | Treating it like a normal HTML page |

"Are RSS and feed the same thing?" No. RSS is one **format** of feed.

### General structure of a feed
- **XML declaration:** version and encoding (normally UTF-8).
- **Channel element:** the website the feed belongs to.
- **Sections:** references to specific content or services.
- **Links:** one feed can have many links to different updates.

### Steps to create a feed
1. Create the RSS/Atom XML.
2. Add the version and channel data.
3. Add sections with links.
4. Save as `.rss` / `.atom` (it is still XML).
5. Validate it and upload it to the server.

Then add a visible indicator on the page (RSS icon, XML or text), link it to the file, and register the feed in directories if needed.

```html
<a href="caso_practico_3.rss">
  <img src="rss.png" alt="RSS" width="80" height="35" />
</a>
```

### RSS 2.0 skeleton
```xml
<?xml version="1.0" encoding="utf-8"?>
<rss version="2.0">
  <channel>
    <!-- channel properties -->
    <item><!-- published content 1 --></item>
    <item><!-- published content 2 --></item>
  </channel>
</rss>
```

`rss` is the root and states the version, `channel` is the feed itself, `item` is each entry. The XML must be well formed.

| Channel element | Purpose |
|---|---|
| `title` | Name of the site or feed |
| `link` | URL of the page linked to the feed |
| `description` | What the site or feed is about |
| `language` | Language of the site |
| `item` | Each entry of the feed |

| Item element | Purpose |
|---|---|
| `title` | Title of the content |
| `link` | Link to the full content |
| `guid` | Globally unique id, helps tell new entries from read ones |
| `description` | Summary |
| `category` | Classification, can appear several times |

### Full RSS example
```xml
<?xml version="1.0" encoding="utf-8"?>
<rss version="2.0">
  <channel>
    <title>Ejemplo de canal</title>
    <link>http://localhost</link>
    <description>Este es un archivo RSS</description>
    <item>
      <title>Qué es el RSS</title>
      <link>http://localhost/UD3/define_RSS.html</link>
      <description>Define el estándar RSS</description>
      <guid>http://localhost/UD3/01</guid>
    </item>
  </channel>
</rss>
```

### Image and copyright in RSS
```xml
<image>
  <url>http://localhost/UD3/imagenes/rss.png</url>
  <link>http://localhost</link>
  <title>Ejemplo de canal</title>
</image>
<copyright>© 2026 Mi sitio web</copyright>
```

`image` goes inside `channel` but outside any `item`. Its `title` and `link` must match the channel's `title` and `link`.

### Atom skeleton
```xml
<?xml version="1.0" encoding="utf-8"?>
<feed xmlns="http://www.w3.org/2005/Atom">
  <title>Ejemplo archivo Atom</title>
  <link href="http://localhost" />
  <updated>2021-10-13T18:30:02Z</updated>
  <author><name>Profesor</name></author>
  <id>urn:uuid:60a76c80-d399-11d9-b93C</id>
  <entry><!-- feed entry --></entry>
</feed>
```

| Feed element | Purpose |
|---|---|
| `title` | Name of the site or feed |
| `id` | Feed identifier, usually a URL or URN |
| `link` | `self` for the `.atom` file itself, `alternate` for the website |
| `updated` | Date and time, format `YYYY-MM-DDTHH:MM:SSZ` |
| `author` | Author of the feed |
| `entry` | Each entry of the feed |

An `entry` has `title`, `id` (unique), `link` (`rel="alternate"`), `updated`, `author` and `summary`.

```xml
<entry>
  <title>Ejemplo archivo Atom</title>
  <link href="http://localhost/2021/10/13/atom01" />
  <id>urn:uuid:1225c695-cfb8-4ebb-aaaa</id>
  <updated>2021-10-13T18:30:02Z</updated>
  <summary>Simplemente un ejemplo de prueba.</summary>
</entry>
```

`entry` in Atom is the equivalent of `item` in RSS.

## Block 4: Editing and Validation
| Tool | Type | Notes |
|---|---|---|
| **Visual Studio Code** | Free, open editor | Recommended for XML, RSS and Atom |
| **Atom** | Free code editor | Built on Chromium and Node.js, by GitHub |
| **Aptana Studio** | Eclipse-based IDE | Many languages and plugins |
| **PSPad** | Freeware editor (Windows) | XML, CSS and RSS support |

Useful VS Code extensions: **RSS** (built-in reader), **RSS-reader** (up to 10 feeds in a side widget) and **HTML/XML/RSS link checker** (broken links).

**Validating** means checking that the file is syntactically correct and follows its standard. You can validate by URL or by pasting the code. It does not tell you the content is good, only that the file follows the technical rules.

Known validators: **W3C Feed Validation Service** (by URI or by pasted code) and the **RSS Advisory Board**. Watch out for accents, `<`, `>` and wrong encoding: use **UTF-8**.

### Typical mistakes
- Not closing tags (opening `<item>` and forgetting `</item>`).
- Wrong encoding (not UTF-8).
- Broken paths in `link`.
- Repeated `guid` (the reader can't tell new from read entries).
- Badly formatted dates (especially `updated` in Atom).
- Mixing structures (`item` inside Atom or `entry` inside RSS).

## Block 5: Directories and Aggregators
To list a feed in a directory you register the RSS file there. Examples: El País, El Mundo, Iblnews, RSS Search Engine Roundtable, Moz Blog, Search Engine Journal.

- **Paid syndication:** paying to place content in big publications (Outbrain, Taboola).
- **Free syndication:** the author spreads their own content on other sites.

### Aggregators (feed readers)
A program, website, browser or mail client that subscribes to RSS/Atom feeds. They centralize sources, organize them by topic, sync and notify updates, and let you mark as read, save or read later.

| Type | Examples | Key trait |
|---|---|---|
| Desktop | Feedreader, Akregator, RSSOwl | Can cache news to read later |
| Online | Netvibes, Feedly, Inoreader | Web access, sync across devices |
| Browser | Feedbro, RSS Subscriptions | Browser extensions |
| Email client | Mozilla Thunderbird, Outlook Express | Read feeds from your mail client |

Other readers: **Akregator** (KDE/Linux, categories), **RSSOwl** (cross-platform, filters, podcasts, needs Java), **Newsblur** (sorts feeds by your preferences), **Feedly** (web, iOS, Android), **Inoreader** (similar to Feedly).

Feedbro example: search for a site with RSS, copy the feed URL, open Feedbro in Firefox, add the URL and get notified of updates.

- **OPML (Outline Processor Markup Language):** XML format used to export and import lists of feeds between readers or keep a backup.
- **RSS Bridge:** PHP web service that **creates** feeds (Atom, HTML, JSON...) for sites that don't offer one (X/Twitter, Wikipedia, YouTube, Instagram...). It is not a reader.

Other ways to distribute content: social networks, email, Google Alerts, influencers, mobile app push notifications and promoted content.

## Cheat Sheet
| Clue | Answer |
|---|---|
| Uses `<feed>` and `<entry>` | Atom |
| Uses `<rss>`, `<channel>` and `<item>` | RSS |
| Requires `updated` with date and time | Atom |
| Only title, link and description are mandatory | RSS |
| Allows `xml:lang` | Atom |
| Most used format today | RSS 2.0 |
| Link a feed from a page | `<link rel="alternate" type="application/rss+xml" ...>` |
| Recommended encoding | UTF-8 |

## Practice Exercises (solved)
**1. Complete the RSS.** A channel "Blog DAW" has `title`, `link` and `description`. Add an entry.

```xml
<item>
  <title>Primera entrada</title>
  <link>https://ejemplo.com/primera-entrada</link>
  <description>Resumen de la entrada</description>
  <guid>https://ejemplo.com/01</guid>
</item>
```

It goes inside `<channel>`.

**2. Find the error.**

```xml
<feed xmlns="http://www.w3.org/2005/Atom">
  <title>Canal de prueba</title>
  <item><title>Entrada 1</title></item>
</feed>
```

It is Atom (root `<feed>`), so entries must be `<entry>`, not `<item>` (that belongs to RSS). It is also missing `id` and `updated`.

**3. Identify the format.** A document with `<rss version="2.0">`, `<channel>`, `<item>` and `<guid>` is **RSS**.

## Exam Checklist
- Define syndication, feed, web source, RSS, Atom and aggregator.
- Tell apart feed vs RSS, and syndication vs duplicate content.
- Read RSS and Atom code and spot errors.
- Build a basic feed with title, link, description, item/entry and ids.
- Explain what validators do and why UTF-8 matters.
- Know what directories, aggregators, readers and OPML are for.

The unit works best as a process: **publish → structure in XML → validate → link → read with an aggregator.**
