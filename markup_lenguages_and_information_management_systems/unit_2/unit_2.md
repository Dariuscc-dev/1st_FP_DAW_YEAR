# Unit 2: Markup Languages in Web Environments

## Contents

- **Web Standards:** W3C, WHATWG, HTML5, XHTML, and CSS3.
- **Complete Structure** of an HTML5 Document.
- **HTML Tags:** Text, links, images, lists, tables, semantics, and multimedia.
- **Forms:** Controls, attributes, validation, data submission, `progress`, and `meter`.
- **CSS:** Syntax, selectors, cascade, specificity, inheritance, and properties.
- **Practical Code Examples** and typical exam errors.

## Web standards

They are there to serve a purpose, to make the web open, accessible and open.

We follow web standards to facilitate the work of functions like =

- Maintainement
- Compatibility
- Accessibility
- SEO and performance

## Standards organizations and main technologies
- W3C: standardization of web technologies and accessibility (e.g., accessibility recommendations, XML, CSS).
- WHATWG: living evolution of the HTML standard (e.g., continuous HTML updates).
- ECMA: standardization of JavaScript (e.g., ECMAScript as the language base).
- HTML5: structure and meaning of web content (e.g., `<article>`, `<section>`, `<header>`, `<footer>`, `<nav>`).
- CSS3: visual presentation of the document (e.g., colors, fonts, boxes, layout).

HTML structures, CSS presents, and JavaScript adds behavior.

## HTML, XHTML, and HTML5: core differences
- HTML: markup language used to structure web pages with predefined tags interpreted by the browser.
- XHTML: HTML with XML syntax rules. It is stricter, requiring proper closing tags and formal structure.
- HTML5: modern living version of HTML providing semantic tags, multimedia support, and improved mobile compatibility.
- CSS3: style language separating visual appearance from HTML structure.

## Minimal structure of an HTML5 document

```html
<!DOCTYPE html>
<html lang= "en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Mi first planetary exploration </title>
</head>
<body>
    <h1>Mi first space exploration</h1>
    <p>Hello martian, it is a true pleasure meeting you, I don´t undestand a single thing that you´re saying.</p>
    <a href= "https://www.nasa.gov/marshall/marshall-space-flight-center-history/"> Marshall </a>
</body>
</html>
```