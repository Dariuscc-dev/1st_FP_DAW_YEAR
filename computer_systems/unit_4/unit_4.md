# Unit 4: Operating System Fundamentals and Virtualization

## Overview & Contents
- **What an operating system is** and how it evolved.
- **OS components:** kernel, file and I/O manager, shell (CLI / GUI) and permissions.
- **OS structures:** layered, monolithic kernel and microkernel.
- **Types of operating systems.**
- **Main functions:** process, memory, I/O and file management.
- **Virtualization:** hypervisor types, containers, virtual networks, virtual disks and snapshots.
- **Hands-on:** installing VirtualBox, Ubuntu Desktop and Windows 11 as virtual machines.

## What an Operating System Is
An operating system (OS) is the **interface between the user (and their applications) and the hardware** it is installed on.

- It makes using the hardware **easier, more efficient and safer** for programs and users.
- It is a **resource manager**: it shares CPU time, RAM, storage and I/O devices between concurrent processes.
- It only runs on the computers it was designed for.
- User applications depend on the OS you choose.

### Evolution
| Generation | Technology | OS model |
|---|---|---|
| 1st (1945-1955) | Vacuum tubes | No OS |
| 2nd (1955-1965) | Transistors | Batch processing |
| 3rd (1965-1980) | Integrated circuits | Multiprogramming appears |
| 4th (1980-today) | Microprocessors | Multitasking systems |

## Components of an OS
### Kernel
The core module, in direct contact with the hardware.

- **Interrupt handling:** responds to hardware and software events.
- **Process and CPU management:** decides which task runs at each moment, creates and destroys processes and lets them communicate. CPU time must be used as much as possible.
- **Memory management:** allocates and frees memory and decides how much each process gets.

### File and I/O manager
- **File and storage management:** a suitable method to store and retrieve data, keeping file systems accessible and secure.
- **I/O management:** controls input and output devices so communication channels work properly, without blocking, and adapted to each device.

### Shell (interface and interpreter)
The layer that talks directly to users.

| Element | Description |
|---|---|
| **CLI** | Command line interpreter (Bash, PowerShell) |
| **GUI** | Graphical desktop with windows and icons |
| **Permissions** | User control and access levels to resources |

## OS Structures
| Structure | How it works | Example |
|---|---|---|
| **Layered (hierarchical)** | The kernel is split into layers; each layer has its own functions and only talks to the adjacent ones. Easier to run and maintain | Windows |
| **Monolithic kernel** | All system functions live in procedures inside the kernel, which must be fully loaded in memory | Linux |
| **Microkernel** | Only the minimum basic functions stay in a tiny kernel; everything else runs as external modules loaded when needed | Symbian |

## Types of Operating Systems
| Criterion | Types |
|---|---|
| Simultaneous tasks | **Single-tasking** (one process) / **Multitasking** (several programs at once) |
| Number of processors | **Single-processor** / **Multiprocessor** |
| Role | **Server** (offers services to other systems: Windows Server, Red Hat Enterprise Linux Server) / **Client** (works with users and uses server services: Windows 11, macOS 14, Ubuntu) |
| Simultaneous users | **Single-user** / **Multi-user** |

- **Embedded OS:** no user interface or a very limited one, built to run autonomously for long periods (home appliances, network hardware, vehicles).
- **Cloud / distributed OS:** only a small part runs on the user's machine; most computing and storage live on an Internet server. Cheaper client hardware, but it needs a permanent connection.

## Main Functions
The OS has two big jobs: **manage the hardware** as efficiently as possible and **make the user's work easier** when communicating with the machine.

### Process management
- A **program** is a static file on disk. A **process** is a program in execution, with its own resources (memory, CPU time, state).
- Processes go through states. The classic model is: **new → ready → running → blocked (waiting for I/O) → ready ... → terminated**.
- The **scheduler** decides, using different algorithms, which process runs next.

### Memory management
The **memory manager (MMU)** assigns RAM space to processes, prevents unauthorized access between them and frees areas when they finish.

| Technique | How it works | Key point |
|---|---|---|
| **Fixed partitions** | Memory is split into partitions of different sizes. Each queued process goes into the free partition that best fits its size | We know each process's memory needs in advance |
| **Variable partitions** | Each process gets exactly the space it needs, using a **base address** plus an **offset** (its size) | Avoids internal fragmentation; when memory runs out, **compaction** is done |
| **Swapping** | Processes are moved between RAM and secondary storage when physical memory is full | Lets the system keep working when RAM is saturated |

### I/O management
Handles the exchange of information between peripherals (input, output and input/output) and the user. In between there are intermediate elements that process the data: **spool** and **buffer**.

### File management
Data must be stored on a device that allows safe storage and retrieval over time. The OS manages secondary storage and the data in it, usually as a **tree structure** of directories and files, with the required information for each file.

## Virtualization
**Virtualization** creates virtual or simulated environments from a single physical machine, using software called a **hypervisor**. Instead of one physical computer per task, it divides the hardware resources (CPU, RAM, storage and network) to run several independent **virtual machines (VMs)** at the same time. Each VM works like a separate computer with its own OS.

| Type | How it runs | Examples | Notes |
|---|---|---|---|
| **Native (Type 1)** | Hypervisor runs directly on the hardware | VMware ESXi, Hyper-V, Proxmox | Maximum performance and isolation |
| **Hosted (Type 2)** | Hypervisor runs on top of a normal OS (host) | VirtualBox, VMware Workstation | Small performance loss; ideal for practice and students |
| **Containers** | Virtualization at OS level | Docker | Isolates apps without a full OS; very fast start and low RAM; standard in modern web deployment |

### Virtual network modes (VirtualBox)
| Mode | What it means |
|---|---|
| **NAT** | The VM goes out to the Internet through the host; it is not visible from the local network |
| **Bridged** | The VM appears on the physical network as one more machine with its own IP |
| **Internal network** | VMs only see each other |
| **Host-only** | The VM only talks to the host (and other host-only VMs) |

### Virtual disk allocation
| Option | How it works | Pro |
|---|---|---|
| **Fixed (pre-allocated)** | The full size (e.g. 40 GB) is taken on the real disk when the VM is created | Faster read/write |
| **Dynamic** | The file grows as the VM saves data, up to the set limit | Less space at the start |
| **Snapshot** | Saves the exact state of the VM so you can restore it if a test or setting fails | Safe rollback |

### Basic requirements
| OS | CPU | RAM | Disk |
|---|---|---|---|
| Windows 11 | 2+ cores | 4 GB | 64 GB |
| Ubuntu Desktop LTS | 2+ cores | 4 GB | 25 GB |

Steps: download the official ISO, check the requirements, then assign RAM, vCPUs and create the virtual disk before starting the installer.

## Hands-on: VirtualBox Setup
### Oracle VirtualBox + Extension Pack
VirtualBox is a free, open-source **Type 2** hypervisor that runs several **guest** OSs on top of the **host** OS.

1. Download the installer for your host OS from virtualbox.org.
2. Run it with the default wizard (the network card restarts briefly during setup).
3. Download and install the **Extension Pack** from the same page (USB 2.0/3.0, disk encryption, NVMe boot).

### Ubuntu Desktop LTS VM
1. VirtualBox → **New**.
2. Name: `Ubuntu-DAW` | Type: Linux | Version: Ubuntu (64-bit).
3. RAM: at least 4096 MB (8 GB recommended if the host has 16 GB).
4. CPUs: 2 cores.
5. Disk: dynamic **VDI**, 25-30 GB minimum.
6. Start the VM, select the Ubuntu ISO and run the graphical installer.
7. Choose language, keyboard, normal install with updates, and create the admin user.
8. Once installed: **Devices > Insert Guest Additions CD image** to enable full screen and shared clipboard.

### Windows 11 VM
1. VirtualBox → **New**.
2. Name: `Windows11-DAW` | Type: Microsoft Windows | Version: Windows 11 (64-bit).
3. RAM: 4096 MB minimum | CPUs: 2 vCPUs minimum.
4. In **System**, tick **Enable EFI** and enable **TPM 2.0**.
5. Disk: 64 GB VDI, dynamically allocated.
6. Mount the Windows 11 ISO, boot the VM and follow the official installer.

## Cheat Sheet
| Question | Answer |
|---|---|
| Module in direct contact with the hardware | Kernel |
| Bash or PowerShell | CLI (shell) |
| Linux kernel structure | Monolithic |
| Windows structure | Layered |
| Program vs process | A process is a program in execution |
| Who picks the next process to run | The scheduler |
| Moving processes between RAM and disk | Swapping |
| Variable partitions use... | Base address + offset, and compaction when memory runs out |
| Hypervisor on bare metal | Type 1 (ESXi, Hyper-V, Proxmox) |
| Hypervisor on top of an OS | Type 2 (VirtualBox, VMware Workstation) |
| App isolation without a full OS | Containers (Docker) |
| Save a VM state to roll back | Snapshot |
| Windows 11 VM needs... | EFI + TPM 2.0 |
