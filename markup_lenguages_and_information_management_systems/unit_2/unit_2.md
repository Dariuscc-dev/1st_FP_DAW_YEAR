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

## HTML Tags

### Text and Basic Structure
- **Headings (`<h1>` to `<h6>`):** Define heading hierarchy. `<h1>` is the most important (recommended once per page for SEO), and `<h6>` is the lowest level.
- **Paragraph (`<p>`):** Groups blocks of text.
- **Formatting and Emphasis:**
  - `<strong>`: Bold text with semantic importance.
  - `<em>`: Italic text with semantic emphasis.
  - `<span>`: Generic inline container without semantic meaning, used for applying CSS styles.
  - `<div>`: Generic block-level container.
  - `<br>`: Line break.
  - `<hr>`: Horizontal rule for thematic breaks.

### Links (`<a>`)
Allow navigation between pages or resources.
- **`href` attribute:** Specifies the destination URL (absolute or relative).
- **`target="_blank"` attribute:** Opens the link in a new tab.
- **`rel="noopener noreferrer"` attribute:** Security best practice when using `target="_blank"`.

### Images (`<img>`)
Self-closing tag (does not require a closing tag).
- **`src` attribute:** Path to the image file.
- **`alt` attribute:** Mandatory alternative text for accessibility and SEO if the image fails to load.
- **`width` and `height` attributes:** Dimensions in pixels or percentage.

### Lists
- **Unordered Lists (`<ul>`):** Bulleted list without specific order. Each item uses `<li>`.
- **Ordered Lists (`<ol>`):** Sequentially numbered list. Each item uses `<li>`.
- **Definition Lists (`<dl>`):**
  - `<dt>`: Term to be defined.
  - `<dd>`: Description or definition of the term.

### Tables
Structures used to display data in a matrix format.
- `<table>`: Main container for the table.
- `<thead>`, `<tbody>`, `<tfoot>`: Semantically group header, body, and footer rows.
- `<tr>`: Table row.
- `<th>`: Header cell (bold and centered by default).
- `<td>`: Standard data cell.
- **Key Cell Attributes:**
  - `colspan="n"`: Spans `n` columns horizontally.
  - `rowspan="n"`: Spans `n` rows vertically.

### HTML5 Semantic Tags
Provide clear meaning about page structure to search engines and screen readers:
- `<header>`: Header for the page or section.
- `<nav>`: Block containing major navigation links.
- `<main>`: Main, unique content of the document.
- `<article>`: Self-contained, independent content (blog post, news article).
- `<section>`: Thematic grouping of content within the document.
- `<aside>`: Secondary or related content (sidebars).
- `<footer>`: Footer (copyright, legal notices, contact info).

### Multimedia
- **Video (`<video>`):**
  - Attributes: `controls` (displays playback buttons), `autoplay`, `loop`, `muted`, `poster` (preview image).
  - Child tag: `<source src="..." type="video/mp4">`.
- **Audio (`<audio>`):**
  - Similar to video with `controls`, `autoplay`, `loop`, and `<source>` child tags.

---

## Forms
Used to collect user input and submit it to a server.

### Root Element and Key Attributes

```html
<form action="/process-data" method="POST">
</form>
```

- **`action`:** URL where form data is sent.
- **`method`:** HTTP method for submission:
  - **GET:** Appends data to the URL (visible, insecure, limited length).
  - **POST:** Sends data in the request body (hidden, more secure, allows file uploads).

### Controls and Input Types (`<input>`)
- `type="text"`: Simple text input.
- `type="password"`: Masked text for passwords.
- `type="email"`: Automatically validates email format.
- `type="number"`: Numeric input with optional `min` and `max` limits.
- `type="checkbox"`: Multiple-choice selection.
- `type="radio"`: Single-choice selection (items in the same group must share the same `name` attribute).
- `type="submit"`: Button to submit the form.
- `type="reset"`: Resets all fields to their default values.

### Other Controls
- `<textarea>`: Multi-line text field (comments, descriptions).
- `<select>` and `<option>`: Dropdown select list.
- `<label>`: Label associated with an input via `for="input_id"` to enhance accessibility.

### HTML5 Validation Attributes
- `required`: Mandates filling out the field before submission.
- `placeholder`: Temporary hint text inside the field.
- `pattern`: Regular expression (Regex) to validate input format.
- `minlength` and `maxlength`: Minimum and maximum character length.
- `readonly`: Field cannot be edited, but its value is submitted.
- `disabled`: Disables the field; its value is not submitted.

### Measurement Elements: `progress` and `meter`
- `<progress>`: Represents task completion progress.
  ```html
  <progress value="70" max="100"></progress>
  ```
- `<meter>`: Represents a scalar measurement within a known range or fractional value (e.g., disk usage, temperature).
  ```html
  <meter value="0.6" min="0" max="1" low="0.3" high="0.8" optimum="0.5"></meter>
  ```

---

## CSS (Cascading Style Sheets)

### Basic Syntax

```css
selector {
    property: value;
}
```

### Types of Selectors
- **Basic:**
  - **Universal (`*`):** Applies to all elements.
  - **Tag (`p`, `<h1>`, `<div>`):** Applies to all elements of the specified type.
  - **Class (`.my-class`):** Selects elements with `class="my-class"`. Reusable.
  - **ID (`#my-id`):** Selects the element with `id="my-id"`. Must be unique.
- **Combinators:**
  - **Descendant (`div p`):** Selects any `<p>` inside a `<div>`.
  - **Child (`div > p`):** Selects only direct `<p>` children of a `<div>`.
- **Attribute:** `input[type="text"]` selects text inputs.
- **Pseudo-classes and Pseudo-elements:**
  - `:hover`: Style when mouse hovers over element.
  - `:focus`: Style when element receives keyboard/screen focus.
  - `::before` / `::after`: Inserts content before/after element content.

### Cascade, Specificity, and Inheritance
- **Cascade:** The order CSS rules apply based on origin, specificity, and declaration order (later rules overwrite earlier ones if specificity is equal).
- **Inheritance:** Some properties (like `color` or `font-family`) are automatically inherited by child elements; others (like `margin` or `border`) are not.
- **Specificity Calculation (Weight):**
  1. Inline styles (`style="..."`): **1000**
  2. IDs (`#id`): **100**
  3. Classes, pseudo-classes, attributes (`.class`, `:hover`): **10**
  4. Elements and pseudo-elements (`p`, `::before`): **1**

*(Note: `!important` overrides standard specificity and should be used sparingly).*

### Core Properties
- **Text & Typography:** `color`, `font-family`, `font-size`, `font-weight`, `text-align`, `line-height`.
- **Box Model:**
  - `width` / `height`: Dimensions of the content area.
  - `padding`: Internal space between content and border.
  - `border`: Border around the element (`border: 1px solid black;`).
  - `margin`: External space outside the border.
  - `box-sizing: border-box;`: Includes padding and border within the total element width and height.
- **Layout & Positioning:**
  - `display`: `block`, `inline`, `inline-block`, `none`, `flex`, `grid`.
  - `position`: `static` (default), `relative`, `absolute`, `fixed`, `sticky`.

---

## Practical Code Examples

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 15px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <header>
        <h1>User Registration</h1>
    </header>
    
    <main>
        <form action="/submit" method="POST">
            <div class="form-group">
                <label for="fullname">Full Name:</label>
                <input type="text" id="fullname" name="fullname" required placeholder="e.g. John Doe">
            </div>

            <div class="form-group">
                <label for="email">Email Address:</label>
                <input type="email" id="email" name="email" required placeholder="user@example.com">
            </div>

            <div class="form-group">
                <label for="preparation">Preparation Level:</label>
                <meter id="preparation" min="0" max="100" value="75" low="30" high="80" optimum="90">75%</meter>
            </div>

            <button type="submit">Submit Data</button>
        </form>
    </main>
</body>
</html>
```

---

## Typical Exam Errors

1. **Confusing `<meter>` with `<progress>`:**
   - `<progress>` is used for dynamic ongoing tasks (e.g., file download percentage).
   - `<meter>` is used for static measurements within a known range (e.g., current temperature, battery level).
2. **Forgetting the `name` attribute in form inputs:** Without a `name` attribute, the input's value will not be sent to the server on submission.
3. **Same `name` vs different `name` on radio/checkbox inputs:**
   - Radio buttons (`type="radio"`) must share the exact same `name` attribute so that only one option in the group can be selected.
4. **Strict XHTML vs HTML5 syntax:** Forgetting to self-close empty tags in XHTML (e.g., `<br/>` vs `<br>`) or omitting attribute quotes causes strict XHTML validation failures.
5. **Miscalculating CSS Specificity:** Assuming a long chain of classes or tags has higher weight than a simple `#ID` selector.
6. **Failing to link `<label>` and `<input>`:** Omitting the `for` attribute matching the input's `id` negatively impacts web accessibility scores.