# Architecture of a Computer System

## Contents

- Introduction
- Basic structure of a Computer System
- Hardware
- Software
- Human factor
- Representation systems
- Activity

## Introduction

Computer Science is the science that enables us to manage information automatically, currently done with computers.

It is a crucial tool in most human endeavours.

## Basic structure of a Computer System

The ecosystem is made of hardware, software (it can also be called firmware, which is specifically developed for a specific piece of hardware) and users/peopleware.

## Hardware

A PC has to be made of at least = processing power (CPU), storage (RAM and secondary memory), peripherals (input/output/mixed), and the Motherboard (which supports everything previously mentioned).

Von Newmann´s architecture, which was first described in 1945, still is the architecture use din today´s computers.

The architecture consists of a CPU, where there, things like the arithmetic-logical unit, the control unit and registers (input, storage or state) are located.

From there, through buses, that CPU is connected to the Storage unit (which can be primary and volatile, or secondary and permanent), and the relation between them is obviously bilateral in terms of communication/work.

Last, but not least, we hava the input/output unit, also connected through buses, to connect peripherals.

Storage/memory can be represented like a pyramid, where the top is the registers of the CPU, which is the fastest, smallest and most expensive one.

The next one is RAM, which is the principal memory but is also volatile and need electricy for it to store data, when not receiving energy, it dumps every bit of information stored.

The next one is the secondary memory, which is  the slowest one, but also the cheapest, and it has massive storage capacity.

The closer you get to the CPU, the more expensive (bigger cost for bit) and fast it gets.

We can also look at it like = Registers (general or specific purpose), caches (level 1, 2 or 3), primary memory (RAM), and Secondary Memory (e.g. SSD, HDD, Cloud...etc).

Registers can be : CP, RI, AC, RT, RE, RM, and RD.

The input/output unit realizes the necessary connections and adaptations of the CPU to input/output/mixed peripherals.

Buses can be specifically assigned to certain tasks like = Entry, direction, or control.

The cycle of instructions goes like this :

- First, the CPU (more precisely, the CU) looks for the instructions of the program (fetch) alongside with the CP, and then the instructions are retrieved from the RAM and brought to the CPU through buses, the instructions are saved in the RI.
- The CU decodes the instructions.
- After those first steps, the execution phase has started.
- If operands are needed, the CU retrieves them from the RAM to load them into the registers of the ALU.
- The CU signals the ALU to perform the isntructed operations and/or logic.
- The results are then stored in registers such as the AC or written back into the primary memory.

## Software

Software can be differentiated in three levels :

- Application level
- Programming software level
- Base software

Software can also be :

- Private software
- Public software (respects all 4 freedom levels)

Some suitable concepts according to our current context are : freeware, adware, sharewere, abandonware, copyleft, and public.

Software can also be differentiated ny its license :

- Open source
- Freeware
- Shareware
- Public

An organization that helps individuals manage license types is Creative Commons (CC)

## Human factor

Users can be :

- Final users (the majority of users)

OR Professional users, which can be specialized :

- Maintenance technicians
- Developers/Programmers
- Network administrators
- DDBB administrators
- Web administrators

## Representation systems

Although there are multiple numeric bases like : Octal, decimal, or hexadecimal.
Computers only talk and understand information in binary numeric base.

Storage units go from bits to brontobytes, each ladder taht we climb, we have to know that is by doing a power of 2, increasing the exponent by 1 in each step taht we undergo upwards (towards a bigger unit of storage/measure).

There is obviously a method to go from a binary number to a decimal one, and the other way around, but I won´t go into it for now.

That is it for this unit, future Darius ;).