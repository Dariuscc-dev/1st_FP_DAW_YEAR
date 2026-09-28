# Characteristics of markup lenguages.

## Contents 

- Markup lenguages
- Basic concepts
- Evolution
- Initiation to XML
- Name spacing

## Markup lenguages

Useful to add a markup/tag to content, it enables you to differentiate parts of a document, what every part means and how it should be displayed.

It is not a programming lenguage.

Some examples are = HTML, XML, Markdown...

```xml
<planetEarth>
    <age> 4.5 Billion Years </age>
    <diameter unit_of_measure = "kilometers"> 12800 </diameter>
</planetEarth>
```

Types of markup lenguages = Presentation, procedure, descriptive or semantic, and lean (LML).

## Basic concepts

It is plain text, inserted marking, intuitive elements, and versatility.
5 parts of markup lenguages = Content, labels/markup, element, atributes, and metadata.

A blank element has no content.

Metadata can indicate things like = Author, charset, and description.

## Evolution of markup lenguages

Every markup lenguage has a common origin = SGML.
It is very potent, although very complex as well.

SGML has = SGML declaration, DTD, document instance, and the parser.

HTML is for the web, based in SGML.

XML is the current most used alternative to SGML, still powerfull, less complex.

XML is extensible, descriptive, separate from the design, interoperable, strict, open.

## Initiation to XML 

Parts of an XML document are = Prologue, DOCTYPE and body.

There are also minimum rules in XML, as there are also special characters and entities in XML.´

Comments can be made using <!-- and -->

We use namespaces to prevent 2 names meaning different things.

```xml
<earthdata
    xmlns:water="https://www.usgs.gov/water-science-school/science/how-much-water-there-earth"
    xmlns:wood="https://eu.usatoday.com/story/news/2015/09/02/earth-three-trillion-trees/71578324/">
</earthdata>
```

Example of namespaces with prefixes.

```xml
<earthdata
    xmlns:wtr="https://www.usgs.gov/water-science-school/science/how-much-water-there-earth"
    xmlns:wd="https://eu.usatoday.com/story/news/2015/09/02/earth-three-trillion-trees/71578324/">
</earthdata>

<wtr:water>
    <water:amount = "Liters"> 1,386 × 10²¹ </water:amount>
</wtr:water>

<wd:wood>
    <wood:amount = "(European) Billions of kgs"> 1,386 × 10²¹ </wood:amount>
</wd:wood>
```