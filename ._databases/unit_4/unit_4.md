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
| Foreign key (FK) | An attribute (or set) that is a candidate key in **another** table (or the same one). Used to link tables. FK and the referenced key must share the same domain | `NIA` inside `MATRICULAS` pointing to `ALUMNADO` |

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

Note: the textbook uses another notation (`#` in front of PK attributes and underline for FKs, e.g. `FUTBOLISTAS (#codigo, nombre, dorsal, equipo)`). Same idea, different symbols. In exams I follow the one the teacher uses in class (solid / dashed underline).

## Transforming entities

### General rule

Each entity becomes a table with the same name, and its attributes become columns.

PERSONA (<ins>atributo1</ins>, atributo2, ..., atributoN)

Example from the textbook (strong entity):

FUTBOLISTAS (<ins>codigo</ins>, nombre, dorsal, equipo)

## Transforming relationships (by cardinality)

How a relationship is transformed depends on its **cardinality**. That's the key to this whole unit.

Reminder about reading cardinalities: I use the look-across convention, so the (min,max) written next to an entity tells how many occurrences of **that** entity are related to one occurrence of the entity on the other side.

### N:M relationships → always a new table

- The new table's PK is the **concatenation of the PKs** of the entities it relates.
- Each of those attributes is part of the PK **and** a FK pointing to its original table.
- If the relationship has attributes, they go into the new table. Sometimes one of them (usually a date) has to be part of the PK.

Example: AUTOR (1,N) Escribe (0,N) LIBRO

- AUTOR (<ins>cod_autor</ins>, ...)
- LIBRO (<ins>cod_libro</ins>, ...)
- ESCRIBE (<ins>*cod_autor*</ins>, <ins>*cod_libro*</ins>, ...) `cod_autor → AUTOR`, `cod_libro → LIBRO`

Why not just add columns? If we put `modulo1, modulo2, modulo3` inside `ALUMNADO`, a student who signs up for a 4th module needs a new column, and students with fewer modules leave lots of nulls. Same problem the other way round. So N:M always gets its own table:

- ALUMNADO (<ins>NIA</ins>, nombre, apellidos)
- MODULOS (<ins>codigo</ins>, nombre)
- MATRICULAS (<ins>*NIA*</ins>, <ins>*codigo*</ins>, nota)

### 1:N relationships → propagate or new table

Two possible solutions:

1. **Propagate** the PK of the "1" side into the table of the "N" side, where it becomes a FK.
2. Create a **new table** for the relationship.

How to decide: look at the (min,max) of the entity whose maximum is 1 (the "1" side).

| Cardinality of the "1" side | What we do |
|---|---|
| **(1,1)** | **Propagate** the PK from the "1" side to the "N" side as a FK. Relationship attributes also go to the "N" side |
| **(0,1)** | **New table**. Its PK is the PK of the "N" side, and the PK of the "1" side is a FK. Relationship attributes go into this new table |

Case (1,1): EMPLEADO (1,N) pertenece (1,1) DEPARTAMENTO. Every employee belongs to exactly one department.

- DEPARTAMENTO (<ins>NumDep</ins>, NomDep)
- EMPLEADO (<ins>NumEmp</ins>, NomEmp, *NumDep*, Fechalta) `NumDep → DEPARTAMENTO`

`Fechalta` was an attribute of the relationship, so it travels with the key to EMPLEADO.

Case (0,1): INMUEBLE (1,N) vendido (0,1) CLIENTE. A property may not be sold yet.

- INMUEBLE (<ins>NumIn</ins>, DirIn)
- CLIENTE (<ins>Dni</ins>, NomCli)
- VENTA (<ins>*NumIn*</ins>, *Dni*, Fechaventa) `NumIn → INMUEBLE`, `Dni → CLIENTE`

Why? If we propagated `Dni` into INMUEBLE, every unsold property would have `Dni = NULL`. The new table avoids those nulls.

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

Example: EMPLEADO (1,1) Responsable (0,1) DEPARTAMENTO. Each department has exactly one employee in charge, and an employee may or may not be in charge of a department.

- EMPLEADO (<ins>Cod_E</ins>, ...)
- DEPARTAMENTO (<ins>Cod_D</ins>, ..., *Cod_E*) `Cod_E → EMPLEADO`

`Cod_E` in DEPARTAMENTO: nulls not allowed, it's an alternative key (`UNIQUE`), delete restricted and update in cascade.

Textbook example (PROFESORADO / DEPARTAMENTOS, the department head): if we put `id_dpt` in PROFESORADO, only one teacher row would have a value. The right move is putting the head teacher's id (`Jefe_dpt`) in DEPARTAMENTOS as a FK.

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

Example: DEPARTAMENTO (0,N) depende de (0,1) DEPARTAMENTO, N:1. A department depends on at most one higher department.

Solution A, new table (no nulls):

- DEPARTAMENTO (<ins>numdepto</ins>, nombre, tel)
- DEPENDE (<ins>*numdepto*</ins>, *numdepto_sup*) both `→ DEPARTAMENTO`

Solution B, propagate (one null allowed, the head office department that depends on nobody, but we save a table):

- DEPARTAMENTO (<ins>numdepto</ins>, nombre, tel, *numdepto_sup*) `numdepto_sup → DEPARTAMENTO`

Textbook example 1:M (an employee has one boss):

- EMPLEADOS (<ins>DNI</ins>, Nombre, *DNIJefe*) `DNIJefe → EMPLEADOS`

Textbook example M:M (an employee can have several bosses): new table with the PK repeated twice.

- EMPLEADOS (<ins>DNI</ins>, Nombre)
- JEFES (<ins>*DNI_empleado*</ins>, <ins>*DNI_jefe*</ins>) both `→ EMPLEADOS`

### Ternary relationships (degree 3)

Treated like N:M: a new table whose PK is the combination of the PKs of the three entities, plus the relationship attributes.

Example: ASIGNATURA, ALUMNO and CONVOCATORIA related through `matriculado` (M:N:P), with attribute `calif`.

- ASIGNATURA (<ins>codasig</ins>, nomasig)
- ALUMNO (<ins>numat</ins>, nomalu)
- CONVOCATORIA (<ins>codconv</ins>, desconv, fechaconv)
- MATRICULA (<ins>*codasig*</ins>, <ins>*numat*</ins>, <ins>*codconv*</ins>, calif)

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

Example: CLIENTE with `Codigo` (PK), `Dni` (alternative key), `Nombre`, composite `Direc` (Calle, Numero, D_postal, Poblac, Prov), multi-valued `Telef` and derived `Saldo`.

- CLIENTE (<ins>Codigo</ins>, Dni, Nombre, Calle, Numero, D_Postal, Poblac, Prov)
- TELEFONO (<ins>*Codigo*</ins>, <ins>Telef</ins>) `Codigo → CLIENTE`

`Direc` is split into its parts, `Telef` gets its own table, and `Saldo` is dropped because it can be calculated.

### Relationship attributes

- If the relationship becomes a table, its attributes become columns of that table.
- If the relationship is transformed by key propagation, its attributes travel with the key to the same table.
- Sometimes a relationship attribute, usually a **date**, has to be part of the PK.

Example: CLIENTE (1,N) alquilado (0,N) VEHICULO, N:M, with `fechaalq` and `fechadev`. And VEHICULO (0,N) censado (1,1) MUNICIPIO, N:1, with `fechacenso`.

- CLIENTE (<ins>dnicli</ins>, nomcli, telcli)
- ALQUILER (<ins>*dnicli*</ins>, <ins>*matricula*</ins>, <ins>fechaalq</ins>, fechadev)
- VEHICULO (<ins>matricula</ins>, fechamat, *codmun*, fechacenso) `codmun → MUNICIPIO`
- MUNICIPIO (<ins>codmun</ins>, nommun)

`fechaalq` is part of the PK because the same client can rent the same car on different dates. Without it, the second rental would duplicate the PK.

## Weak entities

A weak entity depends on a strong one. How we transform it depends on the type of dependency.

| Dependency | PK of the weak entity's table |
|---|---|
| **Existence** | Only its own key attributes. Nothing is added to the PK (the strong entity's key goes in as a normal FK) |
| **Identification** | Its own key attributes **plus** the PK of the strong entity, which is also a FK |

Identification example: HOTEL (1,1) posee (1,N) HABITACION. Room number 101 exists in many hotels, so we need the hotel code to identify a room.

- HOTEL (<ins>cod</ins>, nombre, dir, tel)
- HABITACION (<ins>*cod*</ins>, <ins>numhab</ins>, tipo, precio) `cod → HOTEL`

Existence example (textbook): FACTURA depends on CLIENTE. An invoice can't exist without its client, and if the client is deleted the invoice goes too. But the invoice number identifies the invoice by itself, so the client's key is not added to the PK.

## Generalization / specialization

Example: PUERTO (Codigo, Nombre, Ciudad) with subtypes COMERCIAL (Calado) and DEPORTIVO (Amarres).

| Option | What we do | When it fits |
|---|---|---|
| **A. One single table** | One table for the supertype with all attributes of all subtypes. If subtypes don't have distinct attributes, add a `tipo` column | Subtypes differ in very few attributes and have the same relationships (or none). Downside: nulls in the subtype-specific columns |
| **B. Supertype table + one table per subtype** | Each with its own attributes. Subtypes take the supertype's PK as PK and FK | Subtypes have different attributes and/or different relationships. Keeps common attributes together |
| **C. One table per subtype only** | Each subtype table includes its own attributes plus all the supertype's attributes. No supertype table | Total and exclusive hierarchies |

Option A:

- PUERTO (<ins>Codigo</ins>, Nombre, Ciudad, Calado, Amarres)

Option B:

- PUERTO (<ins>Codigo</ins>, Nombre, Ciudad)
- COMERCIAL (<ins>*Codigo*</ins>, Calado) `Codigo → PUERTO`
- DEPORTIVO (<ins>*Codigo*</ins>, Amarres) `Codigo → PUERTO`

Option C:

- COMERCIAL (<ins>Codigo</ins>, Nombre, Ciudad, Calado)
- DEPORTIVO (<ins>Codigo</ins>, Nombre, Ciudad, Amarres)

The textbook adds a 4th option: one single table like option A, but instead of a `tipo` column it adds boolean flags for each profile. Useful for **overlapping** hierarchies (one row can be several subtypes at once):

- FUTBOLISTAS (<ins>codigo</ins>, nombre, dorsal, equipo, golesEncajados, golesMarcados, esPortero, esDeCampo)

## Aggregations

No special rule. Aggregations are solved with the same principles as everything else. The aggregated relationship becomes a table, and that table's PK is what the outer relationship uses.

Example (textbook): CENTROS offer CICLOS (aggregation OFERTAS), and ALUMNADO enrols in an offer.

- CENTROS (<ins>codigoCentro</ins>, nombre, ciudad)
- CICLOS (<ins>idCiclo</ins>, nombre, familia)
- OFERTAS (<ins>*codigoCentro*</ins>, <ins>*idCiclo*</ins>, plazas)
- ALUMNADO (<ins>NIA</ins>, nombre, apellidos)
- MATRICULAS (<ins>*NIA*</ins>, <ins>*codigoCentro*</ins>, <ins>*idCiclo*</ins>, fecha, convocatorias)

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

### Exercise 1: Shipping company (Naviera)

BARCO (numbarco, nombre, feconst, eslora) with exclusive subtypes CARGA (tm, vol, m2) and CRUCERO (pl, tp). A cruise ship has (1,N) cabins, CAMAROTE (numcam, plazas, precio), which is a weak entity by identification.

The hierarchy is solved with option C (one table per subtype), and CAMAROTE takes the ship's PK as part of its own:

- CARGA (<ins>numbarco</ins>, nombre, feconst, eslora, tm, vol, m2)
- CRUCERO (<ins>numbarco</ins>, nombre, feconst, eslora, pl, tp)
- CAMAROTE (<ins>*numbarco*</ins>, <ins>numcam</ins>, plazas, precio) `numbarco → CRUCERO`

### Exercise 2: Suppliers, products and customers

- Proveedor (CIF, Nombre, Direccion) (1,1) Suministra (1,N) Producto (Codigo, Nombre, Precio). 1:N
- Cliente (DNI, Nombre, Apellidos, Direccion, Fecha de nacimiento) (0,N) Se vende (1,N) Producto. N:M

Solution:

- CLIENTE (<ins>DNI</ins>, nombre, direccion, fecha_de_nacimiento)
- PRODUCTOS (<ins>Codigo</ins>, precio, nombre, *CIF_proveedor*) `CIF_proveedor → PROVEEDOR`
- SE_VENDE (<ins>*DNI_cliente*</ins>, <ins>*Codigo_producto*</ins>) `→ CLIENTE`, `→ PRODUCTOS`
- PROVEEDOR (<ins>CIF</ins>, nombre, direccion)

Note: the class solution writes `NIF` in PROVEEDOR, but the diagram uses `CIF`. I kept CIF so the FK matches.

### Exercise 3: Trucks and parcels

- CAMIONERO drives CAMION. N:M
- CAMIONERO delivers PAQUETE. 1:N
- PAQUETE goes to PROVINCIA. N:1

Solution:

- CAMION (<ins>Matricula</ins>, modelo, tipo, potencia)
- CONDUCE (<ins>*Matricula_camion*</ins>, <ins>*DNI_camionero*</ins>) `→ CAMION`, `→ CAMIONERO`
- CAMIONERO (<ins>DNI</ins>, nombre, direccion, telefono, salario, poblacion)
- PAQUETE (<ins>Codigo</ins>, destinatario, descripcion, direccion, *DNI_camionero*, *codigo_provincia*) `→ CAMIONERO`, `→ PROVINCIA`
- PROVINCIA (<ins>Codigo</ins>, nombre)

### Exercise 4: Library

- Autor (Codigo_Autor, Nombre_Completo [Nombre, Apellido_1, Apellido_2]) (1,N) Escribe (1,N) Libro (Codigo_Libro, ISBN, Titulo, Editorial, Numero_Paginas). N:M
- Libro (1,1) Tiene (1,N) Ejemplar (Codigo_Ejemplar, Localizacion). 1:N, Ejemplar is a weak entity by identification
- Ejemplar (1,N) Es_Prestado (1,N) Usuario, with Fecha_Prestamo and Fecha_Devolucion. N:M
- Usuario (Codigo_Usuario, Nombre_Completo [...], Direccion [Via, Numero, CP, Poblacion], Telefono multi-valued)

Solution:

- AUTOR (<ins>cod_autor</ins>, nombre, apellido1, apellido2)
- ESCRIBE (<ins>*cod_libro*</ins>, <ins>*cod_autor*</ins>)
- LIBRO (<ins>cod_libro</ins>, ISBN, titulo, editorial, num_pag)
- EJEMPLAR (<ins>*cod_libro*</ins>, <ins>cod_ejemplar</ins>, localizacion)
- PRESTADO (<ins>*cod_libro*</ins>, <ins>*cod_ejem*</ins>, <ins>*cod_usu*</ins>, <ins>fec_pres</ins>, fec_dev)
- USUARIO (<ins>cod_usu</ins>, nom, apell1, apell2, via, num, pob, cp)
- TELEFONO (<ins>*cod_usu*</ins>, <ins>telefono</ins>)

What to notice:

- Composite attributes (`Nombre_Completo`, `Direccion`) are split into columns.
- The multi-valued `Telefono` gets its own table.
- `EJEMPLAR` includes `cod_libro` in its PK (identification dependency).
- In `PRESTADO`, the FK to `EJEMPLAR` is composite (`cod_libro`, `cod_ejem`), and `fec_pres` is part of the PK because the same user can borrow the same copy more than once.

### Exercise 5: Teachers, modules and students

- Profesores (DNI, Nombre_Completo, Direccion [Calle, Numero, Localidad, Provincia], Telefono multi-valued) (1,1) Imparten (1,N) Modulos (Codigo, Nombre). 1:N
- Modulos (1,N) Matriculan (1,N) Alumno (N_Expediente, Nombre, Apellidos [Apellido_1, Apellido_2], Fecha_de_nacimiento). N:M
- Alumno represents Alumno, reflexive (1,1) / (1,N)

Solution:

- PROFESORES (<ins>DNI</ins>, nombre, apellido1, apellido2, calle, localidad, provincia, numero)
- TELEFONO (<ins>*DNI*</ins>, <ins>Telefono</ins>) `→ PROFESORES`
- MODULO (<ins>Codigo</ins>, nombre, *DNI_profesor*) `→ PROFESORES`
- MATRICULACION (<ins>*Codigo_modulo*</ins>, <ins>*N_expediente*</ins>) `→ MODULO`, `→ ALUMNO`
- ALUMNO (<ins>N_expediente</ins>, nombre, apellido1, apellido2, fec_nac, *N_expediente_repre*) `→ ALUMNO`

The reflexive relationship is solved by propagating the student's own PK under a new name (`N_expediente_repre`).

## Video tutorials (from class)

- [E/R to relational model, N:M case](https://www.youtube.com/watch?v=2zpyUgD-Dcg)
- [E/R to relational model, 1:N case](https://www.youtube.com/watch?v=uibk7H0gbmg)
- [E/R to relational model, 1:1 case](https://www.youtube.com/watch?v=UY5b7rsbCFA)
- [Full example: previous unit's E/R diagram passed to the relational model](https://www.youtube.com/watch?v=Bb5mWzVb4dM)

## Case Studies

<img width="1024" height="520" alt="image" src="https://github.com/user-attachments/assets/14b84b43-8e9a-4ed5-aa9a-9abd65171cc8" />

<img width="1024" height="572" alt="image" src="https://github.com/user-attachments/assets/7a914056-a938-451f-b019-d6f2c0efed9d" />
