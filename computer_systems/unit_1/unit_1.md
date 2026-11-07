# Architecture of a Computer System

## Contents

- Introduction
- Basic structure of a computer system
- Hardware
- Software
- Human factor
- Number systems
- Activity

## Introduction

Computer science is the science of processing information automatically, which today is done with computers.

It is a key tool in almost every field of human activity.

## Basic structure of a computer system

A computer system is made up of hardware, software and users (peopleware). Firmware is a special type of software written for a specific piece of hardware.

## Hardware

At a minimum, a PC needs processing (CPU), memory (RAM and secondary storage), peripherals (input, output or mixed) and a motherboard that connects everything.

The von Neumann architecture, first described in 1945, is still the architecture used in today's computers.

It consists of a CPU, which contains the arithmetic logic unit (ALU), the control unit (CU) and the registers.

The CPU is connected through buses to the memory unit (primary and volatile, or secondary and permanent). Communication between them goes both ways.

Finally, there is the input/output unit, also connected through buses, which is used to connect peripherals.

Memory can be represented as a pyramid. At the top are the CPU registers: the fastest, smallest and most expensive memory.

Below that is RAM, the main memory. It is volatile: it needs power to keep data, and loses everything stored in it as soon as the power goes off.

At the bottom is secondary storage: the slowest but also the cheapest, with a very large capacity.

The closer the memory is to the CPU, the faster and more expensive (higher cost per bit) it gets.

From top to bottom: registers (general or specific purpose), cache (L1, L2 and L3), main memory (RAM) and secondary storage (e.g., SSD, HDD, cloud).

Main CPU registers:

- PC (Program Counter): address of the next instruction.
- IR (Instruction Register): instruction currently being executed.
- ACC (Accumulator): stores intermediate ALU results.
- TR (Temporary Register): holds temporary operands for the ALU.
- SR (Status Register): flags with the state of the last operation (zero, carry, overflow...).
- MDR (Memory Data Register): data read from or written to memory.
- MAR (Memory Address Register): memory address being accessed.

The input/output unit handles the connections and adaptations needed between the CPU and the input, output or mixed peripherals.

There are three types of buses, depending on what they carry: data, address and control.

The instruction cycle works like this:

- Fetch: the control unit uses the PC to find the next instruction, which is read from RAM, carried to the CPU through the buses and stored in the IR.
- Decode: the control unit decodes the instruction.
- Execute: the execution phase starts.
- If operands are needed, the control unit fetches them from RAM and loads them into the ALU registers.
- The control unit tells the ALU which arithmetic or logic operation to perform.
- The result is stored in a register such as the ACC or written back to main memory.

## Software

Software can be divided into three levels:

- Application software
- Programming software
- System (base) software

By its freedom of use, software can be:

- Proprietary software
- Free software (respects the four essential freedoms: use, study, share and modify)

Other related concepts: freeware, adware, shareware, abandonware, copyleft and public domain.

Software can also be classified by its license:

- Open source
- Freeware
- Shareware
- Public domain

Creative Commons (CC) is an organization that offers standard licenses so creators can choose how others may use their work.

## Human factor

Users can be:

- End users (the majority)

Or professional users, who specialize in roles such as:

- Maintenance technicians
- Developers/programmers
- Network administrators
- Database administrators
- Web administrators

## Number systems

There are several number bases, like octal, decimal and hexadecimal, but computers only work with binary.

Storage units go from bits up to brontobytes. Each step up to the next unit is a power of 2: the exponent increases by 10 at each step (1 KiB = 2^10 bytes, 1 MiB = 2^20 bytes, and so on).

There are methods to convert a binary number to decimal and the other way around.

![Binary to Decimal](https://media.geeksforgeeks.org/wp-content/uploads/20211220193034/binary2.PNG "Binary to Decimal")

![Decimal to binary](https://files.prepinsta.com/wp-content/uploads/2022/01/Decimal-to-Binary-in-C-Program.png "Decimal to binary")
