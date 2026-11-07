# Entity-Relationship Model

## Contents

- Logical models for database design
- Entity-relationship diagram
- E/R model notation
- Methodology to create an E/R model
- Exercises and case studies

## Logical models for database design

The logical model can be:

- Hierarchical
- Network
- Object-oriented
- Relational

The relational model is the most widely known and used today.

## Entity-relationship diagram

Its goal is to represent and define all the data that is entered, stored, transformed and produced inside an information system.

The entity-relationship diagram offers a solution that does not depend on any specific DBMS.

As the name suggests, the diagram is made up of entities and the relationships between them.

**Entities** are represented by rectangles (an entity can be a physical or an abstract object).

The name inside the rectangle must be a singular noun.

Each element of an entity is an occurrence. Occurrences have attributes, and each occurrence must be unique.

If an entity needs another entity in order to exist, it is a weak entity. Otherwise, it is a strong entity.

**Relationships** are represented by rhombuses (diamonds).

The name inside the rhombus is a verb.

Relationships are classified by degree, depending on how many entities take part in them:

- Binary relationships
- Ternary relationships
- N-ary relationships
- Reflexive/recursive relationships

**Attributes** are represented by a line with a circle at its end.

We also need to talk about cardinality.

**Entity cardinality** represents the minimum and maximum number of occurrences of one entity that can be related to a single occurrence of another entity.

It is read in the opposite direction of the entity being evaluated.

**Relationship cardinality** is different: it is written on the relationship symbol (the rhombus) and shows the maximum cardinality of each entity that takes part in the relationship.

Relationship cardinality can be:

- 1:1
- 1:N
- N:M

<img width="1024" height="572" alt="entity and relationship cardinality representation" src="https://github.com/user-attachments/assets/3f64bc63-1a14-4a7f-b9d6-fb16ee5b7e5d" />

## Types of attributes
Attributes describe properties of entities.
Attributes can also belong directly to a relationship when they describe a property of the association itself (e.g., loan date or grade).

Types of attributes:
- Simple (atomic): indivisible attributes (e.g., national ID number)
- Composite: made up of several sub-attributes with their own meaning (e.g., birthdate split into day, month and year; or address split into street, city and postal code)
- Single-valued: takes a single value for each entity occurrence
- Multi-valued: can take more than one value for each entity occurrence (e.g., multiple phone numbers, multiple nationalities)
- Mandatory: must have a value
- Optional: does not need a value, can be null
- Derived: calculated from other existing attributes (e.g., age calculated from birthdate)

## Identifiers or keys
Every entity has at least one attribute, or set of attributes, whose values uniquely identify each occurrence.
- Candidate keys: all attributes or combinations of attributes that can uniquely identify an occurrence
- Primary key: the candidate key chosen as the main unique identifier, based on performance and suitability
- Composite primary key: used when a single attribute is not enough to uniquely identify occurrences, so several attributes are combined (e.g., a bank account made up of bank code, branch code, check digit and account number)

## E/R model notation
- Entities: rectangles
- Weak entities: double rectangles
- Relationships: rhombuses
- Main identifier attributes: underlined or filled circles
- Alternative identifier attributes: distinct circles
- Optional attributes: dashed circles
- Composite attributes: branching circles
- Multi-valued attributes: double circles

<img width="1024" height="565" alt="image" src="https://github.com/user-attachments/assets/4bed7043-ad10-42e8-b77b-8d651b7a7d26" />

**Case study**

<img width="1024" height="576" alt="image" src="https://github.com/user-attachments/assets/d170658a-efb0-42c6-99e3-eecf15bc9e97" />

<img width="909" height="511" alt="image" src="https://github.com/user-attachments/assets/00a3fdb5-0bee-43a0-9df0-441b384e2c38" />

## Methodology to create an E/R model

Creating an entity-relationship model follows a systematic approach based on the requirements:

1. **Identify entities:** Look for nouns in the requirements that represent the main objects. Characteristics and properties should not become entities.
2. **Identify attributes:** Look for nouns that describe properties, qualities or identifiers of entities or relationships.
3. **Identify keys:** Pick the candidate keys and choose a primary key (simple or composite) that uniquely identifies each occurrence.
4. **Identify relationships:** Find the verbs that connect entities, give them meaningful names (lowercase or verb form), and add any relationship-specific attributes.
5. **Determine cardinalities and participation:** Work out the minimum and maximum occurrences (0, 1 or N) on each side of every relationship.

**Case studies**

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/286b4c15-9056-4e48-bc63-d93bda841096" />

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/3c7f33aa-5003-4507-b9c2-785830a409ef" />

<img width="1024" height="576" alt="image" src="https://github.com/user-attachments/assets/05af287a-9554-430f-9e39-1629d514ea31" />

<img width="1030" height="575" alt="image" src="https://github.com/user-attachments/assets/70b1dac0-1aa4-4c02-83c0-6827d096f011" />

## Extended Entity-Relationship Model (Extended E/R)

The extended E/R model adds more abstractions to model complex domain rules.

### Weak entity dependencies
- **Existence dependency:** The weak entity occurrences are deleted when the related strong entity occurrence is deleted.
- **Identification dependency:** The weak entity needs the primary key of the strong entity, combined with its own partial key, to form a unique identifier.

<img width="1024" height="882" alt="image" src="https://github.com/user-attachments/assets/b4b561b4-1262-4d39-a1ac-3a64f52b27f2" />

### Hierarchies (ISA / specialization)
Relates a supertype entity with several subtype entities. The subtypes share the common attributes and add their own specific ones.

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/d57698b3-dec8-4440-ab87-5e4638a99c6b" />

#### Completeness constraints
- **Total:** Every supertype occurrence must belong to at least one subtype.
- **Partial:** Supertype occurrences do not need to belong to any subtype.

<img width="1024" height="207" alt="image" src="https://github.com/user-attachments/assets/b05fff70-d06c-4018-a4ec-0c9b3fbb9fe2" />

#### Disjointness constraints
- **Exclusive (disjoint):** An occurrence can belong to at most one subtype.
- **Overlapping:** An occurrence can belong to several subtypes at the same time.

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/f494c96e-50e8-4068-b09d-923ef538492a" />

**Case study**

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/39bd5e92-c0b8-4182-920c-789b5c368905" />

<img width="1142" height="634" alt="image" src="https://github.com/user-attachments/assets/f30c6c65-0c16-4fd5-acfb-24067f2b4299" />

| Hierarchy type | Rule | Example |
|---|---|---|
| Total + Exclusive | Must belong to exactly one subtype | A Vehicle must be either a Car or a Truck. |
| Partial + Exclusive | Belongs to at most one subtype | A Staff member can be a Teacher or a Janitor, or neither. |
| Total + Overlapping | Must belong to one or more subtypes | A Staff member must hold at least one role (Teacher, Janitor, Technician), possibly several. |
| Partial + Overlapping | Can belong to zero, one or several subtypes | A Staff member can hold any combination of roles, or none. |

## Why the Extended E/R model exists

The extended E/R model builds on the original model to cover more complex real-world needs. It puts business rules directly into the diagram: dependencies, hierarchies, completeness constraints and aggregation.

### 1. Weak entity dependencies in detail

A weak entity **cannot exist on its own**. Its existence is tied to a strong entity.

| Dependency type | What it means | Example |
| :--- | :--- | :--- |
| **Existence** | The weak record is automatically deleted when the strong record it depends on is deleted. | **Employee** (strong) → **Family Member** (weak). If the employee leaves the company, their family members' data is removed from the system. |
| **Identification** | The weak record does not have enough information to identify itself. It needs the primary key of the strong entity to be unique. | **Book** (strong, ID: ISBN) → **Copy** (weak, ID: copy_number). Copy "3" means nothing unless we add the ISBN of the book it belongs to. |

### 2. Relationship exclusivity

This is not the same as a hierarchy between entities. Here we are talking about **relationships (rhombuses) that exclude each other**.

- **The rule:** If one relationship exists, the other one cannot.
- **Example:** In a school, a `PROFESSOR` can teach (`TEACHES` a `SUBJECT`) or do research (`CONDUCTS` a `RESEARCH_PROJECT`), but not both at the same time. In the diagram this is shown with an arc crossing both relationship lines.

### 3. ISA relationships (hierarchies) in practice

Take the `STAFF` of a school, divided into the subtypes `PROFESSOR`, `JANITOR` and `TECHNICIAN`.

| Configuration | Explanation |
| :--- | :--- |
| **Overlapping and Total** | **Total:** All staff must have at least one of the three roles. **Overlapping:** A person can hold several roles at once (e.g., Professor and Technician). |
| **Exclusive and Total** | **Total:** Everyone must have a role. **Exclusive:** Only **one** role is allowed. A Janitor cannot also be a Professor. |
| **Overlapping and Partial** | **Partial:** Someone can be general staff without any of the three roles assigned yet. **Overlapping:** If they do have roles, they can hold several. |
| **Exclusive and Partial** | **Partial:** Someone might not have a specific role yet. **Exclusive:** Once a role is assigned, it can only be that one. |

---

**More case studies**

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/9ac9d7e4-9edd-41aa-9187-8ea108492db4" />

<img width="1142" height="640" alt="image" src="https://github.com/user-attachments/assets/4e7dbfb6-842a-4468-98a1-7af076f9ec3c" />

**ER diagram notation**

From now on I use the look-across convention for (min,max) cardinalities: the cardinality is written next to the target entity. For example, "a book has one or more copies" is shown as (1,N) next to Copy, and "a copy belongs to exactly one book" as (1,1) next to Book. This is the usual convention in Chen notation, UML and crow's foot notation. Earlier diagrams in this repository may follow the opposite convention (look-here).
