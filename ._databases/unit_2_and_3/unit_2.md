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


## Methodology to create an E/R model

Creating an Entity-Relationship model follows a systematic approach based on requirement specifications:

1. **Identify Entities:** Analyze the requirements for nouns representing main objects. Characteristics and properties should not become entities.
2. **Identify Attributes:** Search for nouns describing properties, qualities, or identifiers belonging to entities or relationships.
3. **Identify Keys:** Select candidate keys from attributes and choose a Primary Key (simple or composite) that uniquely identifies each occurrence.
4. **Identify Relationships:** Locate verbs connecting entities, assign meaningful names (in lower case or verb form), and attach any relationship-specific attributes.
5. **Determine Cardinalities & Modalities:** Analyze minimum and maximum occurrences (0, 1, or N) connecting entities across each relationship.

## Extended Entity-Relationship Model (E/R Extended)

The extended E/R model adds advanced abstractions to model complex domain rules:

### Weak Entity Dependencies
- **Existence Dependency:** The weak entity instances are deleted if the related strong entity instance is deleted.
- **Identification Dependency:** The weak entity requires the primary key of the strong entity combined with its own partial key to form a unique identifier.

### Hierarchies (ISA / Specialization)
Relates a supertype entity with multiple subtype entities that share common attributes while adding specific ones.

#### Completeness Constraints
- **Total:** Every supertype instance must belong to at least one subtype.
- **Partial:** Supertype instances do not need to belong to any subtype.

#### Disjointness Constraints
- **Exclusive:** An instance can belong to at most one subtype.
- **Overlapping (Solapada):** An instance can belong to multiple subtypes simultaneously.

| Hierarchy Type | Rule | Example |
|---|---|---|
| Total + Exclusive | Must belong to exactly one subtype | A Vehicle must be either a Car or a Truck. |
| Partial + Exclusive | Belongs to at most one subtype | A Staff member can be a Teacher or a Janitor, or neither. |
| Total + Overlapping | Must belong to one or more subtypes | A Staff member must hold at least one role (Teacher, Janitor, Technical), or multiple. |
| Partial + Overlapping | Can belong to zero, one, or multiple subtypes | A Staff member can hold any combination of roles or none. |

---

## Exercises and Practicals

### Case 1: Fishermen & Catch
- **Entities:** `PESCADOR` (ID_Pescador, Nombre, Num_Licencia), `PEZ` (ID_Pez, Especie, Peso_kg).
- **Relationship:** `PESCA` (Fecha, Hora).
- **Cardinality:** 1:N (A fisherman catches 0..N fish; each fish is caught by exactly 1..1 fisherman).

### Case 2: Tourist & Hotel
- **Entities:** `TURISTA` (Pasaporte, Nombre, Nacionalidad), `HOTEL` (ID_Hotel, Nombre, Categoria).
- **Relationship:** `VIAJA` (Fecha_Entrada).
- **Cardinality:** N:M (0..N tourists stay at 0..N hotels).

### Case 3: Vehicle Hierarchy
- **Supertype:** `VEHÍCULO` (Num_bastidor, Fecha_fab, Precio).
- **Subtypes:** 
  - `TURISMO` (Num_puertas)
  - `CAMIÓN` (Num_ejes, Tonelaje)
- **Hierarchy Type:** Total and Exclusive (Every vehicle must be either a Car or a Truck).