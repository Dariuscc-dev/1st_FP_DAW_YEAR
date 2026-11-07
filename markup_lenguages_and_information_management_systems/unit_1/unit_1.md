# Characteristics of Markup Languages

## Contents

- Markup languages
- Basic concepts
- Evolution
- Introduction to XML
- Namespaces

## Markup languages

A markup language adds marks (tags) to content. This lets you separate the parts of a document, say what each part means, and define how it should be displayed.

It is not a programming language.

Some examples: HTML, XML, Markdown...

```xml
<planetEarth>
    <age>4.5 billion years</age>
    <diameter unit="kilometers">12800</diameter>
</planetEarth>
```

Types of markup languages: presentational, procedural, descriptive (semantic), and lightweight markup languages (LML).

## Basic concepts

Main features: plain text, embedded markup, intuitive elements and versatility.

The 5 parts of a markup language: content, tags/marks, elements, attributes and metadata.

An empty element has no content.

Metadata can describe things like the author, the character set (charset) and a description.

## Evolution of markup languages

Most modern markup languages come from a common origin: SGML.
SGML is very powerful, but also very complex.

An SGML document has an SGML declaration, a DTD, the document instance and a parser.

HTML is the language of the web and is based on SGML.

XML is today the most widely used alternative to SGML. It is still powerful, but much less complex.

XML is extensible, descriptive, independent from presentation, interoperable, strict and open.

## Introduction to XML

The parts of an XML document are the prolog, the DOCTYPE declaration and the body.

XML has a set of minimum rules (well-formedness), and it also has special characters and entities.

Comments are written between `<!--` and `-->`.

Namespaces prevent conflicts when the same name means different things.

```xml
<earthdata
    xmlns:water="https://www.usgs.gov/water-science-school/science/how-much-water-there-earth"
    xmlns:wood="https://eu.usatoday.com/story/news/2015/09/02/earth-three-trillion-trees/71578324/">
</earthdata>
```

Example of namespaces with prefixes:

```xml
<earthdata
    xmlns:wtr="https://www.usgs.gov/water-science-school/science/how-much-water-there-earth"
    xmlns:wd="https://eu.usatoday.com/story/news/2015/09/02/earth-three-trillion-trees/71578324/">

    <wtr:water>
        <wtr:amount unit="liters">1.386 × 10²¹</wtr:amount>
    </wtr:water>

    <wd:wood>
        <wd:amount unit="trees">3 × 10¹²</wd:amount>
    </wd:wood>

</earthdata>
```

In this example, both elements are called "amount", but there is no conflict because each one belongs to a different namespace.
