# Entity-Relation

## Contents

- Logic models for DDBB design
- Entity-relation diagram
- E/R model notation
- Methdology to do an E/R model
- Exercises and practicals

## Logic models for DDBB design

The logic model can be :

- Hierarchical
- Network
- Object-oriented
- Relational

The last one, being the most commonly knows and used nowadays, in 2026.

## Entity-relation diagram

It revolves around the goal of representing and defining all data being introduced, stored, transformed and produced inside an information system.

The Entity-relation diagram brings a solution without it being dependant on any specific DBMS.

As we can deducat from it´s name, this diagram is made up of entities and relations between the later mentioned objects and the relation between them.

**Entities** are represeented by rectangles (it can be a physical or abstract thing/object)

Inside the rectangle, there has to be a singular noun.

Each element of an entity is an ocurrence, which has attributes, and each occurence has to be unique.

Depending on whether that certain identity needs another identity to exist, it is either a strong or weak identity.

**Relationships** are represented by rhombus

Inside a rhombus, it goes a verb.

Depending on the amount of entities involved in a relation, we can differentiate them by degrees.

We have:

- Binary relationships
- Ternary relationships
- N-ary relationships
- Reflexive/recursive relationships

**Atributes** are represented by a line and a circle and the right end of the line

We can also talk about cardinality or entity-cardinality.

**Entity cardinality** represents the minimum and maximum amount of ocurrences that within an identity can relate to another specific ocurrence of another identity.

This cardinality has to be read towards the opposite direction of the entity that ewe are evaluating.

**Cardinality** differs from entity cardinality, because it is put in the relation symbol (the rhombus), and there, we put the maximum cardinality of each identity that the relation consists of.

Cardinality can be:

- 1-1
- 1-n
- n-n

<img width="1024" height="572" alt="entity and relationship cardinality representation" src="https://github.com/user-attachments/assets/3f64bc63-1a14-4a7f-b9d6-fb16ee5b7e5d" />

## Types of attributes  
Attributes describe properties of entities.  
Attributes can also belong directly to a relationship when they describe a property of the association itself (e.g., loan date or grade).  

Types of attributes:  
- Simple (atomic): indivisible attributes (e.g., DNI)  
- Compounded: composed of several sub-attributes with their own meaning (e.g., birthdate split into day, month, year; or address split into street, city, postal code)  
- Single-valued: takes a single value for each entity occurrence  
- Multi-valued: can take more than one value for each entity occurrence (e.g., multiple phone numbers, multiple nationalities)  
- Mandatory: must have a value  
- Optional: not mandatory to have a value, can be null  
- Derived: calculated from other existing information or attributes (e.g., age calculated from birthdate)  

## Identifiers or keys  
In every entity, there is at least one attribute or set of attributes whose values uniquely identify each occurrence.  
- Candidate keys: all possible attributes or combinations of attributes that can uniquely identify an occurrence  
- Primary key: the candidate key chosen to serve as the primary unique identifier based on performance and suitability  
- Composite primary key: created when a single attribute is not enough to uniquely identify occurrences, requiring multiple attributes combined (e.g., bank account composed of bank code, branch code, control digit, and account code)  

## E/R model notation  
- Entities: represented by rectangles  
- Weak entities: represented by double rectangles  
- Relationships: represented by rhombuses  
- Main identifier attributes: represented by underlined or filled circles  
- Alternative identifier attributes: represented by distinct circles  
- Optional attributes: represented by dashed circles  
- Compounded attributes: represented by branching circles  
- Multi-valued attributes: represented by double circles

<img width="1024" height="565" alt="image" src="https://github.com/user-attachments/assets/4bed7043-ad10-42e8-b77b-8d651b7a7d26" />

**Case study**

<img width="1024" height="576" alt="image" src="https://github.com/user-attachments/assets/d170658a-efb0-42c6-99e3-eecf15bc9e97" />

<img width="909" height="511" alt="image" src="https://github.com/user-attachments/assets/00a3fdb5-0bee-43a0-9df0-441b384e2c38" />

## Methodology to create an E/R model

Creating an Entity-Relationship model follows a systematic approach based on requirement specifications:

1. **Identify Entities:** Analyze the requirements for nouns representing main objects. Characteristics and properties should not become entities.
2. **Identify Attributes:** Search for nouns describing properties, qualities, or identifiers belonging to entities or relationships.
3. **Identify Keys:** Select candidate keys from attributes and choose a Primary Key (simple or composite) that uniquely identifies each occurrence.
4. **Identify Relationships:** Locate verbs connecting entities, assign meaningful names (in lower case or verb form), and attach any relationship-specific attributes.
5. **Determine Cardinalities & Modalities:** Analyze minimum and maximum occurrences (0, 1, or N) connecting entities across each relationship.

**Case Studies**

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/286b4c15-9056-4e48-bc63-d93bda841096" />

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/3c7f33aa-5003-4507-b9c2-785830a409ef" />

<img width="1024" height="576" alt="image" src="https://github.com/user-attachments/assets/05af287a-9554-430f-9e39-1629d514ea31" />

<img width="1030" height="575" alt="image" src="https://github.com/user-attachments/assets/70b1dac0-1aa4-4c02-83c0-6827d096f011" />

## Extended Entity-Relationship Model (E/R Extended)

The extended E/R model adds advanced abstractions to model complex domain rules:

### Weak Entity Dependencies
- **Existence Dependency:** The weak entity instances are deleted if the related strong entity instance is deleted.
- **Identification Dependency:** The weak entity requires the primary key of the strong entity combined with its own partial key to form a unique identifier.

<img width="1024" height="882" alt="image" src="https://github.com/user-attachments/assets/b4b561b4-1262-4d39-a1ac-3a64f52b27f2" />

### Hierarchies (ISA / Specialization)
Relates a supertype entity with multiple subtype entities that share common attributes while adding specific ones.

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/d57698b3-dec8-4440-ab87-5e4638a99c6b" />

#### Completeness Constraints
- **Total:** Every supertype instance must belong to at least one subtype.
- **Partial:** Supertype instances do not need to belong to any subtype.

 <img width="1024" height="207" alt="image" src="https://github.com/user-attachments/assets/b05fff70-d06c-4018-a4ec-0c9b3fbb9fe2" />

#### Disjointness Constraints
- **Exclusive:** An instance can belong to at most one subtype.
- **Overlapping (Solapada):** An instance can belong to multiple subtypes simultaneously.

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/f494c96e-50e8-4068-b09d-923ef538492a" />

**Case Study**

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/39bd5e92-c0b8-4182-920c-789b5c368905" />

<img width="1142" height="634" alt="image" src="https://github.com/user-attachments/assets/f30c6c65-0c16-4fd5-acfb-24067f2b4299" />
 
| Hierarchy Type | Rule | Example |
|---|---|---|
| Total + Exclusive | Must belong to exactly one subtype | A Vehicle must be either a Car or a Truck. |
| Partial + Exclusive | Belongs to at most one subtype | A Staff member can be a Teacher or a Janitor, or neither. |
| Total + Overlapping | Must belong to one or more subtypes | A Staff member must hold at least one role (Teacher, Janitor, Technical), or multiple. |
| Partial + Overlapping | Can belong to zero, one, or multiple subtypes | A Staff member can hold any combination of roles or none. |

## The "Why" behind Extended E/R

The Extended E/R model expands the original model to address more complex real-world needs[cite: 1]. It embeds strict business rules directly into the diagram, solving issues such as dependencies, hierarchies, completeness constraints, and aggregation[cite: 1].

### 1. Detailed Weak Entity Dependencies

A weak entity is one that **cannot exist on its own**; its existence is obligatorily tied to a strong entity[cite: 1]. 

| Dependency Type | The "guts" of the concept | Visual Example |
| :--- | :--- | :--- |
| **Existence** | The weak record is automatically deleted if we delete the strong one it depends on[cite: 1]. | **Employee** (Strong) $\rightarrow$ **Family Member** (Weak). If the employee leaves the company, their family members' data disappears from the system[cite: 1]. |
| **Identification** | The weak record does not have enough information to uniquely identify itself[cite: 1]. It needs the primary identifier of the strong entity to be unique[cite: 1]. | **Book** (Strong, ID: ISBN) $\rightarrow$ **Copy** (Weak, ID: Copy_number). Copy "3" means nothing if we do not append the ISBN of the book it belongs to[cite: 1]. |

### 2. Relationship Exclusivity

This is different from hierarchies between entities. Here we are talking about **actions (rhombuses) that are mutually exclusive**[cite: 1].

- **The rule:** The existence of one relationship completely prevents the existence of another[cite: 1].
- **The example:** In an educational center, a `PROFESSOR` can teach (`IMPARTS` a `SUBJECT`) or do research (`CONDUCTS` a `RESEARCH`), but cannot do both at the same time[cite: 1]. This is graphically represented with an arc crossing both relationship lines.

### 3. Deep Dive: ISA Relationships (Hierarchies)

To visually understand hierarchies (ISA relationships), let's take the example of a center's `STAFF`, which is divided into subtypes: `PROFESSORS`, `JANITORS`, and `TECHNICIANS`[cite: 1].

| Configuration | Explanation for beginners |
| :--- | :--- |
| **Overlapping and Total** | **Total:** All staff must be classified in at least one of the three roles[cite: 1]. **Overlapping:** A person can hold multiple roles at the same time (e.g., being a Professor and a Technician simultaneously)[cite: 1]. |
| **Exclusive and Total** | **Total:** Everyone must have a role[cite: 1]. **Exclusive:** You can only choose **one**. If you are a Janitor, it is impossible for you to be a Professor[cite: 1]. |
| **Overlapping and Partial** | **Partial:** You can be general "Staff" without having any of those three specific roles assigned yet[cite: 1]. **Overlapping:** If you do have a role, you can hold several at once[cite: 1]. |
| **Exclusive and Partial** | **Partial:** You might not have a specific role yet[cite: 1]. **Exclusive:** The moment you are assigned one, it can only be that specific one and no other[cite: 1]. |

---

**More case studies**

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/9ac9d7e4-9edd-41aa-9187-8ea108492db4" />

<img width="1143" height="642" alt="image" src="https://github.com/user-attachments/assets/58b33330-8647-443f-9940-732a9b3fb46b" />
