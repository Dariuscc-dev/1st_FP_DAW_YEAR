# Normalization

## Contents

- What normalization is and why we need it
- Redundant data and inconsistent dependencies
- Anomalies: insertion, deletion and update
- First normal form (1NF)
- Functional dependencies
- Second normal form (2NF)
- Third normal form (3NF)
- Boyce-Codd normal form (BCNF)
- Fourth normal form (4NF), 5NF and 6NF
- Cheat sheet
- Practice exercises (solved)

## What normalization is

**Normalization** is the process of organizing the data in a database: creating tables and setting the relationships between them following rules that protect the data and make the database more flexible, by removing **redundancy** and **inconsistent dependencies**.

| Problem | Meaning | Example |
|---|---|---|
| **Redundant data** | The same data is repeated in several rows or tables. It wastes space and makes maintenance harder, because a change must be made everywhere | A student's address stored in several tables instead of only in STUDENTS |
| **Inconsistent dependency** | An attribute in a table that does not depend on that table's primary key | The number of hours of a module stored in STUDENTS. Hours depend on the module, so they belong in MODULES |

The formal rules are the **normal forms**. There are six, plus Boyce-Codd. When a database passes the rules of the first, it is in 1NF; when it passes the second, it is in 2NF, and so on.

| Normal form | Notation |
|---|---|
| First normal form | 1NF |
| Second normal form | 2NF |
| Third normal form | 3NF |
| Boyce-Codd normal form | BCNF |

In practice only the first three are usually applied: a database in **3NF** is considered correctly designed. Real-world cases don't always allow a perfect design, and normalizing adds tables. If the first three rules aren't met, the application using the database has to deal with redundant data and inconsistent dependencies itself.

## Anomalies

Anomalies are database states that are not valid in the real world. Example: each teacher has a department and the groups they teach.

| Anomaly | What happens | Example |
|---|---|---|
| **Insertion** | You can't add data because other data is missing | `Group` doesn't allow nulls, so a new teacher without a group can't be inserted |
| **Deletion** | Deleting some data unintentionally deletes other data | Group 1C is removed, and teacher José and the IT department disappear with it |
| **Update** | Redundancy plus a partial update leaves inconsistent data | Alejandro's department is stored twice; if only one row is updated, the data is wrong |

Normalization is what prevents these anomalies.

## First normal form (1NF)

Design rules for 1NF:

| Rule | Meaning |
|---|---|
| Single-valued attributes | Each column holds one value. No multivalued fields |
| The attribute domain doesn't change | All values in a column are of the same type (no names inside a `birthDate` column) |
| Unique column names | Duplicate names confuse the DBMS |
| Order doesn't matter | The order in which rows are stored is irrelevant |

A database is in **1NF** if:

- Every attribute of every table holds a single **atomic** value (no multivalued attributes).
- Every row is unique.

### Example: school enrolments

Initial design of MODULES (primary key: module code). Looking at it, `NIA`, `Name`, `Surname`, `Grade`, `Sitting` and `Hours` hold several values per module, so it is **not** in 1NF.

Fix: move the repeating data (the students) to a new table, ENROLMENTS.

```text
MODULES (module_code, module_name, ...)
ENROLMENTS (module_code, NIA, name, surname, grade, sitting, hours)
            PK = (module_code, NIA)
```

When moving to 1NF, the new tables usually get a **composite primary key** made of two attributes: the key of the original table plus the key of the moved data. There is still a lot of repeated information.

## Functional dependencies

Introduced by **E. F. Codd**. A **functional dependency** is the relationship between attributes of the same table: an attribute depends functionally on another if it needs that other attribute's value to have a specific value.

```text
NIA → name, surname       (knowing the NIA tells you the name and surname)
module_code → hours       (knowing the module tells you its hours)
```

- **2NF** checks dependencies between parts of the primary key and the non-key attributes. Only tables with a **composite** key need checking.
- **3NF** checks dependencies between **non-key** attributes. If there are any, the table mixes several entities and must be split.

## Second normal form (2NF)

A table is in **2NF** if:

- It is in 1NF.
- Every non-key attribute depends on the **whole** primary key, not just part of it.

A table in 1NF with a **simple** key is automatically in 2NF.

In the example, MODULES is already in 2NF (simple key). ENROLMENTS has a composite key, so we check it:

- `name` and `surname` depend only on `NIA`, not on the full key → move them to a new table STUDENTS with `NIA` as key.
- `hours` depends only on `module_code` → move it back to MODULES.

```text
MODULES (module_code, module_name, hours, cycle_code, cycle_name, cycle_hours, cycle_family)
STUDENTS (NIA, name, surname)
ENROLMENTS (module_code, NIA, grade, sitting)
```

## Third normal form (3NF)

If a non-key attribute depends on another non-key attribute, the table probably holds data about more than one entity.

A table is in **3NF** if:

- It is in 2NF.
- Non-key attributes are independent of each other (no attribute depends on another non-key attribute).

In the example, ENROLMENTS and STUDENTS are in 3NF, but MODULES is not: `cycle_name`, `cycle_hours` and `cycle_family` depend on `cycle_code`, which is not the key. Move them to a new table CYCLES.

```text
CYCLES (cycle_code, cycle_name, cycle_hours, cycle_family)
MODULES (module_code, module_name, hours, cycle_code → CYCLES)
STUDENTS (NIA, name, surname)
ENROLMENTS (module_code → MODULES, NIA → STUDENTS, grade, sitting)
```

A database is in a normal form when **all** its tables are.

## Boyce-Codd normal form (BCNF)

An extension of 3NF, also called "3.5 normal form".

A table is in **BCNF** if:

- It is in 3NF.
- For every dependency **A → B**, A is a **superkey**.

In plain words: in a dependency A → B, A can't be a non-prime attribute if B is a prime attribute (part of the key).

### Example

| NIA | module | teacher |
|---|---|---|
| 0011 | PRG | Teacher 1 |
| 0011 | BDD | Teacher 2 |
| 0012 | PRG | Teacher 3 |

- A student can take several modules, and each module is assigned a teacher.
- A module can have several teachers (PRG has two), but a teacher teaches only one module.
- Primary key: `(NIA, module)`.
- There is also the dependency **teacher → module**.

The table is in 1NF, 2NF and 3NF, but **not in BCNF**: `module` is part of the key and it depends on `teacher`, which is not a superkey.

Fix: split it into two tables.

```text
STUDENT_TEACHER (NIA, teacher)
TEACHER (teacher, module)
```

## Fourth normal form (4NF)

4NF deals with **multivalued dependencies**, which need at least three columns.

Example: students enrol in modules and also say which programming languages they'd like to learn. Student 0011 takes PRG and BDD and wants Java and C#. Since module and language are independent, every module gets combined with every language:

| NIA | module | language |
|---|---|---|
| 0011 | PRG | Java |
| 0011 | PRG | C# |
| 0011 | BDD | Java |
| 0011 | BDD | C# |

That's unnecessary repetition and a source of anomalies.

A table is in **4NF** if:

- It is in BCNF.
- It has no multivalued dependency.

Fix: split into two tables.

```text
STUDENT_MODULE (NIA, module)
STUDENT_LANGUAGE (NIA, language)
```

If a table has both a functional and a multivalued dependency, the functionally dependent columns go to one table and each multivalued group to its own table.

## 5NF and 6NF

- **5NF:** the table is in 4NF and can't be split into smaller tables without losing data.
- **6NF:** not standardized yet.
- In real projects, 5NF and 6NF are rarely applied.

## Cheat sheet

| Form | Requirement | Typical fix |
|---|---|---|
| **1NF** | Atomic values, unique rows | Move repeating groups to a new table (composite key) |
| **2NF** | 1NF + no partial dependency on a composite key | Move attributes that depend on part of the key |
| **3NF** | 2NF + no dependency between non-key attributes | Move transitive attributes to a new table |
| **BCNF** | 3NF + every determinant is a superkey | Split the table around the extra dependency |
| **4NF** | BCNF + no multivalued dependency | One table per independent multivalued fact |

Quick tests:

- Is there a cell with several values? → not 1NF.
- Composite key and an attribute that depends on only one part of it? → not 2NF.
- A non-key attribute that depends on another non-key attribute? → not 3NF.
- Simple key in 1NF? → already 2NF.

## Practice exercises (solved)

**1. What normal form is this table in?**

```text
ORDERS (order_id, customer_id, customer_name, date)
```

Simple key, atomic values → 1NF and 2NF. But `customer_name` depends on `customer_id` (non-key) → **not 3NF**.

Fix:

```text
CUSTOMERS (customer_id, customer_name)
ORDERS (order_id, customer_id → CUSTOMERS, date)
```

**2. Partial dependency.**

```text
ORDER_LINES (order_id, product_id, quantity, product_price)
PK = (order_id, product_id)
```

`product_price` depends only on `product_id` → **not 2NF**.

Fix:

```text
PRODUCTS (product_id, product_price)
ORDER_LINES (order_id, product_id → PRODUCTS, quantity)
```

**3. Which anomaly is it?** A new course can't be stored until a student enrols in it → **insertion anomaly**.
