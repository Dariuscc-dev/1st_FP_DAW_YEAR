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

