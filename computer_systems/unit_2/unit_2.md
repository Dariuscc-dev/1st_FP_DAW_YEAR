# Hardware and mountage

## Contents

- Motherboard
- CPU and microprocessors
- Principal memory
- Storeage and secondary memory
- Expansion cards

## Motherboard

Phisically printed ircuit which connects every internal component and also external peripherals.

Form factor is also a very important thing, as it standarizes and makes motherboards inter-compatible.

The market standard is either: 

- ATX (developed by Intel)
- ITX (developed by VIA technologies)

The complete image we can have for form factors is:

- E-ATX
- ATX
- Micro-ATX
- Mini-ITX

<img width="1107" height="607" alt="image" src="https://github.com/user-attachments/assets/a28bc120-c189-41c2-9877-e47bffa42ccc" />

## CPU and microprocessors

The chipset is a set of integrated circuits that help the CPU communicate and manage processes (memory, processes, peripherals...etc).

The chipset was before divided into horthbridge and southbridge, but later evolver to a single, enerything-included chipset.

The CPU connect directly through PCIe to the GPU and RAM, then, though the chipset (DMI/DFI Bus), it connects to the chipset (PCH/FCH), which helps the CPU connect to all other components and peripherals (SATA, NVMe PCIe x4, USB 3.2, Audio, LAN RJ-45, BIOS / UEFI).

The socket of the CPU can be: LGA, PGA or BGA.

<img width="340" height="260" alt="image" src="https://github.com/user-attachments/assets/a3ae5077-2341-4d9f-beeb-20c29b3d65d9" />

## Principal memory

We have slots, which allows us to connect RAM (DDR1 -DDR5).

It can be dual-channel and quad-channel.

Expansion slots can enable us to better the specificattions fo out motherboard, this can be done through :

- SSDs
- GPUs
- Audio
- Network adapters

<img width="625" height="421" alt="image" src="https://github.com/user-attachments/assets/a1ae6dad-6491-4a90-936e-063425c806e5" />

When talking about adapters, we have:

- Storage connector (like SATA or M.2)
- Audio connectors (like HDMI or VGA)
- Network connectors (like Ethernet)
- Energy connectors 

## CPU and Microprocessors (Continued)

### Key Features and Performance
- **CPU Registers:** High-speed storage locations directly inside the CPU for temporary data access during processing.
- **Cache Memory:**
  - **L1:** Fastest and smallest.
  - **L2:** Intermediate speed and capacity.
  - **L3:** Largest capacity, but slowest among the three.
- **Performance Metrics:**
  - **Clock Frequency:** Internal speed measured in MHz or GHz.
  - **IPS / MIPS:** Instructions / Million Instructions Per Second.
  - **FLOPS:** Floating-point Operations Per Second.
- **Power and TDP:**
  - **TDP (Thermal Design Power):** Maximum heat emitted (in Watts) that the cooling system must dissipate.
- **Internal Architecture:**
  - **Cores & Threads:** Independent internal CPUs and light execution processes for simultaneous multi-tasking.
  - **32 / 64-bit Architecture:** Register width and memory address space.

### Architecture Types and Manufacturers
- **CISC (Intel / AMD x86):**
  - Complex and variable-length instructions.
  - Fewer internal registers.
  - Traditionally higher power consumption (higher TDP).
- **RISC (ARM / Qualcomm / Apple Silicon):**
  - Simple and fixed-length instructions.
  - Many internal registers.
  - Highly power-optimized (lower TDP).
- **Manufacturers:**
  - **Intel:** Founded in 1968; created the x86 architecture and released the first commercial microprocessor (Intel 4004) in 1971.
  - **AMD:** Founded in 1969; second largest x86 provider (entered x86 market in 1975 with the AM9080).

---

## Principal Memory

### Memory Hierarchy
1. **CPU Registers** (Highest speed/cost, lowest capacity).
2. **CPU Cache (L1, L2, L3)** (SRAM).
3. **Principal Memory (RAM)** (DRAM, volatile).
4. **Secondary Storage** (SSD / HDD, non-volatile).
5. **Network / Cloud Storage** (NAS, SAN, Cloud).

### RAM Performance Parameters
- **Bus Width:** Amount of data transferred per second (currently 64 bits).
- **CAS Latency (CL):** Response time delay to a CPU command (measured in clock cycles).
- **DRAM vs. SRAM:**
  - **DRAM (Dynamic RAM):** Requires continuous data refreshing; used for main system memory.
  - **SRAM (Static RAM):** No refresh needed, extremely fast but expensive; used for Cache.

### Non-Volatile Memory Types (ROM)
- **ROM:** Factory-written.
- **PROM:** Programmable once.
- **EPROM:** Erasable via UV light.
- **EEPROM:** Electrically erasable and programmable.

---

## Storage and Secondary Memory

### Characteristics
- Non-volatile, high capacity, slower than primary memory, but with a significantly lower cost per GB.

### Storage Technologies
- **HDD (Magnetic):** Mechanical drive organized by tracks, sectors, and cylinders. Typical speeds range from 3,200 to 15,000 RPM.
- **SSD (Solid State):** Zero moving parts; uses Flash memory cells (SLC, MLC, TLC, QLC). Lifespan is measured in **TBW** (*Terabytes Written*).
- **NVMe Protocol:** Ultra-fast M.2 drives connected directly to the PCIe bus, bypassing SATA bottleneck limits.
- **Optical Storage:**
  - **CD:** Red laser (780 nm), typical capacity ~700 MB.
  - **DVD:** Red laser (650 nm), capacity from 4.7 GB to 8.5 GB.
  - **Blu-ray:** Blue-violet laser (405 nm), capacity from 25 GB to 100 GB+.

### Networked Storage Architectures
- **DAS (Direct-Attached Storage):** Local disk attached directly to the PC.
- **NAS (Network-Attached Storage):** Dedicated local network file server; ideal for backups.
- **SAN (Storage Area Network):** Dedicated high-speed block-level network (Fibre Channel) used in virtualization and cloud environments.

---

## Expansion Cards
- **Graphics Cards (GPU):** Parallel processing hardware with its own GPU core and dedicated memory (GDDR).
- **Other Cards:** Network interface cards (Ethernet / Wi-Fi), Sound cards, Multimedia capture cards, and Port expansion cards (USB, SATA).

---

## Peripherals
- **Input Devices:** Mechanical keyboard, optical mouse, scanner.
- **Output Devices:** OLED monitor, speakers, laser printer.
- **Mixed Input/Output (I/O) Devices:** External NVMe SSD, Wi-Fi router, touch screen.