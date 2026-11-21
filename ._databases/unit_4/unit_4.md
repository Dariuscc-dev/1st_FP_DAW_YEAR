# Relational Model

## Contents

- From the E/R diagram to the relational model
- Relational model fundamentals
- Keys
- Constraints
- Notation used in these notes
- Transforming entities
- Transforming relationships (by cardinality)
- Reflexive and ternary relationships
- Transforming attributes
- Weak entities
- Generalization / specialization
- Aggregations
- Cheat sheet
- Practice exercises (solved)

## From the E/R diagram to the relational model

Database design goes through three phases:

| Phase | Output | What it gives us |
|---|---|---|
| Conceptual design | E/R diagram | A model that does not depend on any specific DBMS or physical design |
| Logical design | Logical schema (relational model) | Tables, columns, primary and foreign keys |
| Physical design | Tables created in a real DBMS | SQL code (`CREATE TABLE ...`) |

Requirement before moving on: the E/R diagram must cover all the requirements of the problem we are modeling. If the E/R is wrong, the tables will be wrong too.

The transformation is done in **three steps**:

1. **Entities.** As a general rule, each entity becomes a table. Pay special attention to weak entities (dependencies) and hierarchies.
2. **Relationships.** Two options: create a new table for the relationship, or export (propagate) the primary key of one table to the other, where it becomes a foreign key.
3. **Attributes.** Entity attributes become columns of their table. Relationship attributes either go into the new table, or travel together with the propagated key.

## Relational model fundamentals

The relational model stores data in **relations**, which we represent as **tables**.

| Term | Meaning |
|---|---|
| Relation | A table, identified by its name |
| Tuple | A row (record). A group of related values |
| Attribute | A column (field). A property of an entity or relationship |
| Domain | The finite set of homogeneous values an attribute can take (integers, decimals, dates, strings...) |
| Cardinality (of a relation) | Number of tuples (rows) |
| Degree (of a relation) | Number of attributes (columns) |

Two basic rules:

- There can't be two identical rows in a table.
- The order of rows and the order of columns does not matter.

Watch out: "cardinality" here means the number of rows of a table. It is not the same as the cardinality of a relationship in the E/R diagram.

## Keys

A key is a set of attributes that uniquely identifies each row. It can be **simple** (one attribute) or **composite** (several attributes).

| Key type | Definition | Example (a student) |
|---|---|---|
| Superkey | Any set of attributes that identifies a row. Doesn't need to be minimal | NIA, NIA + Name, NIA + Name + DNI... |
| Candidate key | A minimal superkey. A table can have several | NIA or DNI |
| Primary key (PK) | The candidate key chosen by the designer. Only **one** per table | NIA |
| Alternative key | Candidate keys that were not chosen as PK | DNI |
| Foreign key (FK) | An attribute (or set) that is a candidate key in **another** table (or the same one). Used to link tables. FK and the referenced key must share the same domain | `NIA` inside `ENROLMENTS` pointing to `STUDENTS` |

## Constraints

### Inherent constraints (imposed by the model itself)

- No two identical tuples, so a primary key is mandatory. (SQL and many DBMSs let you create tables without a PK, but then the design is no longer relational.)
- No attribute that is part of the PK can be null (**entity integrity rule**).
- The order of tuples doesn't matter.
- The order of attributes doesn't matter.
- Each attribute takes **one single value** from its domain (no lists inside a cell).

### Semantic constraints (defined by the designer, based on the meaning of the data)

| Constraint | SQL | What it does |
|---|---|---|
| Primary key | `PRIMARY KEY` | Values can't repeat and can't be null |
| Uniqueness | `UNIQUE` | Values can't repeat. Used to define alternative keys |
| Mandatory / optional | `NOT NULL` / `NULL` | Whether the attribute accepts null |
| Referential integrity | `FOREIGN KEY` | The referenced value must exist in the other table |
| Domain | data type | The value must belong to the defined domain |
| Check | `CHECK` | The value must satisfy a user-defined expression |
| Assertions | `ASSERTION` | General rules that can involve attributes from one or several tables |

### Loss of semantics

When we go from E/R to relational, both entities and relationships end up as tables, so we can no longer tell which table came from what. With key propagation it's even worse: the relationship name disappears completely.

That's not a danger for data integrity as long as the constraints (especially foreign keys and their delete/update options) are defined properly.

## Notation used in these notes

Each table is written as its name followed by its attributes in brackets:

```
TABLE (attribute1, attribute2, ..., attributeN)
```

On paper (class slides):

- Primary key: **solid underline**
- Foreign key: **dashed underline**, with an arrow pointing to the table it references

Markdown can't do dashed underlines, so in these notes I use:

| Notation | Meaning |
|---|---|
| <ins>attr</ins> | Primary key (or part of it) |
| *attr* | Foreign key |
| <ins>*attr*</ins> | Part of the PK and also a FK |
| `→ TABLE` | Table the FK references |

Note: the textbook uses another notation (`#` in front of PK attributes and underline for FKs, e.g. `FOOTBALLERS (#code, name, shirt_number, team)`). Same idea, different symbols. In exams I follow the one the teacher uses in class (solid / dashed underline).

## Transforming entities

### General rule

Each entity becomes a table with the same name, and its attributes become columns.

PERSON (<ins>attribute1</ins>, attribute2, ..., attributeN)

Example from the textbook (strong entity):

FOOTBALLERS (<ins>code</ins>, name, shirt_number, team)

## Transforming relationships (by cardinality)

How a relationship is transformed depends on its **cardinality**. That's the key to this whole unit.

Reminder about reading cardinalities: I use the look-across convention, so the (min,max) written next to an entity tells how many occurrences of **that** entity are related to one occurrence of the entity on the other side.

### N:M relationships → always a new table

- The new table's PK is the **concatenation of the PKs** of the entities it relates.
- Each of those attributes is part of the PK **and** a FK pointing to its original table.
- If the relationship has attributes, they go into the new table. Sometimes one of them (usually a date) has to be part of the PK.

Example: AUTHOR (1,N) Writes (0,N) BOOK

- AUTHOR (<ins>author_code</ins>, ...)
- BOOK (<ins>book_code</ins>, ...)
- WRITES (<ins>*author_code*</ins>, <ins>*book_code*</ins>, ...) `author_code → AUTHOR`, `book_code → BOOK`

Why not just add columns? If we put `module1, module2, module3` inside `STUDENTS`, a student who signs up for a 4th module needs a new column, and students with fewer modules leave lots of nulls. Same problem the other way round. So N:M always gets its own table:

- STUDENTS (<ins>NIA</ins>, name, surnames)
- MODULES (<ins>code</ins>, name)
- ENROLMENTS (<ins>*NIA*</ins>, <ins>*code*</ins>, grade)

### 1:N relationships → propagate or new table

Two possible solutions:

1. **Propagate** the PK of the "1" side into the table of the "N" side, where it becomes a FK.
2. Create a **new table** for the relationship.

How to decide: look at the (min,max) of the entity whose maximum is 1 (the "1" side).

| Cardinality of the "1" side | What we do |
|---|---|
| **(1,1)** | **Propagate** the PK from the "1" side to the "N" side as a FK. Relationship attributes also go to the "N" side |
| **(0,1)** | **New table**. Its PK is the PK of the "N" side, and the PK of the "1" side is a FK. Relationship attributes go into this new table |

Case (1,1): EMPLOYEE (1,N) belongs_to (1,1) DEPARTMENT. Every employee belongs to exactly one department.

- DEPARTMENT (<ins>DeptNo</ins>, DeptName)
- EMPLOYEE (<ins>EmpNo</ins>, EmpName, *DeptNo*, HireDate) `DeptNo → DEPARTMENT`

`HireDate` was an attribute of the relationship, so it travels with the key to EMPLOYEE.

Case (0,1): PROPERTY (1,N) sold_to (0,1) CUSTOMER. A property may not be sold yet.

- PROPERTY (<ins>PropNo</ins>, PropAddress)
- CUSTOMER (<ins>Dni</ins>, CustName)
- SALE (<ins>*PropNo*</ins>, *Dni*, SaleDate) `PropNo → PROPERTY`, `Dni → CUSTOMER`

Why? If we propagated `Dni` into PROPERTY, every unsold property would have `Dni = NULL`. The new table avoids those nulls.

Note: the textbook simplifies this and says 1:M always propagates the key to the "M" side. The class slides add the (0,1) nuance, which is what the teacher expects.

### 1:1 relationships → propagate or new table

Two possible solutions:

1. Create a **new table**.
2. **Propagate** the PK of one entity, as a FK, into the table of the other entity.

How to decide: look at the cardinalities of **both** entities.

| Cardinalities | What we do |
|---|---|
| **(0,1) and (0,1)** | **New table**, same treatment as N:M. Both sides have occurrences that are not related, so propagating would create nulls |
| **(0,1) and (1,1)** | **Propagate** from the entity with (1,1) to the entity with (0,1) |
| **(1,1) and (1,1)** | **Propagate** in either direction. We choose |

Example: EMPLOYEE (1,1) Manages (0,1) DEPARTMENT. Each department has exactly one employee in charge, and an employee may or may not be in charge of a department.

- EMPLOYEE (<ins>Emp_Code</ins>, ...)
- DEPARTMENT (<ins>Dept_Code</ins>, ..., *Emp_Code*) `Emp_Code → EMPLOYEE`

`Emp_Code` in DEPARTMENT: nulls not allowed, it's an alternative key (`UNIQUE`), delete restricted and update in cascade.

Textbook example (TEACHERS / DEPARTMENTS, the department head): if we put `dept_id` in TEACHERS, only one teacher row would have a value. The right move is putting the head teacher's id (`Dept_head`) in DEPARTMENTS as a FK.

### Summary 1:N

| Cardinality of the entity with max 1 | How do we pass it to the relational model? |
|---|---|
| (1,N) and (0,1) | **CREATE** a new table with the PKs of both entities and the relationship attributes. The PK of the new table is the PK of the N side. Both keys are FKs to their tables |
| (1,N) and (1,1) | **PROPAGATE** the PK from the max-1 entity to the max-N entity as a FK. Relationship attributes go with it |

### Summary 1:1

| Entity cardinalities | How do we pass it to the relational model? |
|---|---|
| (0,1) and (0,1) | **CREATE** a new table using the PK of one of the entities as PK |
| (1,1) and (1,1) | **PROPAGATE** the PK from either entity to the other as a FK |
| (0,1) and (1,1) | **PROPAGATE** the PK from the (1,1) entity to the (0,1) entity, where it becomes a FK |

## Reflexive and ternary relationships

### Reflexive relationships (degree 1)

Same rules as before, but both sides are the **same entity**. The FK is the same PK repeated with a different name.

Example: DEPARTMENT (0,N) depends_on (0,1) DEPARTMENT, N:1. A department depends on at most one higher department.

Solution A, new table (no nulls):

- DEPARTMENT (<ins>dept_no</ins>, name, phone)
- DEPENDS (<ins>*dept_no*</ins>, *parent_dept_no*) both `→ DEPARTMENT`

Solution B, propagate (one null allowed, the head office department that depends on nobody, but we save a table):

- DEPARTMENT (<ins>dept_no</ins>, name, phone, *parent_dept_no*) `parent_dept_no → DEPARTMENT`

Textbook example 1:M (an employee has one boss):

- EMPLOYEES (<ins>DNI</ins>, Name, *BossDNI*) `BossDNI → EMPLOYEES`

Textbook example M:M (an employee can have several bosses): new table with the PK repeated twice.

- EMPLOYEES (<ins>DNI</ins>, Name)
- BOSSES (<ins>*Employee_DNI*</ins>, <ins>*Boss_DNI*</ins>) both `→ EMPLOYEES`

### Ternary relationships (degree 3)

Treated like N:M: a new table whose PK is the combination of the PKs of the three entities, plus the relationship attributes.

Example: SUBJECT, STUDENT and EXAM_SESSION related through `enrolled` (M:N:P), with attribute `grade`.

- SUBJECT (<ins>subject_code</ins>, subject_name)
- STUDENT (<ins>student_no</ins>, student_name)
- EXAM_SESSION (<ins>session_code</ins>, session_desc, session_date)
- ENROLMENT (<ins>*subject_code*</ins>, <ins>*student_no*</ins>, <ins>*session_code*</ins>, grade)

## Transforming attributes

### Entity attributes

General rule: each attribute becomes a column of the table created from its entity.

| Attribute type | What happens |
|---|---|
| Identifier (PK) | Becomes the PK of the table |
| Non-identifier | Becomes a regular column |
| Composite | Its simple parts become columns. The composite attribute itself disappears |
| Derived (calculated) | Removed from the table, unless you can justify keeping it |
| Multi-valued | Creates a **new table** with the attribute + the PK of the entity (which is also a FK). The PK of the new table is made of **all** its attributes |

Example: CUSTOMER with `Code` (PK), `Dni` (alternative key), `Name`, composite `Address` (Street, Number, Postcode, Town, Province), multi-valued `Phone` and derived `Balance`.

- CUSTOMER (<ins>Code</ins>, Dni, Name, Street, Number, Postcode, Town, Province)
- PHONE (<ins>*Code*</ins>, <ins>Phone</ins>) `Code → CUSTOMER`

`Address` is split into its parts, `Phone` gets its own table, and `Balance` is dropped because it can be calculated.

### Relationship attributes

- If the relationship becomes a table, its attributes become columns of that table.
- If the relationship is transformed by key propagation, its attributes travel with the key to the same table.
- Sometimes a relationship attribute, usually a **date**, has to be part of the PK.

Example: CUSTOMER (1,N) rents (0,N) VEHICLE, N:M, with `rental_date` and `return_date`. And VEHICLE (0,N) registered_in (1,1) TOWN, N:1, with `registration_date`.

- CUSTOMER (<ins>cust_dni</ins>, cust_name, cust_phone)
- RENTAL (<ins>*cust_dni*</ins>, <ins>*plate*</ins>, <ins>rental_date</ins>, return_date)
- VEHICLE (<ins>plate</ins>, plate_date, *town_code*, registration_date) `town_code → TOWN`
- TOWN (<ins>town_code</ins>, town_name)

`rental_date` is part of the PK because the same customer can rent the same car on different dates. Without it, the second rental would duplicate the PK.

## Weak entities

A weak entity depends on a strong one. How we transform it depends on the type of dependency.

| Dependency | PK of the weak entity's table |
|---|---|
| **Existence** | Only its own key attributes. Nothing is added to the PK (the strong entity's key goes in as a normal FK) |
| **Identification** | Its own key attributes **plus** the PK of the strong entity, which is also a FK |

Identification example: HOTEL (1,1) has (1,N) ROOM. Room number 101 exists in many hotels, so we need the hotel code to identify a room.

- HOTEL (<ins>code</ins>, name, address, phone)
- ROOM (<ins>*code*</ins>, <ins>room_no</ins>, type, price) `code → HOTEL`

Existence example (textbook): INVOICE depends on CUSTOMER. An invoice can't exist without its customer, and if the customer is deleted the invoice goes too. But the invoice number identifies the invoice by itself, so the customer's key is not added to the PK.

## Generalization / specialization

Example: PORT (Code, Name, City) with subtypes COMMERCIAL (Draft) and MARINA (Moorings).

| Option | What we do | When it fits |
|---|---|---|
| **A. One single table** | One table for the supertype with all attributes of all subtypes. If subtypes don't have distinct attributes, add a `type` column | Subtypes differ in very few attributes and have the same relationships (or none). Downside: nulls in the subtype-specific columns |
| **B. Supertype table + one table per subtype** | Each with its own attributes. Subtypes take the supertype's PK as PK and FK | Subtypes have different attributes and/or different relationships. Keeps common attributes together |
| **C. One table per subtype only** | Each subtype table includes its own attributes plus all the supertype's attributes. No supertype table | Total and exclusive hierarchies |

Option A:

- PORT (<ins>Code</ins>, Name, City, Draft, Moorings)

Option B:

- PORT (<ins>Code</ins>, Name, City)
- COMMERCIAL (<ins>*Code*</ins>, Draft) `Code → PORT`
- MARINA (<ins>*Code*</ins>, Moorings) `Code → PORT`

Option C:

- COMMERCIAL (<ins>Code</ins>, Name, City, Draft)
- MARINA (<ins>Code</ins>, Name, City, Moorings)

The textbook adds a 4th option: one single table like option A, but instead of a `type` column it adds boolean flags for each profile. Useful for **overlapping** hierarchies (one row can be several subtypes at once):

- FOOTBALLERS (<ins>code</ins>, name, shirt_number, team, goalsConceded, goalsScored, isGoalkeeper, isOutfield)

## Aggregations

No special rule. Aggregations are solved with the same principles as everything else. The aggregated relationship becomes a table, and that table's PK is what the outer relationship uses.

Example (textbook): SCHOOLS offer COURSES (aggregation OFFERS), and STUDENTS enrol in an offer.

- SCHOOLS (<ins>schoolCode</ins>, name, city)
- COURSES (<ins>courseId</ins>, name, family)
- OFFERS (<ins>*schoolCode*</ins>, <ins>*courseId*</ins>, places)
- STUDENTS (<ins>NIA</ins>, name, surnames)
- ENROLMENTS (<ins>*NIA*</ins>, <ins>*schoolCode*</ins>, <ins>*courseId*</ins>, date, attempts)

## Cheat sheet

| E/R element | Relational model |
|---|---|
| Strong entity | Table |
| N:M relationship | Always a new table. PK = PKs of both sides |
| 1:N with "1" side (1,1) | Propagate PK of the "1" side to the "N" side as FK |
| 1:N with "1" side (0,1) | New table. PK = PK of the "N" side, FK = PK of the "1" side |
| 1:1 (0,1)-(0,1) | New table |
| 1:1 (0,1)-(1,1) | Propagate from (1,1) to (0,1) |
| 1:1 (1,1)-(1,1) | Propagate in either direction |
| Reflexive | Same rules, PK repeated with a new name |
| Ternary | New table. PK = PKs of the three entities |
| Composite attribute | Split into simple columns |
| Multi-valued attribute | New table (attribute + entity PK). PK = all columns |
| Derived attribute | Remove it (or justify it) |
| Weak entity, existence | Own PK only |
| Weak entity, identification | Own key + strong entity's PK |
| Hierarchy | Option A (one table), B (super + subs) or C (subs only) |

Quick decision flow for a binary relationship:

```
Is it N:M?            → new table
Is it 1:N?            → is the "1" side (1,1)?  yes → propagate
                                                no (0,1) → new table
Is it 1:1?            → both (0,1)?             yes → new table
                                                no → propagate from the (1,1) side
```

## Practice exercises (solved)

Solutions as given in class.

### Exercise 1: Shipping company

SHIP (ship_no, name, build_date, length) with exclusive subtypes CARGO (tonnage, volume, m2) and CRUISE (passengers, crew). A cruise ship has (1,N) cabins, CABIN (cabin_no, berths, price), which is a weak entity by identification.

The hierarchy is solved with option C (one table per subtype), and CABIN takes the ship's PK as part of its own:

- CARGO (<ins>ship_no</ins>, name, build_date, length, tonnage, volume, m2)
- CRUISE (<ins>ship_no</ins>, name, build_date, length, passengers, crew)
- CABIN (<ins>*ship_no*</ins>, <ins>cabin_no</ins>, berths, price) `ship_no → CRUISE`

### Exercise 2: Suppliers, products and customers

- Supplier (CIF, Name, Address) (1,1) Supplies (1,N) Product (Code, Name, Price). 1:N
- Customer (DNI, Name, Surnames, Address, Date_of_birth) (0,N) Is_sold (1,N) Product. N:M

Solution:

- CUSTOMER (<ins>DNI</ins>, name, address, date_of_birth)
- PRODUCTS (<ins>Code</ins>, price, name, *Supplier_CIF*) `Supplier_CIF → SUPPLIER`
- IS_SOLD (<ins>*Customer_DNI*</ins>, <ins>*Product_code*</ins>) `→ CUSTOMER`, `→ PRODUCTS`
- SUPPLIER (<ins>CIF</ins>, name, address)

Note: the class solution writes `NIF` in SUPPLIER, but the diagram uses `CIF`. I kept CIF so the FK matches.

### Exercise 3: Trucks and parcels

- DRIVER drives TRUCK. N:M
- DRIVER delivers PARCEL. 1:N
- PARCEL goes to PROVINCE. N:1

Solution:

- TRUCK (<ins>Plate</ins>, model, type, power)
- DRIVES (<ins>*Truck_plate*</ins>, <ins>*Driver_DNI*</ins>) `→ TRUCK`, `→ DRIVER`
- DRIVER (<ins>DNI</ins>, name, address, phone, salary, town)
- PARCEL (<ins>Code</ins>, recipient, description, address, *Driver_DNI*, *Province_code*) `→ DRIVER`, `→ PROVINCE`
- PROVINCE (<ins>Code</ins>, name)

### Exercise 4: Library

- Author (Author_Code, Full_Name [Name, Surname_1, Surname_2]) (1,N) Writes (1,N) Book (Book_Code, ISBN, Title, Publisher, Page_Count). N:M
- Book (1,1) Has (1,N) Copy (Copy_Code, Location). 1:N, Copy is a weak entity by identification
- Copy (1,N) Is_Lent (1,N) User, with Loan_Date and Return_Date. N:M
- User (User_Code, Full_Name [...], Address [Street, Number, Postcode, Town], Phone multi-valued)

Solution:

- AUTHOR (<ins>author_code</ins>, name, surname1, surname2)
- WRITES (<ins>*book_code*</ins>, <ins>*author_code*</ins>)
- BOOK (<ins>book_code</ins>, ISBN, title, publisher, page_count)
- COPY (<ins>*book_code*</ins>, <ins>copy_code</ins>, location)
- LOAN (<ins>*book_code*</ins>, <ins>*copy_code*</ins>, <ins>*user_code*</ins>, <ins>loan_date</ins>, return_date)
- USER (<ins>user_code</ins>, name, surname1, surname2, street, number, town, postcode)
- PHONE (<ins>*user_code*</ins>, <ins>phone</ins>)

What to notice:

- Composite attributes (`Full_Name`, `Address`) are split into columns.
- The multi-valued `Phone` gets its own table.
- `COPY` includes `book_code` in its PK (identification dependency).
- In `LOAN`, the FK to `COPY` is composite (`book_code`, `copy_code`), and `loan_date` is part of the PK because the same user can borrow the same copy more than once.

### Exercise 5: Teachers, modules and students

- Teachers (DNI, Full_Name, Address [Street, Number, Town, Province], Phone multi-valued) (1,1) Teach (1,N) Modules (Code, Name). 1:N
- Modules (1,N) Enrol (1,N) Student (Record_No, Name, Surnames [Surname_1, Surname_2], Date_of_birth). N:M
- Student represents Student, reflexive (1,1) / (1,N)

Solution:

- TEACHERS (<ins>DNI</ins>, name, surname1, surname2, street, town, province, number)
- PHONE (<ins>*DNI*</ins>, <ins>Phone</ins>) `→ TEACHERS`
- MODULE (<ins>Code</ins>, name, *Teacher_DNI*) `→ TEACHERS`
- ENROLMENT (<ins>*Module_code*</ins>, <ins>*Record_no*</ins>) `→ MODULE`, `→ STUDENT`
- STUDENT (<ins>Record_no</ins>, name, surname1, surname2, birth_date, *Rep_record_no*) `→ STUDENT`

The reflexive relationship is solved by propagating the student's own PK under a new name (`Rep_record_no`).

## Video tutorials (from class)

- [E/R to relational model, N:M case](https://www.youtube.com/watch?v=2zpyUgD-Dcg)
- [E/R to relational model, 1:N case](https://www.youtube.com/watch?v=uibk7H0gbmg)
- [E/R to relational model, 1:1 case](https://www.youtube.com/watch?v=UY5b7rsbCFA)
- [Full example: previous unit's E/R diagram passed to the relational model](https://www.youtube.com/watch?v=Bb5mWzVb4dM)

## Case Studies

<img width="1024" height="520" alt="image" src="https://github.com/user-attachments/assets/14b84b43-8e9a-4ed5-aa9a-9abd65171cc8" />

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/7a914056-a938-451f-b019-d6f2c0efed9d" />
